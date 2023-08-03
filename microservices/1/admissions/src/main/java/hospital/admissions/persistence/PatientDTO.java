package hospital.admissions.persistence;

import java.util.List;

public class PatientDTO {
    private String uuid;
    private String firstName;
    private String lastName;
    private List<String> symptoms;

    public PatientDTO(String uuid, String firstName, String lastName, List<String> symptoms) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.symptoms = symptoms;
    }
}
