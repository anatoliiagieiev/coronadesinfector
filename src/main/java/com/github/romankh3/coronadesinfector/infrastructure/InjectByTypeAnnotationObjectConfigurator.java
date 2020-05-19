package com.github.romankh3.coronadesinfector.infrastructure;

import java.lang.reflect.Field;
import lombok.SneakyThrows;

public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator {

    @SneakyThrows
    @Override
    public void configure(Object t, ApplicationContext context) {
        for (Field field : t.getClass().getDeclaredFields()) {
            if(field.getAnnotation(InjectByType.class) != null) {
                field.setAccessible(true);
                Object object = context.getObject(field.getType());
                field.set(t, object);
            }
        }

    }
}
