package com.lin.cloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.lin.cloud.HelloApplication;
import com.lin.cloud.config.MyProps;
import com.lin.cloud.config.Sender;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Created by Administrator on 2017-7-29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HelloApplication.class)
@WebAppConfiguration
public class HelloApplicationTests {
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception{
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void hello() throws Exception {
        ResultActions perform = mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().string(equalTo("Hello World")));
    }

    @Autowired
    private MyProps myProps;

    @Test
    public void propsTest() throws JsonProcessingException {
        System.out.println("simpleProp: " + myProps.getSimpleProp());
        System.out.println("arrayProps: " + JSONObject.toJSONString(myProps.getArrayProps()));
        System.out.println("listProp1: " +  JSONObject.toJSONString(myProps.getListProp1()));
        System.out.println("listProp2: " +  JSONObject.toJSONString(myProps.getListProp2()));
        System.out.println("mapProps: " +  JSONObject.toJSONString(myProps.getMapProps()));
    }

    @Autowired
    private Sender sender;
    @Test
    public void hello2() throws Exception {
        sender.send();
    }
}
