package hospital.diagnosis.communication.client;

import hospital.diagnosis.domain.Symptom;
import hospital.diagnosis.persistence.ParserDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class ParseClient {
    private final RestTemplate restTemplate;

    private final String parseURL;
    private final String baseURL;

    public ParseClient(RestTemplate restTemplate, @Value("${infermedica.urls.parse}") String parseURL,@Value("${infermedica.urls.base}")  String baseURL) {
        this.restTemplate = restTemplate;
        this.parseURL = parseURL;
        this.baseURL = baseURL;
    }

    public Symptom[] parseDescriptionOfSymptoms(ParserDTO parserDTO) {
        return restTemplate.postForObject(baseURL + parseURL, parserDTO, Symptom[].class);
    }
}
