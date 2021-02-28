package fodorpapabalazsdev.ppc.appinfo.service;

import fodorpapabalazsdev.ppc.appinfo.resource.AppInfoResource;

import java.io.IOException;

public interface AppInfoService {
    AppInfoResource getAppInfo() throws IOException;
}
