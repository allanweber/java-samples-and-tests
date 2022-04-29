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
        return doSomething()
                .map(mapper -> ok(mapper))
                .name("hello").metrics();
    }

    @GetMapping("/exception")
    public Mono<ResponseEntity<String>> excMono() {
        return doSomething()
                .flatMap(this::doSomethingElse)
                .map(mapper -> ok(mapper))
                .name("hello").metrics();
    }

    @GetMapping("/another-exception")
    public Mono<ResponseEntity<String>> anotherExcMono() {
        return doSomething()
                .flatMap(this::doSomethingElseElse)
                .map(mapper -> ok(mapper))
                .name("hello").metrics();
    }

    private Mono<String> doSomething() {
        return Mono.just("data");
    }

    private Mono<String> doSomethingElse(String arg) {
        throw new RuntimeException("Exception");
    }

    private Mono<String> doSomethingElseElse(String arg) {
        throw new IllegalArgumentException("Exception");
    }
}
