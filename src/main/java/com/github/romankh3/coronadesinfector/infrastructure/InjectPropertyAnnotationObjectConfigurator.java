package com.github.romankh3.coronadesinfector.infrastructure;

import static java.util.stream.Collectors.toMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Map;
import lombok.SneakyThrows;

public class InjectPropertyAnnotationObjectConfigurator implements ObjectConfigurator {

    private Map<String, String> propertiesMap;

    @SneakyThrows
    public InjectPropertyAnnotationObjectConfigurator() {
        String path = ClassLoader.getSystemClassLoader().getResource("application.properties").getPath();
        propertiesMap = new BufferedReader(new FileReader(path)).lines()
                .map(line -> line.split("="))
                .collect(toMap(arr -> arr[0], arr -> arr[1]));
    }

    @SneakyThrows
    @Override
    public void configure(Object object, ApplicationContext context) {
        Class<?> implClass = object.getClass();
        for (Field field : implClass.getDeclaredFields()) {
            InjectProperty annotation = field.getAnnotation(InjectProperty.class);

            String value;
            if (annotation != null) {
                value = annotation.value().isEmpty() ? propertiesMap.get(field.getName())
                        : propertiesMap.get(annotation.value());
                field.setAccessible(true);
                field.set(object, value);
            }

        }
    }
}
