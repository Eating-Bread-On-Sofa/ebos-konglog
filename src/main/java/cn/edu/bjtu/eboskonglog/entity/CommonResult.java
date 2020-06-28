package cn.edu.bjtu.eboskonglog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 返回给前端的通用的json数据串
 * @author chancey
 * @create 2020-06-16 20:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer status;//状态码。如404、200
    private String message;//成功或失败的展示信息
    private T data;//T实体类的所有属性信息

    public CommonResult(Integer status, String message){
        this(status, message, null);
    }
}

