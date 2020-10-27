**基础项目**

- Swagger在线接口文档
- CodeGenerator代码生成器
- 统一返回
- 通用的分页对象
- 常用工具类
- 全局异常拦截
- 错误枚举
- 自定义异常
- 多环境配置文件
- Maven多环境配置
- 日志配置
- JenkinsFile

Swagger可以在线生成接口文档，并且可以页面上进行测试，可以非常清楚的显示，请求数据和响应数据。

建议接口文档只在测试/开发环境开启，其他环境关闭。

常用的Swagger注解
- @Api用于Controller
- @ApiOperation用于Controller内的方法
- @ApiResponses用于标识接口返回数据的类型
- @ApiModel用于标识类的名称
- @ApiModelProperty用于标识属性的名称


CodeGenerator代码生成器

mybatis_plus代码生成器可以帮我们生成entity,service,serviceImpl,mapper.xml。省去了建立一大堆实体类的麻烦。


统一返回 ResultVo

将所有的rukkr响应数据的格式进行统一。

```java
@Data
@ApiModel("固定返回格式")
public class ResultVo {
    
    @ApiModelProperty("错误码")
    private Integer code;

    
    @ApiModelProperty("提示信息")
    private String message;

    
    @ApiModelProperty("响应数据")
    private Object data;

}
```

抽象表单

```java
public abstract class BaseForm<T> {
    
    public abstract T buildEntity();

}
```


全局异常拦截

全局异常拦截是使用@ControllerAdvice进行实现，常用的异常拦截配置可以查看GlobalExceptionnHandling

```java
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandling {
    
    @ExceptionHandler(value = CustomException.class)
    public ResultVo processException(CustomException e) {
        log.error("位置:{} -> 错误信息:{}", e.getMethod() ,e.getLocalizedMessage());
        return ResultVoUtil.error(Objects.requireNonNull(ResultEnum.getByCode(e.getCode())));
    }

    
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    public ResultVo exception(Exception e) {
        e.printStackTrace();
        return ResultVoUtil.error(ResultEnum.UNKNOWN_EXCEPTION);
    }
}
```


多环境配置

对于一个项目来讲基本都有4个环境dev,test,pre,prod，对于SpringBoot项目多建立几个配置文件就可以了。然后启动的时候可以通过配置spring.profiles.active来选择启动的环境。

```shell script
java -jar BasicProject.jat --spring.profiles.active=prod
```


Maven多环境配置

假如想在打包的时候动态指定环境，这个时候就需要借助Maven的xml来实现。

```xml
<profiles>
    <profile>
        
        <id>dev</id>
        <activation>
            <activeByDefault>true</activeByDefault>
        </activation>
        <properties>
            <activatedProperties>dev</activatedProperties>
        </properties>
    </profile>
    <profile>
        
        <id>test</id>
        <properties>
            <activatedProperties>test</activatedProperties>
        </properties>
    </profile>
    <profile>
        
        <id>pre</id>
        <properties>
            <activatedProperties>pre</activatedProperties>
        </properties>
    </profile>
    <profile>
        
        <id>prod</id>
        <properties>
            <activatedProperties>prod</activatedProperties>
        </properties>
    </profile>
</profiles>
```

更改application.yml

```yaml
spring:
  profiles:
    # 选择环境
    active: @activatedProperties@
```

```shell script
mvn clean package -P prod
mvn clean package -P pre
mvn clean package -P test
```

打包完可以解压开查看application.yml会发现spring.profiles.active=@activatedProperties@ 发生了改变。



日志配置

采用logback日志配置



jenkinsFile

JenkinsFile肯定上顾名思义是给jenkins用的。主要是配置项目根据如何进行构建并发布到不同的环境。需要去了解pipeline语法，以及如何配置jenkins。




















