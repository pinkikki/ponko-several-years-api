# cors対策メモ

### Controllerの各メソッドに、`@CrossOrigin`を付与する方法

```java
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path = "find")
    public List<Event> find() {
        return eventService.findAll();
    }
```

クラスに付与でもいいっぽい

```java
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("hero")
public class EventController {
```

### WebMvcConfigurerAdapterでやる方法

```java

@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/hero/find").allowedOrigins("http://localhost:8080");
    }

}
```

Filterでやる場合は`CorsFilter`を登録

```java
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
```
