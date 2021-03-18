package com.ws.book.service.impl;

import com.ws.book.entity.Book;
import com.ws.book.repository.BookRepository;
import com.ws.book.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dell
 * @date 2021/3/18
 * @description BookServiceImpl
 **/
@Service
@Transactional(rollbackFor = {RuntimeException.class})
public class BookServiceImpl implements BookService {
    @Resource
    private BookRepository bookRepository;

    @Override
    public Book save(Book book){
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAll(){
        return bookRepository.findAll();
    }
}
