package hospital.diagnosis.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Age {
    @Min(0)
    @Max(130)
    private int value;
    private AgeUnit ageUnit;

    public Age() {
    }

    public Age(int value, AgeUnit ageUnit) {
        this.value = value;
        this.ageUnit = ageUnit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public AgeUnit getAgeUnit() {
        return ageUnit;
    }

    public void setAgeUnit(AgeUnit ageUnit) {
        this.ageUnit = ageUnit;
    }
}
