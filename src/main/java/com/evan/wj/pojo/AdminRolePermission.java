package com.evan.wj.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @description:
 * @author: dxz
 * @date: 2021/4/22 17:33
 */
@Data
@Entity
public class AdminRolePermission{

    @Id
    private Integer id;

    private int rid;

    private int pid;
}
