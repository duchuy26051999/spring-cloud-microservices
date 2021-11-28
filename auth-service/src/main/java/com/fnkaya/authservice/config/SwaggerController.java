package com.fnkaya.authservice.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class SwaggerController {

    @GetMapping
    public RedirectView redirectToSwagger(RedirectAttributes attributes) {
        return new RedirectView("swagger-ui.html");
    }
}
