package hospital.diagnosis.persistence;

import hospital.diagnosis.domain.Age;
import hospital.diagnosis.domain.Sex;

public class ParserDTO {
    private Sex sex;
    private Age age;
    private String text;

    public ParserDTO() {
    }

    public ParserDTO(Sex sex, Age age, String text) {
        this.sex = sex;
        this.age = age;
        this.text = text;
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

    public void setAge(Age age) {
        this.age = age;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
