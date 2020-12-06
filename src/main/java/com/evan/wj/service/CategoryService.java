package com.evan.wj.service;

import com.evan.wj.dao.CategoryDao;
import com.evan.wj.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @description
 * @author diaoxiuze
 * @date 2020/12/6 16:24
 * @param
 * @return
 */
@Service
public class CategoryService {

    @Autowired
    CategoryDao categoryDao;

    public List<Category> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDao.findAll(sort);
    }

    public Category get(int id) {
        Category category = categoryDao.findById(id).orElse(null);
        return category;
    }
}
