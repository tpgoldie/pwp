package com.tpg.pwp.web.views;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.tpg.pwp.context.config.web.PwpWebApplication;
import com.tpg.pwp.web.controllers.IndexController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@RunWith(SpringRunner.class)
@WebMvcTest(IndexController.class)
@ContextConfiguration(classes = {PwpWebApplication.class})
public class HomePageTest {
    @Autowired
    private WebClient webClient;

    @Test
    public void loadHomePage_homePage_expectedHomePageIsRetrieved() throws IOException {
        HtmlPage page = webClient.getPage("/pwp/index");
        assertThat(page.getBody().getTextContent(), containsString("Welcome To My Personal Portal"));
    }
}
