package hospital.admissions.communication.client;

import hospital.admissions.persistence.PatientDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class DiagnosesClient {
    private final RestTemplate restTemplate;
    private final String diagnosisURL;
    public DiagnosesClient(RestTemplate restTemplate, @Value("${diagnosisURL}") String diagnosisURL) {
        this.restTemplate = restTemplate;
        this.diagnosisURL = diagnosisURL;
    }

    public PatientDTO forwardPatientForDiagnosis(PatientDTO patientDTO) {
        return restTemplate.postForObject(diagnosisURL, patientDTO, PatientDTO.class);
    }
}
