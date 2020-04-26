package com.Sepotipi.tugas14.controller;

import com.Sepotipi.tugas14.entity.Profile;
import com.Sepotipi.tugas14.enums.GenderEnum;
import com.Sepotipi.tugas14.service.ProfileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProfileControllerTest {

    @MockBean
    ProfileService profileService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void saveProfile_should_response_OK200() throws  Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        Profile profile = new Profile();
        profile.setFirstName("budi");
        profile.setMiddleName("setiawan");
        profile.setLastName("gunawan");
        profile.setBirthDate(new Date());
        profile.setEmail("budi@gmail.com");
        profile.setGender(GenderEnum.MALE);
        profile.setLocation("Jakarta");


        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/profile/sign-up")
                .contentType(MediaType.APPLICATION_JSON)
                 .content(objectMapper.writeValueAsString(profile));

        mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getProfileById() {
    }

    @Test
    void getAllProfile() {
    }

    @Test
    void deleteById() {
    }
}