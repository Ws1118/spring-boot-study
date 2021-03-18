package com.example.boot.basic.service.impl;

import com.example.boot.basic.dao.BookDAO;
import com.example.boot.basic.entity.Book;
import com.example.boot.basic.service.BookService;

import javax.annotation.Resource;

/**
 * @author dell
 * @date 2021/3/16
 * @description BookServiceImpl
 **/
public class BookServiceImpl implements BookService {
    @Resource
    private BookDAO bookDAO;

//    @Override
//    public boolean postBook(Book book) {
//        return book.save(book);
//    }
}
