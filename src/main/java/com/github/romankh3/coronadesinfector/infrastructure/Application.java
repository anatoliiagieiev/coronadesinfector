package com.github.romankh3.coronadesinfector.infrastructure;

import java.util.Map;

public class Application {

    public static ApplicationContext run(String packageToScan, Map<Class, Class> ifc2ImplClass) {
        Config config = new JavaConfig(packageToScan, ifc2ImplClass);
        ApplicationContext applicationContext = new ApplicationContext(config);
        ObjectFactory objectFactory = new ObjectFactory(applicationContext);
        //todo homework - init all singletons which are not lazy.
        applicationContext.setObjectFactory(objectFactory);
        return applicationContext;
    }

}
