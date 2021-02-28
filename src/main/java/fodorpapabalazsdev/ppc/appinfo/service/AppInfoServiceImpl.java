package fodorpapabalazsdev.ppc.appinfo.service;

import fodorpapabalazsdev.ppc.appinfo.resource.AppInfoResource;
import fodorpapabalazsdev.ppc.service.PropertiesServiceImpl;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AppInfoServiceImpl implements AppInfoService {
    @Override
    public AppInfoResource getAppInfo() throws IOException {
        String appVersion = PropertiesServiceImpl.getAppVersion();
        return new AppInfoResource(appVersion);
    }
}
