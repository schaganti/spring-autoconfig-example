package chags.shared.component;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import chags.shared.component.annotation.EnableSampleSharedComponent;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { SampleSharedComponentApplicationTests.TestConfig.class })
@TestPropertySource(properties = { "sharedComp.url=testUrl", "sharedComp.port=8080" })
public class SampleSharedComponentApplicationTests {

	@Autowired
	SharedComponent sharedComponent;

	@Test
	public void contextLoads() {
		assertThat(sharedComponent.printConfig()).contains("testUrl");
		assertThat(sharedComponent.printConfig()).contains("8080");
	}

	@Configuration
	@EnableSampleSharedComponent(url = "${sharedComp.url}", port="${sharedComp.port}")
	public static class TestConfig {

	}
}
