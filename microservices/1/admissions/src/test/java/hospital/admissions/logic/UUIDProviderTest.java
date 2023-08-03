package hospital.admissions.logic;

import hospital.admissions.domain.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UUIDProviderTest {
    @Autowired
    UUIDProvider uuidProvider;

    @MockBean
    SecurityFilterChain securityFilterChain;
    private final Patient testPatient = new Patient((long) 1, null, "test", null, null, false);


    @Test
    void provideUuid() {
        //Assertions.assertThrows(NullPointerException.class, () -> testPatient.getUuid());
        Assertions.assertNull(testPatient.getUuid());
        uuidProvider.provideUuid(testPatient);
        Assertions.assertEquals(36, testPatient.getUuid().length());
        testPatient.setUuid(null);
    }
}