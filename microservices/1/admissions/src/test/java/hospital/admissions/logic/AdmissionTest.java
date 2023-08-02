package hospital.admissions.logic;

import hospital.admissions.domain.Patient;
import hospital.admissions.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AdmissionTest {
    @Autowired
    Admission admission;
    @MockBean
    PatientRepository patientRepository;
    @MockBean
    UUIDProvider uuidProvider;
    @MockBean
    SecurityFilterChain securityFilterChain;

    private final Patient testPatient = new Patient((long) 1, null, "test", null, null);

    @Test
    void admit() {
        Mockito.doNothing().when(uuidProvider).provideUuid(testPatient);
        Mockito.when(patientRepository.save(testPatient)).thenReturn(testPatient);
        Patient actual = admission.admit(testPatient);
        Mockito.verify(patientRepository).save(testPatient);
        assertEquals(testPatient, actual);
    }

    @Test
    void findPatient_name_not_found() {
        Mockito.when(patientRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase("not", "found")).thenReturn(Optional.empty());
        Optional<Patient> oActual = admission.findPatientByName("not_found");
        assertEquals(Optional.empty(), oActual);
    }

    @ParameterizedTest
    @MethodSource("params")
    void findPatientByName(String fullName, String firstName, String lastName, Optional<Patient> expectedPatientOptional) {
        Mockito.when(patientRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName, lastName)).thenReturn(Optional.of(new Patient((long) 1, firstName, lastName, "uuid", List.of())));
        Optional<Patient> oActual = admission.findPatientByName(fullName);
        Mockito.verify(patientRepository).findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName, lastName);
        assertEquals(expectedPatientOptional, oActual);
    }
    private static Stream<Arguments> params() {
        return Stream.of(
                Arguments.of("test_test", "test", "test", Optional.of(new Patient((long) 1, "test", "test", "uuid", List.of()))),
                Arguments.of("Pop-Eye", null, "Pop-Eye", Optional.of(new Patient((long) 1, null, "Pop-Eye", "uuid", List.of()))),
                Arguments.of("Olive_Oil", "Olive", "Oil", Optional.of(new Patient((long) 1, "Olive", "Oil", "uuid", List.of())))
        );
    }
}