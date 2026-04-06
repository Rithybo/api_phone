package rithy.com.phonshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.persistence.autoconfigure.EntityScan;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan("rithy.com.phonshop.entity")
//@EnableJpaRepositories("rithy.com.phonshop.repository") // បន្ថែមដើម្បីឱ្យស្គាល់ Repository
//@ComponentScan(basePackages = {"rithy.com.phonshop"})
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
