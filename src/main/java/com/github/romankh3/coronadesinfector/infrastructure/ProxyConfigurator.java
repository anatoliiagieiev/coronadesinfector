package com.github.romankh3.coronadesinfector.infrastructure;

public interface ProxyConfigurator {

    Object replaceWithProxyIfNeeded(Object t, Class implClass);

}
