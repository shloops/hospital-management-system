package hospital.diagnosis.logic;

import hospital.diagnosis.domain.Age;
import hospital.diagnosis.domain.AgeUnit;
import hospital.diagnosis.domain.Patient;
import hospital.diagnosis.domain.Sex;
import hospital.diagnosis.persistence.ParserDTO;
import hospital.diagnosis.persistence.PatientDTO;
import org.springframework.stereotype.Service;

@Service
public class dtoConverter {
    public Patient convertFromDtoToPatient(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setUuid(patientDTO.getUuid());
        patient.setDescriptionOfIllness(patientDTO.getDescriptionOfIllness());
        patient.setSex(Sex.valueOf(patientDTO.getSex()));
        Age age = new Age();
        age.setValue(patientDTO.getAge());
        if (patientDTO.isInfant()) {
            age.setAgeUnit(AgeUnit.MONTH);
        } else {
            age.setAgeUnit(AgeUnit.YEAR);
        }
        patient.setAge(age);
        return patient;
    }
    public ParserDTO convertFromPatientDtoToParserDTO(PatientDTO patientDTO) {
        ParserDTO parserDTO = new ParserDTO();
        parserDTO.setText(patientDTO.getDescriptionOfIllness());
        parserDTO.setSex(Sex.valueOf(patientDTO.getSex()));
        Age age = new Age();
        age.setValue(patientDTO.getAge());
        if (patientDTO.isInfant()) {
            age.setAgeUnit(AgeUnit.MONTH);
        } else {
            age.setAgeUnit(AgeUnit.YEAR);
        }
        parserDTO.setAge(age);
        return parserDTO;
    }

    public ParserDTO extractParseInfoFromPatient(Patient patient) {
        return new ParserDTO(patient.getSex(), patient.getAge(), patient.getDescriptionOfIllness());
    }
}
