package example.show;

import example.show.domain.config.MemoryConfig;
import example.show.domain.repository.ShowRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(MemoryConfig.class)
@SpringBootApplication(scanBasePackages = "example.show.web")
public class ShowInformationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShowInformationApplication.class, args);
	}
	@Bean
	public TestDataInit testDataInit(ShowRepository showRepository) {
		return new TestDataInit(showRepository);
	}

}
