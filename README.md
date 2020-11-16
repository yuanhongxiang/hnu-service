# nacos
## 实现配置自动刷新
    需在配置项的类上添加注解@RefreshScope
    如：@RestController
       @RequestMapping(value = "/nacosCont")
       @Api("nacos操作")
       @RefreshScope
       public class NacosControl 

# Log4j2
## 文件打印追加配置
    需在<appender-ref>标签添加