package hospital.diagnosis.domain;

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

//    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "symptoms", joinColumns = @JoinColumn(name = "patient_id"))
//    @Column(name = "symptom", nullable = false)
//    private List<String> symptoms;

    @Enumerated(EnumType.STRING)
    private Sex sex;
//    @Min(0)
//    @Max(130)
//    private int age;

    private Age age;
    private List<Diagnosis> diagnoses;
    private List<Symptom> symptoms;
    public Patient() {
    }



    public void setAge(Age age) {
        this.age = age;
    }


    public Sex getSex() {
        return sex;
    }


    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Age getAge() {
        return age;
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

    public List<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id) && Objects.equals(firstName, patient.firstName) && Objects.equals(lastName, patient.lastName) && Objects.equals(uuid, patient.uuid) && sex == patient.sex && Objects.equals(age, patient.age) && Objects.equals(diagnoses, patient.diagnoses) && Objects.equals(symptoms, patient.symptoms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, uuid, sex, age, diagnoses, symptoms);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", uuid='" + uuid + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", diagnoses=" + diagnoses +
                ", symptoms=" + symptoms +
                '}';
    }
}
