# testメモ

以下が大事

* @RunWith(SpringRunner.class)　→　SpringJUnit4ClassRunnerの別名
* @SpringBootTest
* @AutoConfigureMockMvc

### @RunWith(SpringRunner.class)

これを付与するとDIできる

### @SpringBootTest

spring boot関連のクラスをauto configurationする
これを付与しない場合は、`@ContextConfiguration(classes = AppConfig.class)`みたいに、自分でconfigurationするクラスを指定する

### @AutoConfigureMockMvc

Controllerをテストするために付与