package xyz.sandersonsa.route;

import org.apache.camel.builder.RouteBuilder;

public class CamelRoute  extends RouteBuilder {
    
    @Override
    public void configure() {

        from("timer:foo?period={{timer.period}}")
                .setHeader("User-Agent", header("User-Agent"))
                .setHeader("Accept", header("Accept"))
                .to("{{rest.endpoint.url}}")
                .log("Response=${body}");        
    }
}
