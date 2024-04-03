package com.yavzor.test.controllers;

import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
public class MainController implements Serializable {

    @Getter private final String myValue = "myValue";
}
