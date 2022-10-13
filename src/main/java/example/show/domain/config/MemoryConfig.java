package example.show.domain.config;

import example.show.domain.repository.InMemShowRepository;
import example.show.domain.repository.ShowRepository;
import example.show.web.service.ShowService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemoryConfig {

    @Bean
    public ShowRepository showRepository() {
        return new InMemShowRepository();
    }
}
