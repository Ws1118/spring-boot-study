package top.leikai.boot.jpa.service;


import top.leikai.boot.jpa.entity.Book;

import java.util.List;

/**
 * @author admin
 */
public interface BookService {
    /**
     * 新增Book
     * @param book 入参
     * @return 新增book对象
    **/
    Book save (Book book);
    /**
     *查询所有book
     *
     * @return 图书集合
     * **/
    List<Book> getAll();
}
