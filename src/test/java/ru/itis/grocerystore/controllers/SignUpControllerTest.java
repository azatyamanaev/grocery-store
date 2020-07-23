package ru.itis.grocerystore.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.itis.grocerystore.repositories.UsersRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@AutoConfigureWebMvc
@SpringBootTest
public class SignUpControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPage_isOk() throws Exception {
        mockMvc.perform(get("/signUp")).andExpect(status().isOk());
    }


    @Test
    public void signUp_old() throws Exception {
        mockMvc.perform(post("/signUp").param("login", "admin")
                .param("email", "test")
                .param("password", "1234")
                .param("role", "STUDENT"))
                .andExpect(status().isOk());
    }

    @Test
    public void signUp_confirm_good() throws Exception{
        mockMvc.perform(get("/confirm/f181f79c-771b-4eb5-8024-c01ccefe54d4"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void signUp_confirm_bad() throws Exception{
        mockMvc.perform(get("/confirm/123"))
                .andExpect(status().isOk());
    }

    @Test
    public void signUp_rest_bad() throws Exception {
        mockMvc.perform(post("/rest/signUp").param("login", "tester")
                .param("email", "test")
                .param("password", "1234")
                .param("role", "STUDENT")).andExpect(status().isBadRequest());
    }
}
