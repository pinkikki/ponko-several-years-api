# restメモ

## リクエストの取得方法

### GET

webと同様

### POST / PUT / DELETE

`@RequestBody`を使用して、ボディのデータを取得して、Form等にマッピング。
JSON→Form等は、`HttpMessageConverter`がJackson等を使用して自動変換してくれる。

## レスポンス

レスポンスは、`HttpMessageConverter`がJSON等に変換してくれるので、
Jacksonの`JsonFormat`等を使用して、変換形式の詳細を設定する
なお、`@RestController`や`@RestControllerAdvice`には、`@ResponseBody`が付与されているので、
あえて各メソッドに付与する必要はない

## `HttpMessageConverter`

デフォルト適用される`HttpMessageConverter`の設定等を変更したい場合は、
`WebMvcConfigurerAdapter#extendMessageConverters`をoverrideする

デフォルトのHttpMessageConverterを適用したくない場合は、`configureMessageConverters`をoverrideする。

なお、デフォルトの`HttpMessageConverter`は以下のようなもの

* ByteArrayHttpMessageConverter
* StringHttpMessageConverter
* ResourceHttpMessageConverter
* AllEncompassingFormHttpMessageConverter
* MappingJackson2HttpMessageConverter
* GsonHttpMessageConverter
* MappingJackson2XmlHttpMessageConverter
* Jaxb2RootElementHttpMessageConverter