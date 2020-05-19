package com.github.romankh3.coronadesinfector;

import com.github.romankh3.coronadesinfector.infrastructure.InjectProperty;
import com.github.romankh3.coronadesinfector.infrastructure.Singleton;

@Singleton
public class RecommendatorImpl implements Recommendator {

    @InjectProperty(value = "wisky")
    private String alcohol;

    public RecommendatorImpl() {
        System.out.println("Recommendator was created");
    }

    @Override
    public void recommend() {
        System.out.println("To protect from COVID-2019, Drink " + alcohol);
    }
}
