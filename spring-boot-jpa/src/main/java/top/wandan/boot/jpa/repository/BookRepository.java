package top.leikai.boot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.leikai.boot.jpa.entity.Book;

/**
 * @author admin
 */
public interface BookRepository extends JpaRepository<Book,Integer> {
}
