package ar.com.apirestswagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfiguration {

    //Here we are making the configuration of swagger API
    @Bean
    public OpenAPI defineOpenApi(){
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Development");

        Contact contact = new Contact();
        contact.setName("Alan");
        contact.setEmail("example@gmail.com");

        Info information = new Info()
                .title("Item API Rest")
                .version("1.0")
                .description("This API is to show you an example")
                .contact(contact);

        return new OpenAPI()
                .info(information)
                .servers(List.of(server));
    }
}
