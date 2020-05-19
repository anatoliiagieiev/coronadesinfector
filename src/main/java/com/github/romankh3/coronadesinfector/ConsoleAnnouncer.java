package com.github.romankh3.coronadesinfector;

import com.github.romankh3.coronadesinfector.infrastructure.InjectByType;

public class ConsoleAnnouncer implements Announcer {

    @InjectByType
    private Recommendator recommendator;

    @Override
    public void announce(String message) {
        System.out.println(message);
        recommendator.recommend();
    }
}
