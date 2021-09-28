package com.ffmanager.rest;

import com.ffmanager.core.repository.FeatureFlagServiceClient;
import com.ffmanager.core.repository.FeatureFlagServiceClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class ManagerController {

    private final FeatureFlagServiceClient ffClient;

    @Autowired
    ManagerController(FeatureFlagServiceClientImpl ffClient) {
        this.ffClient = ffClient;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String messages(Model model) throws IOException {
        model.addAttribute("featureFlags", ffClient.getLatestFeatureFlags());
        return "feature_flags";
    }
}
