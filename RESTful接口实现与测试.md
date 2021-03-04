### RESTful接口实现与测试

#### RESTful接口与http协议状态表述

- RESTful风格API的好处
  - 看url就知道要什么资源
  - 看http method就知道针对资源干什么
  - 看http status code就知道结果如何

- RESTful API的设计风格

  - RESTful是面向资源的（名词）

  | 不符合REST的接口URL     | 符合REST的接口URL    | 功能           |
  | ----------------------- | -------------------- | -------------- |
  | GET/api/getDogs/{id}    | GET/api/dogs/{id}    | 获取一个小狗狗 |
  | GET/api/getDogs         | GET/api/dogs         | 获取所有小狗狗 |
  | GET/api/addDogs         | POST/api/dogs        | 添加一个小狗狗 |
  | GET/api/editDogs/{id}   | PUT/api/dogs/{id}    | 修改一个小狗狗 |
  | GET/api/deleteDogs/{id} | DELETE/api/dogs/{id} | 删除一个小狗狗 |

  - 用HTTP方法体现对资源的操作（动词）
    - GET：获取、读取资源
    - POST：添加资源
    - PUT：修改资源
    - DELETE：删除资源

- HTTP状态码（见本文课后作业）

  *GET方法和查询参数不应该改变数据，用POST、PUT、DELETE改变数据*

  *使用复数名词 /dogs而不是 /dog*

#### Spring RESTful常用注释

- HTTP协议的四种传参方式

| HTTP协议组成         | 协议内容示例                                    | 对应Spring注释 |
| -------------------- | ----------------------------------------------- | -------------- |
| path info传参        | /articles/12 (查询id为12的文章，12是参数)       | @PathVariable  |
| URL Query String传参 | /articles?id=12                                 | @RequestParam  |
| Body传参             | Content-Type:multipart/form-data                | @RequestParam  |
| Body传参             | Content-Type:appllication/json,或其他自定义格式 | @RequestBody   |
| Headers传参          |                                                 | @RequestHeader |

*@RestController 相当于@ResponseBody ＋ @Controller*

#### 三种@DeleteMapping

```java
 //删除
    @DeleteMapping("{id}")
    public  AjaxResponse deleteBook(@PathVariable int id,String title){
        log.info("id:"+id);
        return AjaxResponse.success();
    }

    //删除,表单请求
    @DeleteMapping()
    //public  AjaxResponse deleteBook(@RequestParam int id,@RequestParam String title){
    public  AjaxResponse deleteBook(@RequestParam(value ="id",defaultValue = "888") int idd,@RequestParam("tit") String tit){
        log.info("id:"+idd);
        log.info("title:"+tit);
        return AjaxResponse.success();
    }

    @DeleteMapping()
    public AjaxResponse deleteArticle(@RequestBody Param param){
        log.info("id:"+param.getId());
        log.info("title:"+param.getTitle());
        return AjaxResponse.success();
    }
```

#### [使用Mockito编码完成测试接口](https://blog.csdn.net/shenhuxi10000/article/details/105173340?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522161488413116780274127098%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=161488413116780274127098&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_v2~rank_v29-2-105173340.first_rank_v2_pc_rank_v29&utm_term=Mockito%E7%BC%96%E7%A0%81%E5%AE%8C%E6%88%90%E6%B5%8B%E8%AF%95%E6%8E%A5%E5%8F%A3)

#### 使用Swagger2构建API文档

```java
@RestController
@RequestMapping(value = "api/v1/books")
@Slf4j
public class BookController {
    @GetMapping("all")
    public AjaxResponse selectBooks(){
        BookReader[] readers={
                BookReader.builder()
                        .name("ddd")
                        .age(4)
                        .build(),
                BookReader.builder()
                        .name("ggg")
                        .age(20)
                        .build(),
        };
        List<BookReader> readerList= Arrays.asList(readers);
```

*@Slf4j ：日志*

### 课后作业

- http方法体现对资源的操作（动词）还有什么？
  - 除了常用的HTTP动词有下面四个（括号里是对应的SQL命令）
    - GET（SELECT）：从服务器取出资源（一项或多项）
    - POST（CREATE）：在服务器新建一个资源
    - PUT（UPDATE）：在服务器更新资源（客户端提供改变后的完整资源）
    - DELETE（DELETE）：从服务器删除资源
  - 还有三个不常用的HTTP动词
    - PATCH（UPDATE）：在服务器更新(更新)资源（客户端提供改变的属性，比如说某个字段+1）
    - HEAD：获取资源的元数据
    - OPTIONS：获取信息，关于资源的哪些属性是客户端可以改变的

- [常见的HTTP状态码详解](https://blog.csdn.net/weixin_43643121/article/details/108574679?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522161485344316780255271002%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=161485344316780255271002&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduend~default-1-108574679.first_rank_v2_pc_rank_v29&utm_term=%E5%B8%B8%E8%A7%81http%E7%8A%B6%E6%80%81%E7%A0%81)
- [常见的HTTP状态码大全](https://blog.csdn.net/weixin_44395707/article/details/107123735?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522161485344316780255271002%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=161485344316780255271002&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduend~default-2-107123735.first_rank_v2_pc_rank_v29&utm_term=%E5%B8%B8%E8%A7%81http%E7%8A%B6%E6%80%81%E7%A0%81)