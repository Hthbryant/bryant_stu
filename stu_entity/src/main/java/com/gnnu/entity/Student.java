package com.gnnu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Student extends BaseEntity {

    private String name;
    private String password;
    private String sex;
    private Integer age;
    private String address;
    private String phone;
    private Integer cId;


    @TableField(exist = false)
    private Integer tId;
    @TableField(exist = false)
    private Class cls;

}
