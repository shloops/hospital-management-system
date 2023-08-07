package hospital.diagnosis.logic;

import hospital.diagnosis.communication.client.DiagnoseClient;
import hospital.diagnosis.communication.client.ParseClient;
import hospital.diagnosis.domain.Diagnosis;
import hospital.diagnosis.domain.Patient;
import hospital.diagnosis.persistence.DiagnosisDTO;
import hospital.diagnosis.persistence.ParserDTO;
import hospital.diagnosis.persistence.PatientDTO;
import hospital.diagnosis.persistence.SymptomDTO;
import hospital.diagnosis.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiagnosisService {
    private final PatientRepository patientRepository;
    private final ParseClient parseClient;
    private final dtoConverter dtoConverter;

    private final DiagnoseClient diagnoseClient;

    public DiagnosisService(PatientRepository patientRepository, ParseClient parseClient, hospital.diagnosis.logic.dtoConverter dtoConverter, DiagnoseClient diagnoseClient) {
        this.patientRepository = patientRepository;
        this.parseClient = parseClient;
        this.dtoConverter = dtoConverter;
        this.diagnoseClient = diagnoseClient;
    }

    public Diagnosis diagnosePatient(Patient patient) {

        return new Diagnosis();
    }
    public Patient diagnose(PatientDTO patientDTO) {
        ParserDTO parserDTO = dtoConverter.convertFromPatientDtoToParserDTO(patientDTO);
        var symptoms = Arrays.asList(parseClient.parseDescriptionOfSymptoms(parserDTO));
        List<SymptomDTO> symptomDTOs = symptoms.stream().map(symptom -> dtoConverter.convertFromSymptomToSymptomDTO(symptom)).collect(Collectors.toList());

        DiagnosisDTO diagnosisDTO = new DiagnosisDTO(patientDTO.getSex(), parserDTO.getAge(), symptomDTOs);
        List<Diagnosis> diagnoses = Arrays.asList(diagnoseClient.diagnose(diagnosisDTO));

        Patient patient = dtoConverter.convertFromDtoToPatient(patientDTO);
        patient.setSymptoms(symptoms);
        patient.setDiagnoses(diagnoses);

        return patientRepository.save(patient);
    }
}
