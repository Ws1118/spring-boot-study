package com.example.boot.basic.controller;

import com.example.boot.basic.controller.dto.AjaxResponse;
import com.example.boot.basic.controller.dto.Param;
import com.example.boot.basic.entity.ArticleReader;
import com.example.boot.basic.entity.Book;
import com.example.boot.basic.entity.BookReader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author dell
 * @date 2021/3/4
 * @description BookController
 */

@Slf4j
@RestController
@RequestMapping(value = "api/v1/books")
@Api(tags = "书籍管理接口")
public class BookController {

//    创建线程安全的Map，模拟books信息的存储
//    static Map<Integer,Book> books = Collections.synchronizedMap(new HashMap<>());
    /**
     * 查询⽂章，id为URL查询参数
     *
     * 获取一本Book，使用GET方法，根据id查询一篇文章，路径参数
     * @param id ⽂章id
     * @return AjaxResponse
     */
//    @ApiOperation(value = "URL传参，根据id获取⽂章",notes = "URL传参，根据id获取⽂章")
//    @GetMapping("{id}")
    @ApiOperation("URL传参，根据id获取⽂章")
    @GetMapping()
    public AjaxResponse getBookByParam(@ApiParam("⽂章id") @RequestParam("id") int id) {
            BookReader[] readers = {
            BookReader.builder().name("aaa").age(20).build(),
            BookReader.builder().name("bbb").age(19).build()};
            List<BookReader> readerList = Arrays.asList(readers);
            Book book = Book.builder()
            .id(id)
            .author("ws")
            .title("Spring Boot从⼊⻔到精通")
            .content("Spring Boot从⼊⻔到精通")
            .createTime(new Date())
            .readers(readerList)
            .build();
            log.info("book: " + book);
            return AjaxResponse.success(book);
    }
    /**
     * 增加⼀篇Article ，@RequestParam接收参数
     *
     * @param id id
     * @param author 作者
     * @param title 标题
     * @param content 内容
     * @param createTime 创建时间
     * @return AjaxResponse
     */
    @ApiOperation("URL传参新增⽂章")
    @PostMapping("param")
    public AjaxResponse saveABook(
            @ApiParam("⽂章id")
            @RequestParam(value = "id", defaultValue =
                    "123", required = false) int id,
            @ApiParam("作者")
            @RequestParam(value = "author", defaultValue =
                    "ws", required = false) String author,
            @ApiParam("标题")
            @RequestParam String title,
            @ApiParam("内容")
            @RequestParam String content,
            @ApiParam("创建时间")
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            @RequestParam(value = "createTime", defaultValue = "2021-03-08 14:56:31", required = false) Date createTime) {
            Book book = Book.builder()
                .id(id)
                .title(title)
                .content(content)
                .author(author)
                .createTime(createTime)
                .build();
        log.info("saveBook:" + book);
        return AjaxResponse.success(book);
    }
    /**
     * 增加⼀篇Article @RequestParam取得表单对象序列化的字符串
     *
     * @param formData 表单对象序列化的字符串
     * @return AjaxResponse
     */
    @ApiOperation("表单请求体新增⽂章")
    @PostMapping("form")
    public AjaxResponse saveArticleByFormData(@ApiParam("表 单字符串") @RequestParam("formData") String formData) {
            //表单传递的数据为字符串
            log.info("formData:" + formData);
            //⽤Jackson的反序列化将字符串转为Java对象
            ObjectMapper objectMapper = new ObjectMapper();
            Book book = null;
            try {
            book = objectMapper.readValue(formData, Book.class);
            log.info("book:" + book);
} catch (
        JsonProcessingException e) {
        e.printStackTrace();
        }
        return AjaxResponse.success(book);
        }


    @ApiOperation("获取所有")
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
        Book book1= Book.builder()
                .id(123)
                .author("ws")
                .title("SpringBoot")
                .content("SpringBoot从入门到入狱")
                .createTime(new Date())
                .readers(readerList)
                .build();

        Book book2= Book.builder()
                .id(111)
                .author("ws")
                .title("Vue.js")
                .content("Vue.js从入门到入狱")
                .createTime(new Date())
                .readers(readerList)
                .build();
        Book[] books={book1,book2};
        List<Book> booklist=Arrays.asList(books);

        return AjaxResponse.success(booklist);
    }
    @ApiOperation("获取一个")
    @GetMapping("{id}")
    public AjaxResponse getBook(@PathVariable int id){
        Book book= Book.builder()
                .id(id)
                .author("ws")
                .title("java")
                .content("java")
                .createTime(new Date())
                .build();
        return AjaxResponse.success(book);
    }

    @ApiOperation("添加")
    @PostMapping()
    public AjaxResponse saveBook(@RequestBody Book book){
        log.info("saveBook:"+book);
        return AjaxResponse.success(book);
    }

    @ApiOperation("修改")
    @PutMapping()    //修改,通过问号传参
    public  AjaxResponse updateBook(@RequestParam int id,@RequestParam String title){
        Book book= Book.builder()
                .id(id)
                .author("ws")
                .title("java")
                .content("java")
                .createTime(new Date())
                .build();
        book.setTitle(title);
        log.info("book:"+book);
        return AjaxResponse.success(book);
    }
    //删除
//    @DeleteMapping("{id}")
//    public  AjaxResponse deleteBook(@PathVariable int id,String title){
//        log.info("id:"+id);
//        return AjaxResponse.success();
//    }

    //删除,表单请求
    @ApiOperation("删除书本")
    @DeleteMapping()
    public AjaxResponse deleteBook(@RequestParam(value = "id",defaultValue = "111")int idd,@RequestParam("title")String ti){
        log.info("id:" + idd);
        log.info("title:"+ti);
        return AjaxResponse.success();
    }

//    @DeleteMapping()
//    public AjaxResponse deleteArticle(@RequestBody Param param){
//        log.info("id:"+param.getId());
//        log.info("title:"+param.getTitle());
//        return AjaxResponse.success(param);
//    }
//    @ApiOperation("删除书本")
//    @DeleteMapping("delete")
//    public AjaxResponse deleteBook(@RequestBody Param param) {
//        log.info("id:" + param.getId());
//        log.info("title:" + param.getTitle());
//        return AjaxResponse.success(param);
//    }

    @PostMapping("upload")
    public AjaxResponse handleUpload(MultipartFile file, HttpServletRequest request){
//        创建文件在服务器的存放路径
        String path = request.getServletContext().getRealPath("/upload");
        log.info(path);
        File fileDir = new File(path);
        if(!fileDir.exists()) {
            boolean flag = fileDir.mkdirs();
            log.info("flag:"+flag);
        }
//        生成文件在服务器的名称的前缀
        String prefixName = UUID.randomUUID().toString();
//        取得源文件
        String originalFilename = file.getOriginalFilename();
//        if (originalFilename != null) {
//        从原文件名中分离出扩展名（后缀） 111.jpg -> .jpg
//            assert originalFilename != null;
//            String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
//        拼接新的文件名
//            String fileName = prefixName + suffixName;
//        }

//        从原文件名中分离出扩展名（后缀） 111.jpg -> .jpg
            assert originalFilename != null;
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
//        拼接新的文件名
        String fileName = prefixName + suffixName;
        log.info(fileName);
//        上传文件
        File saveFile = new File(path + "/" + fileName);
//        上传
        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            log.info(e.getMessage());
            AjaxResponse.failure("文件上传失败");
        }
        return AjaxResponse.success(fileName);
    }
}