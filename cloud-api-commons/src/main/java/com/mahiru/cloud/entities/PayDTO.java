package com.mahiru.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @className PayDTO
 * @description PayDTO实体类
 * @author mahiru
 * @date 2024/09/26 15:06
 * @version v1.0.0
**/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayDTO implements Serializable {
    /**
     * 支付ID
     */
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