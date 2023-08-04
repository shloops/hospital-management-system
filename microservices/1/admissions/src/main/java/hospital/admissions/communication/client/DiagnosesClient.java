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

    public String forwardPatientForDiagnosis(PatientDTO patientDTO) {
        System.out.println(diagnosisURL);
        return restTemplate.postForObject(diagnosisURL, patientDTO, String.class);
    }
}
