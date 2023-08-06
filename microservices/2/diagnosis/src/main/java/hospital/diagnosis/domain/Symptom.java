package hospital.diagnosis.domain;

public class Symptom {
    private String id;
    private String orth;
    private String choice_id;
    private String name;
    private String common_name;

    public Symptom() {
    }

    public Symptom(String id, String orth, String choice_id, String name, String common_name) {
        this.id = id;
        this.orth = orth;
        this.choice_id = choice_id;
        this.name = name;
        this.common_name = common_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrth() {
        return orth;
    }

    public void setOrth(String orth) {
        this.orth = orth;
    }

    public String getChoice_id() {
        return choice_id;
    }

    public void setChoice_id(String choice_id) {
        this.choice_id = choice_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommon_name() {
        return common_name;
    }

    public void setCommon_name(String common_name) {
        this.common_name = common_name;
    }
    //"id": "s_13",
    //  "orth": "stomach pain",
    //  "choice_id": "present",
    //  "name": "Abdominal pain",
    //  "common_name": "Abdominal pain",
    //  "type": "symptom"
}
