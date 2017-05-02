package my.mycompany.myapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource( {"classpath*:shiro-context.xml", "classpath*:shiro-realm.xml", "classpath*: locale-context.xml"})
@Configuration
public class LegacyXMLConfiguration {
}
