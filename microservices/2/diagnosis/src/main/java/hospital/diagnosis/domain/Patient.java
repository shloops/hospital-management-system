package hospital.diagnosis.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

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
    private String descriptionOfIllness;
    @Enumerated(EnumType.STRING)
    private Sex sex;
//    @Min(0)
//    @Max(130)
//    private int age;

    private Age age;
    private Set<Diagnosis> diagnoses;

    public Patient() {
    }



    public void setAge(Age age) {
        this.age = age;
    }

    public Set<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Set<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
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

    public String getDescriptionOfIllness() {
        return descriptionOfIllness;
    }

    public void setDescriptionOfIllness(String descriptionOfIllness) {
        this.descriptionOfIllness = descriptionOfIllness;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", uuid='" + uuid + '\'' +
                ", descriptionOfIllness='" + descriptionOfIllness + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", diagnoses=" + diagnoses +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id) && Objects.equals(firstName, patient.firstName) && Objects.equals(lastName, patient.lastName) && Objects.equals(uuid, patient.uuid) && Objects.equals(descriptionOfIllness, patient.descriptionOfIllness) && sex == patient.sex && Objects.equals(age, patient.age) && Objects.equals(diagnoses, patient.diagnoses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, uuid, descriptionOfIllness, sex, age, diagnoses);
    }
}
