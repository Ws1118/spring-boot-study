package com.ws.book.service;

import com.ws.book.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class BookServiceTest {
    @Resource
    private BookService bookService;

    @Test
    void save() {
        Book book = Book.builder()
                .name("Java")
                .cover("https://wshan.oss-cn-beijing.aliyuncs.com/kn01.jpg")
                .build();
        Book saveBook = bookService.save(book);
        log.info("id: " + saveBook.getId());
        assertEquals("Java", saveBook.getName());
    }

    @Test
    void getAll() {
        List<Book> books = bookService.getAll();
        log.info("books: " + books);
        assertEquals(5,books.size());
    }
}