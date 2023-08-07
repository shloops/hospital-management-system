package hospital.diagnosis.persistence;

public class SymptomDTO {
    private String id;
    private String choice_id;
    private String source;

    public SymptomDTO(String id, String choice_id, String source) {
        this.id = id;
        this.choice_id = choice_id;
        this.source = source;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChoice_id() {
        return choice_id;
    }

    public void setChoice_id(String choice_id) {
        this.choice_id = choice_id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
