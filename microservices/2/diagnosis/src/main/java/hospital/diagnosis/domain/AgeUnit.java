package hospital.diagnosis.domain;

public enum AgeUnit {
    YEAR("year"),
    MONTH("month");

    private String unit;

    AgeUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return unit;
    }
}
