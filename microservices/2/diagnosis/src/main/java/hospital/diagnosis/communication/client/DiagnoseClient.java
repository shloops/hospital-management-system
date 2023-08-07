package hospital.diagnosis.communication.client;

import hospital.diagnosis.domain.Diagnosis;
import hospital.diagnosis.persistence.DiagnosisDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class DiagnoseClient {
    private final RestTemplate restTemplate;
    private final String baseURL;
    private final String diagnosisURL;

    public DiagnoseClient(RestTemplate restTemplate, String baseURL, String diagnosisURL) {
        this.restTemplate = restTemplate;
        this.baseURL = baseURL;
        this.diagnosisURL = diagnosisURL;
    }

    public Diagnosis[] diagnose(DiagnosisDTO diagnosisDTO) {
        return restTemplate.postForObject(baseURL + diagnosisURL, diagnosisDTO, Diagnosis[].class);
    }
}
