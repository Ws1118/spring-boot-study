package com.example.boot.basic.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(SpringExtension.class)
class BookControllerTest {
//    mock对象
    @Resource
    private MockMvc mockMvc;

    //在所有测试?法执?之前进?mock对象初始化
//    @BeforeAll
//    static void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(new BookController()).build();
//    }

//    @BeforeEach
//    void setUp() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }

//    private static MockMvc mockMvc;
//
//    @BeforeAll
//    static void setUp(){
//        mockMvc = MockMvcBuilders.standaloneSetup(new BookController()).build();
//    }

    @Test
    void saveBook()  throws Exception {
        String book = "{\n" +
                "  \"id\": 12,\n" +
                "  \"author\": \"ws\",\n" +
                "  \"title\": \"JS\",\n" +
                "  \"content\": \"JavaScript\",\n" +
                "  \"readers\": [{" +
                "\"name\": \"aaa\"," + " \"age\": 31 }," +
                "{\"name\": \"bbb\",\"age\": 30}]\n" +
                "}";
            MvcResult result = mockMvc.perform(
                    MockMvcRequestBuilders
                            .request(HttpMethod.POST, "/api/v1/books/")
                            .contentType("application/json")
                            .content(book)
            )
                    //状态码为200
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("ws"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.data.readers[0].age").value(21))
                    .andDo(print())
                    .andReturn();
            result.getResponse().setCharacterEncoding("UTF-8");
            log.info(result.getResponse().getContentAsString());
        }
    }