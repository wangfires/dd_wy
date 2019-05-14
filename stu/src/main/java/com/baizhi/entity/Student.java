package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Student {
    private String id;
    private String name;
    private Integer age;
    private String sex;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bir;
    private String email;
    private String qq;
    private String phone;
    private String addr;
    private String clazzid;
    private String groupid;
    private String cityid;
    private Clazz clazz;
    private Group group;
    private City city;
    private List<Tag> tags;
}
