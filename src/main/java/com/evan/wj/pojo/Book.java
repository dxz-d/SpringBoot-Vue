package com.evan.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/***
 * @description
 * @author diaoxiuze
 * @date 2020/12/6 16:09
 * @param
 * @return
 */
@Data
@Entity
public class Book {

    @Id
    private Integer id;

    @Column(name = "cover")
    private String cover;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "date")
    private String date;

    @Column(name = "press")
    private String press;

    @Column(name = "abs")
    private String abs;

    @ManyToOne
    @JoinColumn(name = "cid")
    private Category category;
}
