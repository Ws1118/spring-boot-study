package com.example.boot.basic.dao;

import com.example.boot.basic.entity.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author dell
 * @date 2021/3/16
 * @description BookDAO
 **/
@Repository
public class BookDAO {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public Book save(Book book){
        String sql = "INSERT INTO t_book (author,title,content) VALUES (?,?,?) ";
        Object[] args = {book.getAuthor(), book.getTitle(),book.getContent()};
        int count = jdbcTemplate.update(sql, args);
        if (count == 1) {
            return book;
        }else{
            return null;
        }
    }

}
