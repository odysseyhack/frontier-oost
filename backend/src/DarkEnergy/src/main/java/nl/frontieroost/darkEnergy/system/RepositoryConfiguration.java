package nl.frontieroost.darkEnergy.system;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuration for Spring and JPA.
 *
 * @author Wely
 */
@Configuration
@EnableAutoConfiguration
//@EntityScan(basePackages = {"nl.frontieroost.darkEnergy", "nl.topicus.roelvanwely.ams.sarvision"})
@EnableJpaRepositories(basePackages = {"nl.frontieroost.darkEnergy.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
