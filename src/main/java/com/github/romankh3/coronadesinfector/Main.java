package com.github.romankh3.coronadesinfector;

import com.github.romankh3.coronadesinfector.infrastructure.Application;
import com.github.romankh3.coronadesinfector.infrastructure.ApplicationContext;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = Application.run("com.github.romankh3.coronadesinfector", new HashMap<Class, Class>() {{
            put(Policeman.class, AngryPoliceman.class);
        }});
        CoronaDesinfector coronaDesinfector = context.getObject(CoronaDesinfector.class);
        coronaDesinfector.start(new Room());
    }

}
