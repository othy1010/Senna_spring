package com.senna.backend.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.senna.backend.dao.UserRepository;
import com.senna.backend.domain.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.notNullValue;

// import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
// import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
// import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import org.junit.runner.RunWith;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

// @WithMockUser(username = "senna", password = "12345")
// @RunWith(SpringRunner.class)
@WebMvcTest(UserServiceImpl.class)
public class UserServiceImplTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    UserRepository userRepository;

    @Test
    void getUsers() throws Exception {
        mvc.perform(get("/api/users").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        // .andExpect(jsonPath("$", hasSize(4)))
        // .andExpect(jsonPath("$[0].first_Name", is("othmane")));
        ;
    }

    @Test
    void saveUser() throws Exception {
        User userTest = new User();
        userTest.setFirstName("othmane");
        userTest.setLastName("elkarmy");
        userTest.setCIN("bh111111");
        userTest.setEmail("othmane@gmail.com");
        // userTest.setBirthday(LocalDateTime.now());
        userTest.setAddress("casa");
        userTest.setPassword("password");
        userTest.setRole("doctor");
        userTest.setIsActive(true);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(userTest);

        mvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    void findByUserId() throws Exception {
        mvc.perform(get("/api/users/userId/{userId}", 2).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void deleteUser() throws Exception {
        mvc.perform(delete("/api/users/userId/{userId}", 3))
                .andExpect(status().isOk());

    }
}