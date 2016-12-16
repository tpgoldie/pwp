package com.tpg.pwp.web.controllers;

import com.tpg.pwp.context.config.web.PwpWebConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(IndexController.class)
public class IndexControllerTest {
    @Configuration
    @Import(PwpWebConfig.class)
    static class IndexControllerTestConfig { }

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void handleIndexRequest_indexRequest_homePageIsDisplayed() throws Exception {
        mockMvc.perform(get("/pwp/index"))
            .andExpect(status().isOk())
            .andExpect(view().name("index"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/index.jsp"))
            .andExpect(model().attribute("welcome",is("Welcome To My Personal Portal")));
    }
}
