package test.hanjie.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by 10568 on 2020/10/16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    //404
    private Integer code;
    private String  message;
    private T       data;

    //仅有两个参数时的构造
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
