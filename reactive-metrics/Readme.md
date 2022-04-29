# Read Me First

<http://localhost:8080/health>

<http://localhost:8080/metrics>

<http://localhost:8080/prometheus>

<http://localhost:8080/metrics/hello.flow.duration>

<http://localhost:8080/metrics/hello.subscribed>

```java
public static void main(String[] args) {
  SpringApplication.run(ReactiveMetricsApplication.class, args);
  Hooks.onOperatorDebug();
 }
```

Example of metrics with name and tags

```java
doSomething()
    .map(mapper -> ok(mapper))
    .name("hello")
    .tag("key", "value")
    .metrics();
```
