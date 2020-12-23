package com.evan.wj.controller;

import com.evan.wj.pojo.Book;
import com.evan.wj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * @description
 * @author diaoxiuze
 * @date 2020/12/6 17:33
 * @param
 * @return
 */
@RestController
public class LibraryController {

    @Autowired
    BookService bookService;

    @GetMapping("/api/books")
    public List<Book> list() {
        return bookService.list();
    }

    @PostMapping("/api/books")
    public Book addOrUpdate(@RequestBody Book book) {
        bookService.addOrUpdate(book);
        return book;
    }

    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book) {
        bookService.deleteById(book.getId());
    }

    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) {
        if (cid !=0 ) {
            return bookService.listByCategory(cid);
        }else {
            return list();
        }
    }

    @CrossOrigin
    @GetMapping("/api/search")
    public List<Book> searchResult (@RequestParam("keywords") String keywords) {
        // 关键词为空时查询出所有书籍
        if(keywords.equals("")) {
            return bookService.list();
        } else {
            return bookService.search(keywords);
        }
    }
}
