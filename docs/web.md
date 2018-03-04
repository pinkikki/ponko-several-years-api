# web共通のメモ

## Filterメモ

Filterを登録する場合は、該当のFilterを`@Bean`でコンテナに登録するだけ
※これって`@Component`でもよいのでは？？未確認

```java
@Bean
public XXXFilter xxxFilter() {
  return new XXXFilter();  
}
```

Filterの適用順序等、細かな設定を実施したい場合は、`FilterRegistrationBean`を利用する模様

`
@Bean
public FilterRegistrationBean commonsRequestLoggingFilter(){
FilterRegistrationBean registrationBean = new FilterRegistrationBean(new CommonsRequestLoggingFilter());
    registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE); // 優先度を指定。優先度が高い方が先に適用される。
    return registrationBean;
}
`

なんか、`@Order`でもFilterの順序は指定できそうだけど、spring-securityを使用した場合はできない？？

## ServletRequestListener

Filterと同じ

```java
@Bean
public RequestContextListener requestContextListener(){
    return new RequestContextListener();
}
```

`@Component`でもいける模様
なので、Filterも`@Component`でいけるのではないかと思う

```java
@Component
@Order(Ordered.HIGHEST_PRECEDENCE) // 必要に応じて優先度を指定。優先度が高い方が先に適用される。
public class CustomServletRequestListener implements ServletRequestListener {
   // ...
}
```

＜参考文献＞
https://qiita.com/kazuki43zoo/items/757b557c05f548c6c5db

## リクエスト共通の処理

順に、

* javax.servlet.Filter.ServletRequestListene
* javax.servlet.Filter
* HandlerInterceptor
* @ControllerAdvice
* @Aspect

がある。
Controllerに処理を割り込みたい場合は、基本的に`HandlerInterceptor`を使用するのかな。
`@Aspect`でもできそうな気がするけど。

＜参考文献＞
https://qiita.com/kazuki43zoo/items/757b557c05f548c6c5db