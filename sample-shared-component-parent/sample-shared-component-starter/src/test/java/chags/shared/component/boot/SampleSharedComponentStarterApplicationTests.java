package chags.shared.component.boot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.test.context.junit4.SpringRunner;

import chags.shared.component.SharedComponent;
import chags.shared.component.springboot.SharedComponentAutoConfiguration;

@RunWith(SpringRunner.class)
public class SampleSharedComponentStarterApplicationTests {

	private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
			.withConfiguration(AutoConfigurations.of(SharedComponentAutoConfiguration.class));

	@Test
	public void shouldAutoConfigureComponent() {

		contextRunner.withPropertyValues("shared-comp.url=localhost", "shared-comp.port=9091").run(context -> {
			assertThat(context).hasSingleBean(SharedComponent.class);
			assertThat(context.getBean(SharedComponent.class).printConfig()).contains("localhost");
			assertThat(context.getBean(SharedComponent.class).printConfig()).contains("9091");
		});
	}

	@Test
	public void shouldNotAutoConfigureComponent() {

		contextRunner.run(context -> {
			assertThat(context).doesNotHaveBean(SharedComponent.class);
		});
	}
}
