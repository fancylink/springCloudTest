package test.hanjie.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by 10568 on 2020/10/16.
 */
@Data
//全参构造
@AllArgsConstructor
//空参构造
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
