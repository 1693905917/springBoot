package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: com.itheima
 * @Author: ASUS
 * @CreateTime: 2023-07-17  09:06
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//开启虚拟MVC调用
@AutoConfigureMockMvc
public class WebTest {

    @Test
    void test(@Autowired MockMvc mvc) throws Exception {
        //http://localhost:8080/books
        //创建虚拟请求，当前访问/books
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.get("/books");
        //执行对应的请求
        ResultActions perform = mvc.perform(builder);
        //设定预期值  与真实值进行比较，成功测试通过，失败测试失败
        //定义本次调用的预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        //预计本次调用时成功的
        ResultMatcher result = content.string("springboot2");
        //添加预计值到本次调用过程中进行匹配
        perform.andExpect(result);
    }

    @Test
    void testJSON(@Autowired MockMvc mvc) throws Exception {
        //http://localhost:8080/books
        //创建虚拟请求，当前访问/books
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.get("/books");
        //执行对应的请求
        ResultActions perform = mvc.perform(builder);
        //设定预期值  与真实值进行比较，成功测试通过，失败测试失败
        //定义本次调用的预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        //预计本次调用时成功的
        ResultMatcher result = content.json(
                "{\"id\":1,\"name\":\"springboot\",\"type\":\"springboot\"," +
                        "\"description\":\"springboot\"}");
        //添加预计值到本次调用过程中进行匹配
        perform.andExpect(result);
    }
}
