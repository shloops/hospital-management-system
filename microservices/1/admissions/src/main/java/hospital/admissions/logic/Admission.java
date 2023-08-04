package hospital.admissions.logic;

import hospital.admissions.communication.client.DiagnosesClient;
import hospital.admissions.domain.Patient;
import hospital.admissions.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.util.List;
import java.util.Optional;

@Service
public class Admission {
    private final PatientRepository patientRepository;
    private final UUIDProvider uuidProvider;
    private final PatientDTOMapper patientDTOMapper;
    private final DiagnosesClient diagnosesClient;

    public Admission(PatientRepository patientRepository, UUIDProvider uuidProvider, PatientDTOMapper patientDTOMapper, DiagnosesClient diagnosesClient) {
        this.patientRepository = patientRepository;
        this.uuidProvider = uuidProvider;
        this.patientDTOMapper = patientDTOMapper;
        this.diagnosesClient = diagnosesClient;
    }

    public Patient admit(Patient patient) {
        uuidProvider.provideUuid(patient);
        try {
            //diagnosesClient.forwardPatientForDiagnosis(patientDTOMapper.mapPatientToDTO(patient));
            patient.setForwardedToDiagnosis(true);
            return patientRepository.save(patient);
        } catch (RestClientException rce) {
            System.out.println(rce.getMessage());
            return patientRepository.save(patient);
        }
    }
    public Optional<Patient> findPatientByName(String fullName) {
        try {
            String[] name = fullName.split("_", 2);
            String firstName = name[0];
            String lastName = name[1];
            return patientRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName, lastName);
        } catch (IndexOutOfBoundsException iobe) {
            return patientRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(null, fullName);
        }
    }
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}
