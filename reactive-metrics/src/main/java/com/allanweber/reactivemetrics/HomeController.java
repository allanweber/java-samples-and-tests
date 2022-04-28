package com.allanweber.reactivemetrics;

import static org.springframework.http.ResponseEntity.ok;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class HomeController {

    @GetMapping("/")
    public Mono<ResponseEntity<String>> home() {
        return Mono.just(ok("Hello World!")).name("hello").metrics();
    }

    @GetMapping("/exception")
    public Mono<ResponseEntity<String>> excMono() {
        return getResponse().name("hello").metrics()
                .onErrorResume(throwable -> Mono.error(new RuntimeException(throwable.getMessage())))
                .map(mapper -> ok(mapper));
    }

    private Mono<String> getResponse() {
        return doSomething().flatMap(mapper -> doSomethingElse(mapper));
    }

    private Mono<String> doSomething() {
        return Mono.just("data");
    }

    private Mono<String> doSomethingElse(String arg) {
        throw new RuntimeException("Exception");
    }
}
