package com.gnnu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Class extends BaseEntity {

    private String name;
    private Integer tId; //班主任id

    @TableField(exist = false)
    private List<Student> studentList;
    @TableField(exist = false)
    private List<Teacher> teacherList;

}
