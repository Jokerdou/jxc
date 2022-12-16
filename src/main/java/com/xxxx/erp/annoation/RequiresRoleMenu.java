package com.xxxx.erp.annoation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequiresRoleMenu {

    String code() default "";
}
