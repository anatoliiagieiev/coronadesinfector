package com.github.romankh3.coronadesinfector.infrastructure;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.SneakyThrows;

public class ObjectFactory {

    private final ApplicationContext context;
    private List<ObjectConfigurator> configurators = new ArrayList<>();

    @SneakyThrows
    public ObjectFactory(ApplicationContext context) {
        this.context = context;
        for (Class<? extends ObjectConfigurator> aClass : context.getConfig().getScanner()
                .getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }

    }

    @SneakyThrows
    public <T> T createObject(Class<T> implClass) {
        T t = create(implClass);

        //example chain of responsibilities.
        configure(t);

        invokePostConstruct(implClass, t);

        return t;
    }

    private <T> void invokePostConstruct(Class<T> implClass, T t)
            throws IllegalAccessException, InvocationTargetException {
        for (Method method : implClass.getMethods()) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
    }

    private <T> void configure(T t) {
        configurators.forEach(it -> it.configure(t, context));
    }

    private <T> T create(Class<T> implClass)
            throws InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException, NoSuchMethodException {
        return implClass.getDeclaredConstructor().newInstance();
    }
}
