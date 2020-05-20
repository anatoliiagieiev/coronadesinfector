package com.github.romankh3.coronadesinfector;

import com.github.romankh3.coronadesinfector.infrastructure.InjectByType;
import javax.annotation.PostConstruct;

public class AngryPoliceman implements Policeman {

    @InjectByType
    private Recommendator recommendator;
    
    @PostConstruct
    public void init() {
        System.out.println(recommendator.getClass());
    }

    @Override
    public void makePeopleLEaveRoom() {
        System.out.println("всех убью! Вон пошли");
    }
}
