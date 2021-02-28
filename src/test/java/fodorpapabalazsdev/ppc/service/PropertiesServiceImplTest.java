package fodorpapabalazsdev.ppc.service;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("PropertiesServiceImplTest Test")
class PropertiesServiceImplTest {

    @SneakyThrows
    @Test
    public void getAppVersionTest() {

        assertEquals("0.0.1-SNAPSHOT", PropertiesServiceImpl.getAppVersion());

    }

}
