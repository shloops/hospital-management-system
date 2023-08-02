package hospital.admissions.logic;

import hospital.admissions.domain.Patient;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UUIDProvider {
    //private Map<Patient, String> patientUuidMap = new HashMap<>();

    public void provideUuid(Patient patient) {
        if (patient.getUuid() == null) {
            patient.setUuid(UUID.randomUUID().toString());
        }
    }
}
