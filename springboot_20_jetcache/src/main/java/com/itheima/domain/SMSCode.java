package com.itheima.domain;

import lombok.Data;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itehima.domain
 * @Author: ASUS
 * @CreateTime: 2023-07-19  14:13
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class SMSCode {
    private String telephone;
    private String code;
}
