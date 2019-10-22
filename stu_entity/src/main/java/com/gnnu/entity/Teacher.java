package com.gnnu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Teacher extends BaseEntity {

    private String name;
    private Integer age;
    private String sex;
    private String password;
    private String phone;
    private String address;
}
