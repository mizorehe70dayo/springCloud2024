package com.mahiru.cloud.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 表名：t_pay
 * 表注释：支付交易表
 *
 * @author biers
 */
@Setter
@Getter
@Table(name = "t_pay")
@Schema(description = "支付交易表Entity")
public class Pay {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @Schema(description = "主键ID")
    private Integer id;

    /**
     * 支付流水号
     */
    @Column(name = "pay_no")
    @Schema(description = "支付流水号")
    private String payNo;

    /**
     * 订单流水号
     */
    @Column(name = "order_no")
    @Schema(description = "订单流水号")
    private String orderNo;

    /**
     * 用户账号ID
     */
    @Column(name = "user_id")
    @Schema(description = "用户账号ID")
    private Integer userId;

    /**
     * 交易金额
     */
    @Schema(description = "交易金额")
    private BigDecimal amount;

    /**
     * 删除标志，默认0不删除，1删除
     */
    @Schema(description = "删除标志，默认0不删除，1删除")
    private Byte deleted;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @Schema(description = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @Schema(description = "更新时间")
    private Date updateTime;
}