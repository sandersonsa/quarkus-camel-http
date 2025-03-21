package xyz.sandersonsa.route;

import org.apache.camel.builder.RouteBuilder;

public class CamelRoute  extends RouteBuilder {
    
    @Override
    public void configure() {

        from("timer:foo?period=1000")
                .setHeader("User-Agent", header("User-Agent"))
                .setHeader("Accept", header("Accept"))
                .to("http://localhost:8081/hello") // Replace with your REST endpoint
                .log("Response=${body}");

        // from("platform-http:/not-secured")
        //         .setBody(constant("Not secured endpoint!"));
        // from("platform-http:/secured/authenticated")
        //         .setBody(simple("You are authenticated user so you can perform this action."));
        // from("platform-http:/secured/authorized")
        //         .setBody(simple("You are authorized to perform sensitive operation."));
    }
}
