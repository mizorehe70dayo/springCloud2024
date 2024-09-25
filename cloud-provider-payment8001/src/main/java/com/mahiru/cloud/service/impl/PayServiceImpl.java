package com.mahiru.cloud.service.impl;

import com.mahiru.cloud.entities.Pay;
import com.mahiru.cloud.mapper.PayMapper;
import com.mahiru.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mahiru
 * @version v1.0.0
 * @className PayServiceImpl
 * @description Pay业务层实现类
 * @date 2024/09/25 18:32
 **/
@Service
public class PayServiceImpl implements PayService {

    @Resource
    private PayMapper payMapper;

    /**
     * 添加支付信息
     *
     * @param pay 支付信息对象
     * @return 影响的行数
     */
    @Override
    public int add(Pay pay) {
        // 向数据库中插入一条记录
        return payMapper.insertSelective(pay);
    }

    /**
     * 根据id删除支付信息
     *
     * @param id 支付信息的唯一标识
     * @return 影响的行数
     */
    @Override
    public int delete(Integer id) {
        // 根据id删除一条记录
        return payMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新支付信息
     *
     * @param pay 支付信息对象
     * @return 影响的行数
     */
    @Override
    public int update(Pay pay) {
        // 根据id更新一条记录
        return payMapper.updateByPrimaryKeySelective(pay);
    }

    /**
     * 根据id获取支付信息
     *
     * @param id 支付信息的唯一标识
     * @return 支付信息对象
     */
    @Override
    public Pay getById(Integer id) {
        // 根据id查询一条记录
        return payMapper.selectByPrimaryKey(id);
    }

    /**
     * 获取所有支付信息
     *
     * @return 支付信息对象列表
     */
    @Override
    public List<Pay> getAll() {
        // 查询所有记录
        return payMapper.selectAll();
    }
}
