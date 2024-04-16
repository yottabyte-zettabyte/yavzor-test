package com.yavzor.test.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope
public class ApplicationProperties {

    @Value("${application.version}")
    private String version;

    @Value("${application.locale}")
    private String locale;

    @ModelAttribute("version")
    public String getVersion() {
        return version;
    }

    @ModelAttribute("locale")
    public String getLocale() {
        return locale;
    }
}
