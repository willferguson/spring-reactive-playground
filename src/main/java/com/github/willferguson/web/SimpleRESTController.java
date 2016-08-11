package com.github.willferguson.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by will on 11/08/2016.
 */
@RestController
public class SimpleRESTController {

    private static final Logger logger = LoggerFactory.getLogger(SimpleRESTController.class);

    @RequestMapping(path = "/single", method = RequestMethod.GET)
    public Mono<String> fetchSingleValue() {
        return Mono.just("Single");
    }

    @RequestMapping(path = "/sse", method = RequestMethod.GET, produces = "text/event-stream")
    public Flux<String> fetchSSE() {
        return Flux.intervalMillis(500)
                .map(i -> Long.toString(i));
    }

}
