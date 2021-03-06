package com.evan.wj.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/***
 * @description
 * @author diaoxiuze
 * @date 2020/12/6 16:01
 * @param
 * @return
 */
@Data
@Entity
public class Category {

    @Id
    private Integer id;

    @Column(name = "name")
    private String name;
}
