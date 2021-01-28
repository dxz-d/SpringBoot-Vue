package com.evan.wj.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/***
 * @description
 * @author diaoxiuze
 * @date 2021/1/27 15:14
 */
@Data
@Entity
public class AdminRole {

    @Id
    private Integer id;

    private String name;

    private String nameZh;

    private Integer enabled;
}
