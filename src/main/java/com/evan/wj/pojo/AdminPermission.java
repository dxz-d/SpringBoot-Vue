package com.evan.wj.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @description:
 * @author: dxz
 * @date: 2021/5/10 17:21
 */
@Data
@Entity
public class AdminPermission {

    @Id
    private int id;

    private String name;

    private String desc_;

    private String url;
}
