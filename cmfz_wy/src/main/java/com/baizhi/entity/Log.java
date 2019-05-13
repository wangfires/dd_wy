package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Log {
    private String id;
    private String username;
    private Date createdate;
    private String methodName;
    private String success;
}
