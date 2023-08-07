package hospital.diagnosis.persistence;

import hospital.diagnosis.domain.Age;

import java.util.List;

public class DiagnosisDTO {
    private String sex;
    private Age age;
    private List<SymptomDTO> evidence;

    public DiagnosisDTO(String sex, Age age, List<SymptomDTO> evidence) {
        this.sex = sex;
        this.age = age;
        this.evidence = evidence;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public List<SymptomDTO> getEvidence() {
        return evidence;
    }

    public void setEvidence(List<SymptomDTO> evidence) {
        this.evidence = evidence;
    }
}
