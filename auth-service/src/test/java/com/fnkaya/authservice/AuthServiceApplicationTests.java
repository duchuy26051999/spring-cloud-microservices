package com.fnkaya.authservice;

import com.fnkaya.authservice.service.domain.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AuthServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception {
        Account account = Account.builder().id(1L).email("test1@gmail.com").password("123456").build();
        ObjectMapper objMapper = new ObjectMapper();
        mockMvc.perform(get("/api/v1/account/1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(objMapper.writeValueAsString(account)));
    }

}
