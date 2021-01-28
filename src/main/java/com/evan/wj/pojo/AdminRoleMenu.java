package com.evan.wj.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/***
 * @description
 * @author diaoxiuze
 * @date 2021/1/27 15:16
 */
@Data
@Entity
public class AdminRoleMenu {

    @Id
    private Integer id;

    private Integer rid;

    private Integer mid;
}
