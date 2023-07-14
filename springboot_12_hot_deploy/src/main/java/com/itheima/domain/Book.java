package com.itheima.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.domain
 * @Author: ASUS
 * @CreateTime: 2023-07-08  09:31
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Integer id;
    private String type;
    private String name;
    private String description;

}
