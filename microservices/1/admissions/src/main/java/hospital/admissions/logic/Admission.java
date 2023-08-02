package hospital.admissions.logic;

import hospital.admissions.domain.Patient;
import hospital.admissions.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Admission {
    private final PatientRepository patientRepository;
    private final UUIDProvider uuidProvider;

    public Admission(PatientRepository patientRepository, UUIDProvider uuidProvider) {
        this.patientRepository = patientRepository;
        this.uuidProvider = uuidProvider;
    }

    public Patient admit(Patient patient) {
        uuidProvider.provideUuid(patient);
        return patientRepository.save(patient);
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
