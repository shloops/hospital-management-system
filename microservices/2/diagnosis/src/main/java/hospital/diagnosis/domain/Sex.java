package hospital.diagnosis.domain;

public enum Sex {
    MALE("male"),
    FEMALE("female");

    private String sex;

    Sex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return sex;
    }
}
