package hospital.admissions.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

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

    private boolean forwardedToDiagnosis;

    public Patient() {
    }

    public Patient(Long id, String firstName, String lastName, String uuid, List<String> symptoms, boolean forwardedToDiagnosis) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.uuid = uuid;
        this.symptoms = symptoms;
        this.forwardedToDiagnosis = forwardedToDiagnosis;
    }

    public Patient(Long id, String firstName, String lastName, String uuid, List<String> symptoms) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.uuid = uuid;
        this.symptoms = symptoms;
    }

    public boolean isForwardedToDiagnosis() {
        return forwardedToDiagnosis;
    }

    public void setForwardedToDiagnosis(boolean forwardedToDiagnosis) {
        this.forwardedToDiagnosis = forwardedToDiagnosis;
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

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", uuid='" + uuid + '\'' +
                ", symptoms=" + symptoms +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id) && Objects.equals(firstName, patient.firstName) && Objects.equals(lastName, patient.lastName) && Objects.equals(uuid, patient.uuid) && Objects.equals(symptoms, patient.symptoms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, uuid, symptoms);
    }
}
