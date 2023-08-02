package hospital.admissions.communication.endpoint;

import hospital.admissions.domain.Patient;
import hospital.admissions.logic.Admission;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientEndpoint {
    private final Admission admission;

    public PatientEndpoint(Admission admission) {
        this.admission = admission;
    }
    @PostMapping("/admit")
    Patient admitPatient(@RequestBody Patient patient) {
        return admission.admit(patient);
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
