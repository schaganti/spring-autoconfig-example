package chags.shared.component.annotation;

import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringValueResolver;

import chags.shared.component.SharedComponent;

@Configuration
public class EnableSharedComponentConfig implements ImportAware, EmbeddedValueResolverAware {

	private StringValueResolver stringValueResolver;

	private String url;

	private String port;

	@Bean
	public SharedComponent sharedCompnent() {
		
		SharedComponentConfiguration sharedComponentConfiguration = new SharedComponentConfiguration();
		sharedComponentConfiguration.setUrl(stringValueResolver.resolveStringValue(url));
		sharedComponentConfiguration.setPort(stringValueResolver.resolveStringValue(port));
		return new SharedComponent(sharedComponentConfiguration);
	}

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		this.stringValueResolver = resolver;
	}

	@Override
	public void setImportMetadata(AnnotationMetadata importMetadata) {
		
		AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(importMetadata
				.getAnnotationAttributes(EnableSampleSharedComponent.class.getName()));
		
		this.url = annotationAttributes.getString("url");
		this.port = annotationAttributes.getString("port");
	}
}
