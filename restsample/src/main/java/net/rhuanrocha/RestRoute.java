package net.rhuanrocha;

import org.apache.camel.builder.RouteBuilder;

public class RestRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration()
                .component("netty-http")
                .host("0.0.0.0")
                .port(8080);

        rest("/hello")
                .get()
                .to("direct:hello");

        from("direct:hello")
                .setBody(simple("Hello, ${header.name}!"));
    }
}
