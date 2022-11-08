package example.show.domain.config;

import example.show.domain.repository.ShowRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemoryConfig {

    @Bean
    public ShowRepository showRepository() {
        return new ShowRepository();
    }
}
