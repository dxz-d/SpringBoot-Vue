package com.evan.wj.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

/***
 * @description
 * @author diaoxiuze
 * @date 2021/1/27 15:31
 */
@Data
@Entity
public class AdminMenu {

    @Id
    private Integer id;

    private String path;

    private String name;

    private String nameZh;

    private String iconCls;

    private String component;

    private Integer parentId;

    @Transient
    List<AdminMenu> children;
}
