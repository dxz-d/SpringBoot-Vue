package com.evan.wj.dao;

import com.evan.wj.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 * @description
 * @author diaoxiuze
 * @date 2020/12/6 16:22
 * @param
 * @return
 */
public interface CategoryDao extends JpaRepository<Category, Integer> {
}
