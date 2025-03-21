package xyz.sandersonsa.route;

import java.time.LocalDateTime;

import org.apache.camel.builder.RouteBuilder;

public class CamelRoute  extends RouteBuilder {
    
    @Override
    public void configure() {

        String dateTimeStr = LocalDateTime.now().toString();
        // System.out.println(dateTimeStr);

        from("timer:foo?period={{timer.period}}")
                .setHeader("User-Agent", header("User-Agent"))
                .setHeader("Accept", header("Accept"))
                // .setHeader("CamelHttpCookie", simple("cookieName=" + LocalDateTime.now().toString()))
                // .setHeader("Cookie", constant("curio="+ System.currentTimeMillis()))
                .process(exchange -> exchange.getIn().setHeader("Cookie", "curio=" + System.currentTimeMillis()))
                .toD("{{rest.endpoint.url}}")
                .log("Response=${body}")
                .log(dateTimeStr);        
    }
}
