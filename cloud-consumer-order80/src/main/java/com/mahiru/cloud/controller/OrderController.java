package com.mahiru.cloud.controller;

import com.mahiru.cloud.entities.PayDTO;
import com.mahiru.cloud.resp.ResultData;
import com.mahiru.cloud.resp.ReturnCodeEnum;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @className OrderController
 * @description Order控制层
 * @author mahiru
 * @date 2024/09/26 15:16
 * @version v1.0.0
**/
@RestController
@RequestMapping("/consumer/pay")
public class OrderController {
    // TODO 暂时写死后续改正
    public static final String PAYMENT_SRV_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    /**
     * @author mahiru
     * @date 2024/9/26 15:38
     * @methodName addOrder
     * @description 新增订单
     * @param payDTO 支付信息
     * @return com.mahiru.cloud.resp.ResultData
     */
    @PostMapping("/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO) {
        return restTemplate.postForObject(PAYMENT_SRV_URL + "/pay/add", payDTO, ResultData.class);
    }

    /**
     * @author mahiru
     * @date 2024/9/26 15:39
     * @methodName deleteOrder
     * @description 删除订单
     * @param id 主键id
     * @return com.mahiru.cloud.resp.ResultData
     */
    @DeleteMapping("/delete/{id}")
    public ResultData deleteOrder(@PathVariable("id") Integer id) {
        restTemplate.delete(PAYMENT_SRV_URL + "/pay/delete/" + id);
        return ResultData.success(ReturnCodeEnum.RC200.getCode());
    }


    /**
     * @author mahiru
     * @date 2024/9/26 15:39
     * @methodName updateOrder
     * @description 修改订单
     * @param payDTO 支付信息
     * @return com.mahiru.cloud.resp.ResultData
     */
    @PutMapping("/update")
    public ResultData updateOrder(@RequestBody PayDTO payDTO) {
        restTemplate.put(PAYMENT_SRV_URL + "/pay/update", payDTO, ResultData.class);
        return ResultData.success(ReturnCodeEnum.RC200.getCode());
    }

    /**
     * @author mahiru
     * @date 2024/9/26 15:39
     * @methodName listOrder
     * @description 查询所有订单
     * @return com.mahiru.cloud.resp.ResultData
     */
    @GetMapping()
    public ResultData listOrder() {
        return restTemplate.getForObject(PAYMENT_SRV_URL + "/pay/get", ResultData.class);
    }

    /**
     * @author mahiru
     * @date 2024/9/26 15:41
     * @methodName getPayInfo
     * @description 根据id查询订单
     * @param id 主键id
     * @return com.mahiru.cloud.resp.ResultData
     */
    @GetMapping("/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PAYMENT_SRV_URL + "/pay/get/" + id, ResultData.class);
    }
}
