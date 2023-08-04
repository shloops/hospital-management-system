package hospital.diagnosis.persistence;

public class PatientDTO {
    private String uuid;
    private String firstName;
    private String lastName;
    //private List<String> symptoms;

    public PatientDTO(String uuid, String firstName, String lastName
            //, List<String> symptoms
    ) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        //this.symptoms = symptoms;
    }

    public PatientDTO() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
