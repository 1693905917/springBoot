package com.itheima.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima.bean
 * @Author: ASUS
 * @CreateTime: 2023-07-24  15:12
 * @Description: TODO
 * @Version: 1.0
 */
//@Component
@Data
@EnableConfigurationProperties(CartoonProperties.class)
public class CartoonCatAndMouse {
    private Cat cat;
    private Mouse mouse;

    private CartoonProperties cartoonProperties;

        public CartoonCatAndMouse(CartoonProperties cartoonProperties){
            this.cartoonProperties = cartoonProperties;
            cat = new Cat();
            cat.setName(cartoonProperties.getCat()!=null &&
                    StringUtils.hasText(cartoonProperties.getCat().getName()) ?
                    cartoonProperties.getCat().getName() : "tom");
            cat.setAge(cartoonProperties.getCat()!=null &&
                    cartoonProperties.getCat().getAge()!=null ?
                    cartoonProperties.getCat().getAge() : 3);
            mouse = new Mouse();
            mouse.setName(cartoonProperties.getMouse()!=null &&
                    StringUtils.hasText(cartoonProperties.getMouse().getName()) ?
                    cartoonProperties.getMouse().getName() : "jerry");
            mouse.setAge(cartoonProperties.getMouse()!=null &&
                    cartoonProperties.getMouse().getAge()!=null ?
                    cartoonProperties.getMouse().getAge() : 4);
    }

    public void play(){
        System.out.println(cat.getAge()+"岁的"+
                cat.getName()+"和"+mouse.getAge()
                +"岁的"+ mouse.getName()+"打起来了");
    }


}
