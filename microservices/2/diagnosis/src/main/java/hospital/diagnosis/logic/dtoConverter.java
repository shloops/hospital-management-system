package hospital.diagnosis.logic;

import hospital.diagnosis.domain.*;
import hospital.diagnosis.persistence.ParserDTO;
import hospital.diagnosis.persistence.PatientDTO;
import hospital.diagnosis.persistence.SymptomDTO;
import org.springframework.stereotype.Service;

@Service
public class dtoConverter {
    public Patient convertFromDtoToPatient(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setUuid(patientDTO.getUuid());
        //patient.setDescriptionOfIllness(patientDTO.getDescriptionOfIllness());
        patient.setSex(Sex.valueOf(patientDTO.getSex()));
//        Age age = new Age();
//        age.setValue(patientDTO.getAge());
//        if (patientDTO.isInfant()) {
//            age.setAgeUnit(AgeUnit.MONTH);
//        } else {
//            age.setAgeUnit(AgeUnit.YEAR);
//        }
        patient.setAge(setAge(patientDTO.getAge(), patientDTO.isInfant()));
        return patient;
    }
    public ParserDTO convertFromPatientDtoToParserDTO(PatientDTO patientDTO) {
        ParserDTO parserDTO = new ParserDTO();
        parserDTO.setText(patientDTO.getDescriptionOfIllness());
        parserDTO.setSex(Sex.valueOf(patientDTO.getSex()));
        parserDTO.setAge(setAge(patientDTO.getAge(), patientDTO.isInfant()));
        return parserDTO;
    }

//    public ParserDTO extractParseInfoFromPatient(Patient patient) {
//        return new ParserDTO(patient.getSex(), patient.getAge(), patient.getDescriptionOfIllness());
//    }
    public SymptomDTO convertFromSymptomToSymptomDTO(Symptom symptom) {
        return new SymptomDTO(symptom.getId(), symptom.getChoice_id(), "initial");
    }

    private Age setAge(int value, boolean isInfant) {
        Age age = new Age();
        age.setValue(value);
        if (isInfant) {
            age.setAgeUnit(AgeUnit.MONTH);
        } else {
            age.setAgeUnit(AgeUnit.YEAR);
        }
        return age;
    }
}
