package com.zhouchao.user.controller.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zhouchao
 * @Date 2020/7/28 20:08
 * @Description
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
    private int id;
    private String name;
    private String sex;
}
