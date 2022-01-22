import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ourstore.*"})
@EntityScan(basePackages = {"com.ourstore.*"})
@EnableJpaRepositories(basePackages = {"com.ourstore.*"})
public class EstoreApplication {
    public static void main(String[] args){
        SpringApplication.run(EstoreApplication.class);
    }
}
