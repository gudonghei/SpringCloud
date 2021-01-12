package com.gudonghei.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: CommonResult
 * @Description: TODO(一句话描述该类的功能)
 * @Author: ZJH
 * @Date: 2020/10/20 10:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T date;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }

}
