package hospital.diagnosis.persistence;

public class PatientDTO {
    private String uuid;
    private String firstName;
    private String lastName;
    //private List<String> symptoms;
    private String descriptionOfIllness;
    private String sex;
    private int age;
    private boolean isInfant;

    public PatientDTO(String uuid, String firstName, String lastName, String descriptionOfIllness, String sex, int age, boolean isInfant) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.descriptionOfIllness = descriptionOfIllness;
        this.sex = sex;
        this.age = age;
        this.isInfant = isInfant;
    }

    public PatientDTO() {
    }

    public boolean isInfant() {
        return isInfant;
    }

    public void setInfant(boolean infant) {
        isInfant = infant;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescriptionOfIllness() {
        return descriptionOfIllness;
    }

    public void setDescriptionOfIllness(String descriptionOfIllness) {
        this.descriptionOfIllness = descriptionOfIllness;
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
