## validationメモ

### エラーハンドリング

restの場合、エラーハンドリングは基本的に、`@ExceptionHandler`で実施する。
`BindingResult`は、画面用を想定してる気がする。

* リクエストパラメータから取得する場合（Get）の場合は、精査エラー時に`org.springframework.validation.BindException`が発生する
* リクエストボディから取得する場合（Post）の場合は、`org.springframework.web.bind.MethodArgumentNotValidException`が発生する。
* JSONとかのパースに失敗した場合は、`org.springframework.http.converter.HttpMessageNotReadableException`が発生する。

＜参考情報＞
http://terasolunaorg.github.io/guideline/5.0.1.RELEASE/ja/ArchitectureInDetail/REST.html#resthowtouseexceptionhandlingforvalidationerror