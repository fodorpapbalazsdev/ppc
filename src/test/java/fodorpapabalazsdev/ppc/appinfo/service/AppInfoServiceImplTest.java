package fodorpapabalazsdev.ppc.appinfo.service;

import fodorpapabalazsdev.ppc.service.PropertiesServiceImpl;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@DisplayName("AppInfoServiceImplTest Test")
class AppInfoServiceImplTest {

    @Mock
    PropertiesServiceImpl propertiesService;

    @InjectMocks
    AppInfoServiceImpl appInfoService;

    @SneakyThrows
    @Test
    public void getAppInfoTest() {

        //  when(propertiesService.getAppVersion()).thenReturn("0.0.1-SNAPSHOT");
        assertEquals("0.0.1-SNAPSHOT", appInfoService.getAppInfo().getVersion());

        //   when(propertiesService.getAppVersion()).thenReturn("1.0.3-SNAPSHOT");
        //   assertEquals("1.0.3-SNAPSHOT", appInfoService.getAppInfo().getVersion());

        //   when(propertiesService.getAppVersion()).thenThrow(FileNotFoundException.class);
        //   assertThrows(FileNotFoundException.class, () -> appInfoService.getAppInfo());

    }

}
