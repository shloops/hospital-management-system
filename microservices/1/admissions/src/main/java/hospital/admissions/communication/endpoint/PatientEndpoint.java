package hospital.admissions.communication.endpoint;

import hospital.admissions.communication.client.DiagnosesClient;
import hospital.admissions.domain.Patient;
import hospital.admissions.logic.Admission;
import hospital.admissions.persistence.PatientDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientEndpoint {
    private final Admission admission;
    private final DiagnosesClient diagnosesClient;
    public PatientEndpoint(Admission admission, DiagnosesClient diagnosesClient) {
        this.admission = admission;
        this.diagnosesClient = diagnosesClient;
    }
    @PostMapping("/admit")
    Patient admitPatient(@RequestBody Patient patient) {
        return admission.admit(patient);
    }

    @PostMapping("/forward")
    String forwardPatientForDiagnosis(@RequestBody PatientDTO patientDTO) {
        return diagnosesClient.forwardPatientForDiagnosis(patientDTO);
    }
    @GetMapping("/{fullName}")
    Patient getPatientByName(@PathVariable String fullName) {
        Optional<Patient> oPatient = admission.findPatientByName(fullName);
        if (oPatient.isPresent()) {
            return oPatient.get();
        }
        return null;
    } //TODO patients with same name or multiple firstNames - Mary Jane Parker

    @GetMapping
    List<Patient> getAll() {
        return admission.getAllPatients();
    }
}
