package com.evan.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/***
 * @description
 * @author diaoxiuze
 * @date 2021/1/27 14:45
 */
@Data
@Entity
public class AdminUserRole {

    @Id
    private Integer id;

    private Integer uid;

    private Integer rid;
}
