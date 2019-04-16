package com.sinmn.mjar.ext.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface KeyValueExtValue {

	@AliasFor("key")
	String value() default "";
	
	@AliasFor("value")
	String key() default "";
	
	/**
	 * 备注，这个字段暂时没有意义
	 */
	String description() default "";
}
