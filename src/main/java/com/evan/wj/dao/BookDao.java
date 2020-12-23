package com.evan.wj.dao;

import com.evan.wj.pojo.Book;
import com.evan.wj.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/***
 * @description
 * @author diaoxiuze
 * @date 2020/12/6 16:17
 * @param
 * @return
 */
public interface BookDao extends JpaRepository<Book, Integer> {
    List<Book> findAllByCategory(Category category);

    List<Book> findByTitleLikeAndAuthorLike(String keyword1, String keyword2);

    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);
}
