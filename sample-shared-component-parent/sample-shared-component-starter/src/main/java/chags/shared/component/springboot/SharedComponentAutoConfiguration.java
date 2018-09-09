package chags.shared.component.springboot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import chags.shared.component.SharedComponent;
import chags.shared.component.SharedComponentConfiguration;

@EnableConfigurationProperties
@ConditionalOnProperty(name = { "shared-comp.url", "shared-comp.port" })
public class SharedComponentAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean(SharedComponent.class)
	public SharedComponent sharedCompnent(SharedComponentConfiguration config) {
		return new SharedComponent(config);
	}

	@Bean
	@ConfigurationProperties(prefix="shared-comp")
	@ConditionalOnMissingBean(SharedComponentConfiguration.class)
	SharedComponentConfiguration sharedComponentConfiguration(Environment env) {
		return new SharedComponentConfiguration();
	}

}
