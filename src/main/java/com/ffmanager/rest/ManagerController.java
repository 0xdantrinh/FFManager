package com.ffmanager.rest;

import com.ffmanager.core.domain.FeatureFlag;
import com.ffmanager.core.repository.FeatureFlagServiceClient;
import com.ffmanager.core.repository.FeatureFlagServiceClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class ManagerController {

    private final FeatureFlagServiceClient ffClient;

    @Autowired
    ManagerController(FeatureFlagServiceClientImpl ffClient) {
        this.ffClient = ffClient;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String featureFlagsPage(Model model) throws IOException {
        model.addAttribute("featureFlags", ffClient.getLatestFeatureFlags());
        return "feature_flags";
    }

    @RequestMapping(value = "/feature.html", method = RequestMethod.GET)
    public ModelAndView featurePage(Model model) throws IOException {
        model.addAttribute("featureFlags", ffClient.getLatestFeatureFlags());
        return new ModelAndView("feature");
    }

    @GetMapping("/feature_flags/edit/{feature_name}")
    public ModelAndView editUser(@PathVariable(name = "feature_name") String featureName) throws IOException {
        List<FeatureFlag> featureFlags = ffClient.getLatestFeatureFlags();
        Optional<FeatureFlag> editableFlag = featureFlags.stream().filter(x -> x.getName().equals(featureName)).findFirst();
        ModelAndView mav = new ModelAndView("feature_flag_form");
        mav.addObject("feature_flag", editableFlag);
        return mav;
    }

}
