package com.mahiru.cloud.controller;

import com.mahiru.cloud.entities.Pay;
import com.mahiru.cloud.entities.PayDTO;
import com.mahiru.cloud.resp.ResultData;
import com.mahiru.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mahiru
 * @version v1.0.0
 * @className PayController
 * @description Pay实体类控制层
 * @date 2024/09/25 18:43
 **/
@RestController
@Slf4j
@RequestMapping("/pay")
@Tag(name = "支付微服务模块", description = "支付CRUD")
public class PayController {

    @Resource
    private PayService payService;

    /**
     * @author mahiru
     * @date 2024/9/26 13:36
     * @methodName addPay
     * @description 新增支付流水方法,json串做参数
     * @param pay Pay实体类
     * @return com.mahiru.cloud.resp.ResultData<java.lang.String>
     */
    @PostMapping("/add")
    @Operation(summary = "新增", description = "新增支付流水方法,json串做参数")
    public ResultData<String> addPay(@RequestBody Pay pay) {
        log.info("addPay: {}", pay);

        int i = payService.add(pay);
        return ResultData.success("成功插入记录，返回值为： " + i);
    }

    /**
     * @author mahiru
     * @date 2024/9/26 13:39
     * @methodName deletePay
     * @description 删除支付流水方法
     * @param id Pay实体类id
     * @return com.mahiru.cloud.resp.ResultData<java.lang.Integer>
     */
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "删除", description = "删除支付流水方法")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id) {
        log.info("deletePayId: {}", id);

        int i = payService.delete(id);
        return ResultData.success(i);
    }

    /**
     * @author mahiru
     * @date 2024/9/26 13:41
     * @methodName updatePay
     * @description 修改支付流水方法
     * @param payDTO PayDTO实体类
     * @return com.mahiru.cloud.resp.ResultData<java.lang.String>
     */
    @PutMapping("/update")
    @Operation(summary = "修改", description = "修改支付流水方法")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO) {
        log.info("updatePay: {}", payDTO);

        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);

        int i = payService.update(pay);
        return ResultData.success("成功修改记录，返回值为: " + i);
    }

    /**
     * @author mahiru
     * @date 2024/9/26 13:42
     * @methodName getById
     * @description 按照ID查流水方法
     * @param id Pay实体类id
     * @return com.mahiru.cloud.resp.ResultData<com.mahiru.cloud.entities.Pay>
     */
    @GetMapping("/get/{id}")
    @Operation(summary = "按照ID查流水", description = "查询支付流水方法")
    public ResultData<Pay> getById(@PathVariable("id") Integer id) {
        log.info("getPayId: {}", id);

        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    /**
     * @author mahiru
     * @date 2024/9/26 13:43
     * @methodName getAll
     * @description 查询所有流水方法
     * @return com.mahiru.cloud.resp.ResultData<java.util.List<com.mahiru.cloud.entities.Pay>>
     */
    @GetMapping("/get")
    @Operation(summary = "查询所有流水", description = "查询所有支付流水方法")
    public ResultData<List<Pay>> getAll() {
        List<Pay> payList = payService.getAll();
        return ResultData.success(payList);
    }
}
