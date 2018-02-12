# mybatisに関するメモ

### generator

```
mvn mybatis-generator:generate

```

### Mapperのxmlの配置場所

resourcesの配下に格納しないと、以下のExceptionが発生

```java
org.apache.ibatis.binding.BindingException: Invalid bound statement (not found)
```


### SpringのDIコンテナに登録

以下のどちらかでDIコンテナに登録可能

* Mapperクラスに`@Mapper`を付与する（Mybatisのgeneratorを使用した場合、`@Mapper`は付与されていない
* `@MapperScan`でスキャン対象のパッケージを指定

### Mapperインターフェースのプロキシ

＜参考文献＞
https://terasolunaorg.github.io/guideline/5.0.0.RELEASE/ja/ArchitectureInDetail/DataAccessMyBatis3.html#dataaccessmybatis3overviewaboutcomponentconstitutionofmybatis3

### generatorにて生成したmapper / xmlを使用する場合
#### Selective

insertSelective / updateSelectiveは、
例えばupdateしとうとしたときにメンバ変数がnullだとして、
Selectiveの場合は、Nullにならない。（Nullで更新されない）

#### XXXExample

Exampleクラスは、where句の指定に使用できるが、EquealTo等にnullを指定するとエラーとなってしまう。
例えば、以下のような場合に、objectNameがnullだったら、エラーとなる。

```java
EventExample eventExample = new EventExample();
eventExample
        .createCriteria()
        .andEventIdEqualTo(eventId)
        .andObjectNameEqualTo(objectName);
```


なので、あまりgeneratorで生成したものは実用的ではなさそうなイメージ

terasolunaに記載されているような使用が、よいのかも

<参考文献＞
https://terasolunaorg.github.io/guideline/5.0.0.RELEASE/ja/ArchitectureInDetail/DataAccessMyBatis3.html