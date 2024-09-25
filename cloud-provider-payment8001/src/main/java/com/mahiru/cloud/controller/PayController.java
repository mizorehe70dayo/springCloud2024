package com.mahiru.cloud.controller;

import com.mahiru.cloud.entities.Pay;
import com.mahiru.cloud.entities.PayDTO;
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
     * @param pay Pay实体类
     * @return java.lang.String
     * @author mahiru
     * @date 2024/9/25 18:48
     * @methodName addPay
     * @description addPay方法
     */
    @PostMapping("/add")
    @Operation(summary = "新增", description = "新增支付流水方法,json串做参数")
    public String addPay(@RequestBody Pay pay) {
        log.info("addPay: {}", pay);

        int i = payService.add(pay);
        return "addPay: " + i;
    }

    /**
     * @param id Pay实体类id
     * @return java.lang.Integer
     * @author mahiru
     * @date 2024/9/25 18:52
     * @methodName deletePay
     * @description deletePay方法
     */
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "删除", description = "删除支付流水方法")
    public Integer deletePay(@PathVariable("id") Integer id) {
        log.info("deletePayId: {}", id);

        return payService.delete(id);
    }

    /**
     * @param payDTO PayDTO实体类
     * @return java.lang.String
     * @author mahiru
     * @date 2024/9/25 18:56
     * @methodName updatePay
     * @description updatePay方法
     */
    @PutMapping("/update")
    @Operation(summary = "修改", description = "修改支付流水方法")
    public String updatePay(@RequestBody PayDTO payDTO) {
        log.info("updatePay: {}", payDTO);

        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);

        int i = payService.update(pay);
        return "updatePay: " + i;
    }

    /**
     * @param id Pay实体类id
     * @return com.mahiru.cloud.entities.Pay
     * @author mahiru
     * @date 2024/9/25 20:11
     * @methodName getById
     * @description getById方法
     */
    @GetMapping("/get/{id}")
    @Operation(summary = "按照ID查流水", description = "查询支付流水方法")
    public Pay getById(@PathVariable("id") Integer id) {
        log.info("getPayId: {}", id);

        return payService.getById(id);
    }

    /**
     * @return java.util.List<com.mahiru.cloud.entities.Pay>
     * @author mahiru
     * @date 2024/9/25 20:14
     * @methodName getAll
     * @description getAll方法
     */
    @GetMapping("/get")
    @Operation(summary = "查询所有流水", description = "查询所有支付流水方法")
    public List<Pay> getAll() {
        return payService.getAll();
    }
}
