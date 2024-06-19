package OrderMgt.OrderMgt;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.orm")
@EntityScan("com.orm.Entity")
@EnableJpaRepositories("com.orm.Repo")
//@EnableScheduling
@EnableAspectJAutoProxy
@EnableCaching
public class OrderMgtApplication {
	@Bean
	public ModelMapper modelmapper()
	{
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderMgtApplication.class, args);
	}

	
}
