package config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;

@Configuration
@EnableJpaAuditing
public class AuditingConfig extends JpaRepositoryConfigExtension {
    // You can customize the auditing behavior here if needed
}