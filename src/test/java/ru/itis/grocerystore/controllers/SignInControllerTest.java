package ru.itis.grocerystore.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.grocerystore.dto.SignInDto;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@AutoConfigureWebMvc
@SpringBootTest
@Transactional
public class SignInControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPage_isOk() throws Exception{
        mockMvc.perform(get("/signIn")).andExpect(status().isOk());
    }

    @Test
    public void getPage_withAuth() throws Exception {
        mockMvc.perform(post("/signIn").param("login", "admin").param("password", "1234"))
                .andExpect(status().is3xxRedirection());
    }
}
