package example.show.domain.config;

import example.show.domain.repository.InMemShowInfoRepository;
import example.show.domain.repository.ShowInfoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemoryConfig {

    @Bean
    public ShowInfoRepository showRepository() {
        return new InMemShowInfoRepository();
    }
}
