package hospital.diagnosis.logic;

import hospital.diagnosis.communication.client.ParseClient;
import hospital.diagnosis.domain.Diagnosis;
import hospital.diagnosis.domain.Patient;
import hospital.diagnosis.persistence.ParserDTO;
import hospital.diagnosis.persistence.PatientDTO;
import hospital.diagnosis.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DiagnosisService {
    private final PatientRepository patientRepository;
    private final ParseClient parseClient;
    private final dtoConverter dtoConverter;

    public DiagnosisService(PatientRepository patientRepository, ParseClient parseClient, hospital.diagnosis.logic.dtoConverter dtoConverter) {
        this.patientRepository = patientRepository;
        this.parseClient = parseClient;
        this.dtoConverter = dtoConverter;
    }

    public Diagnosis diagnosePatient(Patient patient) {

        return new Diagnosis();
    }
    public Patient diagnose(PatientDTO patientDTO) {
        ParserDTO parserDTO = dtoConverter.convertFromPatientDtoToParserDTO(patientDTO);
        var symptoms = Arrays.asList(parseClient.parseDescriptionOfSymptoms(parserDTO));

        Patient patient = new Patient();
        //TODO patient.setSyptoms(symptoms);
        //TODO patient.setDiagnoses(diagnoses);
        //diagnoseClient sends symptoms with age and sex to infermedica
        //mak patient with properties from both
    }
}
