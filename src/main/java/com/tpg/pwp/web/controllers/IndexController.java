package com.tpg.pwp.web.controllers;

import com.tpg.pwp.context.config.web.PwpWebConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.tpg.pwp.web.controllers.ViewConstants.INDEX_VIEW;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(PwpWebConfig.WEBAPP_PREFIX)
public class IndexController {
    @RequestMapping(value = "/index", method = GET)
    public String getIndex(Model model) {
        model.addAttribute("welcome", "Welcome To My Personal Portal");
        return INDEX_VIEW;
    }
}
