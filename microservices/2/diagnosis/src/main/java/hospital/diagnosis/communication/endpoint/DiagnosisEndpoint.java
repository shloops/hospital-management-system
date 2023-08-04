package hospital.diagnosis.communication.endpoint;

import hospital.diagnosis.persistence.PatientDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diagnosis")
public class DiagnosisEndpoint {
    @PostMapping
    String submitPatientForDiagnosis(@RequestBody PatientDTO patientDTO) {
        return patientDTO.getUuid();
    }
}
