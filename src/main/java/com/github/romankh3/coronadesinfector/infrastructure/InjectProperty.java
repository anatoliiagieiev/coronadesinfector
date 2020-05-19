package com.github.romankh3.coronadesinfector.infrastructure;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface InjectProperty {

    String value() default "";
}
