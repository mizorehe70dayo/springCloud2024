package com.mahiru.cloud.service;

import com.mahiru.cloud.entities.Pay;

import java.util.List;

/**
 * @author mahiru
 * @version v1.0.0
 * @className PayService
 * @description Pay业务层接口
 * @date 2024/09/25 18:30
 **/
public interface PayService {

    /**
     * 添加支付信息
     *
     * @param pay 支付信息对象
     * @return 影响的行数
     */
    int add(Pay pay);

    /**
     * 根据id删除支付信息
     *
     * @param id 支付信息的唯一标识
     * @return 影响的行数
     */
    int delete(Integer id);

    /**
     * 更新支付信息
     *
     * @param pay 支付信息对象
     * @return 影响的行数
     */
    int update(Pay pay);

    /**
     * 根据id获取支付信息
     *
     * @param id 支付信息的唯一标识
     * @return 支付信息对象
     */
    Pay getById(Integer id);

    /**
     * 获取所有支付信息
     *
     * @return 支付信息对象列表
     */
    List<Pay> getAll();
}
