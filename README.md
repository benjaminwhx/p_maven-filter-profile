# maven-filter-profile说明

`src/main/conf` 下为多种环境的配置文件，通过命令 `mvn clean install -Ptest` 来指定使用哪个环境的文件，默认dev。

`src/main/resources` 下为通用配置文件，不需要多环境进行配置。

为了统一管理配置文件，在spring-config.xml中只扫描 `src/main/resources/properties` 下的配置文件，所以我们必须把 `src/main/conf` 下的文件从 `${baseDir}/target/classes` 移动到 `${baseDir}/target/classes/properties` 下。我们在maven的pom.xml中配置了以下的resource选项用来把maven打包的文件copy到指定的目录下：
```java
<resource>
    <directory>src/main/conf/${env}</directory>
    <!-- copy到目标目录 -->
    <targetPath>${basedir}/target/classes/properties</targetPath>
</resource>
```