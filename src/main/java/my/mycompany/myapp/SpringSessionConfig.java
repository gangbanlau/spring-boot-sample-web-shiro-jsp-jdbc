package my.mycompany.myapp;

import org.springframework.context.annotation.Profile;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Profile("session")
@EnableRedisHttpSession
public class SpringSessionConfig {	
}
