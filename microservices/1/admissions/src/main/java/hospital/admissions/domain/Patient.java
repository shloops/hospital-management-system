package hospital.admissions.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    @NotNull(message = "last name must not be null, use \".\" for default")
    private String lastName;

    private String uuid;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "symptoms", joinColumns = @JoinColumn(name = "patient_id"))
    @Column(name = "symptom", nullable = false)
    private List<String> symptoms;

    public Patient() {
    }

    public Patient(Long id, String firstName, String lastName, String uuid, List<String> symptoms) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.uuid = uuid;
        this.symptoms = symptoms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
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
