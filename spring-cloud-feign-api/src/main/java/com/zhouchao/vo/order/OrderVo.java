package com.zhouchao.vo.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zhouchao
 * @Date 2020/7/29 21:51
 * @Description
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderVo {
    private int id;
    private String orderId;
    private String orderName;
}
