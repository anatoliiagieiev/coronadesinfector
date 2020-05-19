package com.github.romankh3.coronadesinfector.infrastructure;

import java.util.Map;
import java.util.Set;
import lombok.Getter;
import org.reflections.Reflections;

public class JavaConfig implements Config {

    @Getter
    private Reflections scanner;
    private Map<Class, Class> ifc2ImplCLass;

    public JavaConfig(String packageToScan, Map<Class, Class> ifc2ImplCLass) {
        this.scanner = new Reflections(packageToScan);
        this.ifc2ImplCLass = ifc2ImplCLass;
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> ifc) {
        return ifc2ImplCLass.computeIfAbsent(ifc, aClass -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
            if (classes.size() != 1) {
                throw new RuntimeException(ifc + " has 0 or more than 1 impl. Please update your config");
            }
            return classes.iterator().next();
        });
    }
}
