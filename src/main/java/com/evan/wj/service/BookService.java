package com.evan.wj.service;

import com.evan.wj.dao.BookDao;
import com.evan.wj.pojo.Book;
import com.evan.wj.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @description
 * @author diaoxiuze
 * @date 2020/12/6 16:34
 * @param
 * @return
 */
@Service
public class BookService {
    @Autowired
    BookDao bookDao;

    @Autowired
    CategoryService categoryService;

    public List<Book> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return bookDao.findAll(sort);
    }

    public void addOrUpdate(Book book) {
        bookDao.save(book);
    }

    public void deleteById(int id) {
        bookDao.deleteById(id);
    }

    public List<Book> listByCategory(int cid) {
        Category category = categoryService.get(cid);
        return bookDao.findAllByCategory(category);
    }

    public List<Book> search(String keywords) {
        return bookDao.findAllByTitleLikeOrAuthorLike('%'+keywords+'%', '%'+keywords+'%');
    }
}
