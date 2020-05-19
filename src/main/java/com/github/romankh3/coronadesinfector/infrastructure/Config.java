package com.github.romankh3.coronadesinfector.infrastructure;

import org.reflections.Reflections;

public interface Config {

    <T> Class<? extends T> getImplClass(Class<T> type);

    Reflections getScanner();
}
