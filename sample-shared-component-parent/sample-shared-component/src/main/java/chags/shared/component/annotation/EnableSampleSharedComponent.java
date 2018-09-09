package chags.shared.component.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.context.annotation.Import;

@Retention(RetentionPolicy.RUNTIME)
@Import(EnableSharedComponentConfig.class)
public @interface EnableSampleSharedComponent {
	public String url() default "localhost";
	public String port() default "8080";
}
