package com.ws.book.service;

import com.ws.book.entity.Book;

import java.util.List;

public interface BookService {
    /**
     * 新增book
     *
     * @param book 入参
     * @return 新增的book对象
     */
    Book save(Book book);

    /**
     * 查询所有book
     * @return 图书集合
     */
    List<Book> getAll();
}
