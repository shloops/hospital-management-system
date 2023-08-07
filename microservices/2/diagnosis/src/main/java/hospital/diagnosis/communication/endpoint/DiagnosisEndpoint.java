package hospital.diagnosis.communication.endpoint;

import hospital.diagnosis.communication.client.ParseClient;
import hospital.diagnosis.domain.Patient;
import hospital.diagnosis.logic.DiagnosisService;
import hospital.diagnosis.persistence.PatientDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diagnosis")
public class DiagnosisEndpoint {
    private final ParseClient parseClient;
    private final DiagnosisService diagnosisService;

    public DiagnosisEndpoint(ParseClient parseClient, DiagnosisService diagnosisService) {
        this.parseClient = parseClient;
        this.diagnosisService = diagnosisService;
    }

    @PostMapping("/diagnose")
    Patient diagnose(@RequestBody PatientDTO patientDTO) {
        return diagnosisService.diagnose(patientDTO);
    }
    @PostMapping
    String submitPatientForDiagnosis(@RequestBody PatientDTO patientDTO) {
        return patientDTO.getUuid();
    }
}
