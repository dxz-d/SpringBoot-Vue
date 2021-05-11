package com.evan.wj.dto;

import com.evan.wj.dto.base.OutputConverter;
import com.evan.wj.pojo.AdminRole;
import com.evan.wj.pojo.User;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @description:
 * @author: dxz
 * @date: 2021/5/11 10:09
 */
@Data
@ToString
public class UserDto implements OutputConverter<UserDto, User> {

    private int id;

    private String username;

    private String name;

    private String phone;

    private String email;

    private boolean enabled;

    private List<AdminRole> roles;
}
