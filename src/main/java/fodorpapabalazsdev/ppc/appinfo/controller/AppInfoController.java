package fodorpapabalazsdev.ppc.appinfo.controller;

import fodorpapabalazsdev.ppc.appinfo.resource.AppInfoResource;
import fodorpapabalazsdev.ppc.appinfo.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
@RequestMapping("api")
public class AppInfoController {

    private final AppInfoService appInfoService;

    @Autowired
    public AppInfoController(AppInfoService appInfoService) {
        this.appInfoService = appInfoService;
    }

    @GetMapping("info")
    public ResponseEntity<AppInfoResource> getAppInfo() {
        try {
            return new ResponseEntity<>(appInfoService.getAppInfo(), HttpStatus.OK);
        } catch (IOException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
}
