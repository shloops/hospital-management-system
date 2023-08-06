package hospital.admissions.logic;

import hospital.admissions.domain.Patient;
import hospital.admissions.persistence.PatientDTO;
import org.springframework.stereotype.Service;

@Service
public class PatientDTOMapper {
    public PatientDTO mapPatientToDTO(Patient patient) {
        return new PatientDTO(patient.getUuid(), patient.getFirstName(), patient.getLastName(), patient.getSymptoms());
    }
}
