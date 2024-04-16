package com.yavzor.test.controllers;

import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
public class MainController implements Serializable {

    @Getter @Setter private int aValue;
    @Getter @Setter private int bValue;
    @Getter @Setter private int cValue;

    @Getter private double xResult;
    @Getter private double patialResult;

    public void calculate() {
        patialResult = Math.sqrt(Math.pow(bValue, 2d) - 4*aValue*cValue);
        xResult = (bValue + patialResult) / 2*aValue;
    }
}
