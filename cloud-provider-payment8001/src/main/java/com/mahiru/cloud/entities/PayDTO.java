package com.mahiru.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author mahiru
 * @version v1.0.0
 * @className PayDTO
 * @description Pay实体类视图层
 * @date 2024/09/25 18:25
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayDTO implements Serializable {
    private Integer id;
    /**
     * 支付流水号
     */
    private String payNo;
    /**
     * 订单流水号
     */
    private String orderNo;
    /**
     * 用户账号ID
     */
    private Integer userId;
    /**
     * 交易金额
     */
    private BigDecimal amount;
}