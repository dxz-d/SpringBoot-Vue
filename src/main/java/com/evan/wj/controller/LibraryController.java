package com.evan.wj.controller;

import com.evan.wj.pojo.Book;
import com.evan.wj.service.BookService;
import com.evan.wj.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    /**
     * 展示图书列表
     * @return
     */
    @GetMapping("/api/books")
    public List<Book> list() {
        return bookService.list();
    }

    /**
     * 添加或者修改图书
     * @param book
     * @return
     */
    @PostMapping("/api/books")
    public Book addOrUpdate(@RequestBody Book book) {
        bookService.addOrUpdate(book);
        return book;
    }

    /**
     * 删除图书（物理删除）
     * @param book
     */
    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book) {
        bookService.deleteById(book.getId());
    }

    /**
     * 分类图书列表
     * @param cid
     * @return
     */
    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) {
        if (cid !=0 ) {
            return bookService.listByCategory(cid);
        }else {
            return list();
        }
    }

    /**
     * 通过书名或作者搜索
     * @param keywords
     * @return
     */
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

    /**
     * 上传URL
     * @param file
     * @return
     * @throws IOException
     */
    @CrossOrigin
    @PostMapping("/api/covers")
    public String coversUpload(MultipartFile file) throws Exception {
        String folder = "D:/workspace/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8095/api/file/" + f.getName();
            return imgURL;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return "";
        }
    }
}
