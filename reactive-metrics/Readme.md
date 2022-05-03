# Read Me First

## Endpoints

<http://localhost:8080/health>

<http://localhost:8080/metrics>

<http://localhost:8080/prometheus>

<http://localhost:8080/metrics/hello.flow.duration>

<http://localhost:8080/metrics/hello.subscribed>

## Java Hook to batter log visualization

```java
public static void main(String[] args) {
  SpringApplication.run(ReactiveMetricsApplication.class, args);
  Hooks.onOperatorDebug();
 }
```

## Example of metrics with name and tags

```java
doSomething()
    .map(mapper -> ok(mapper))
    .name("hello")
    .tag("key", "value")
    .metrics();
```

## Run prometheus

```bash
cd prometheus

chmod +x ./prometheus.sh

./prometheus.sh 
```

<http://localhost:9090/>
