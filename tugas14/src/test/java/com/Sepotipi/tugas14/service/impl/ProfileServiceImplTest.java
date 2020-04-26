package com.Sepotipi.tugas14.service.impl;

import com.Sepotipi.tugas14.entity.Profile;
import com.Sepotipi.tugas14.enums.GenderEnum;
import com.Sepotipi.tugas14.exception.ResourceNotFoundException;
import com.Sepotipi.tugas14.repository.ProfileRepository;
import com.Sepotipi.tugas14.service.ProfileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class ProfileServiceImplTest {

    @MockBean
    ProfileRepository profileRepository;

    @Autowired
    ProfileService profileService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void saveProfile_ShouldCreate_1_profile_in_DB_when_an_Profile_saved() {
        ObjectMapper objectMapper = new ObjectMapper();
        Profile profile = new Profile();
        profile.setFirstName("budi");
        profile.setMiddleName("setiawan");
        profile.setLastName("gunawan");
        profile.setBirthDate(new Date());
        profile.setEmail("budi@gmail.com");
        profile.setGender(GenderEnum.MALE);
        profile.setLocation("Jakarta");

        profileService.saveProfile(profile);
        List<Profile> profiles = new ArrayList<>();
        profiles.add(profile);

        when(profileRepository.findAll()).thenReturn(profiles);
        assertEquals(1, profileRepository.findAll().size());
    }

    @Test
    void getProfile() {
        Profile profile = new Profile();
        profile.setFirstName("budi");
        profile.setMiddleName("setiawan");
        profile.setLastName("gunawan");
        profile.setBirthDate(new Date());
        profile.setEmail("budi@gmail.com");
        profile.setGender(GenderEnum.MALE);
        profile.setLocation("Jakarta");

        profileRepository.save(profile);

        when(profileRepository.findById(profile.getId())).thenReturn(Optional.of(profile));
    }

    @Test
    void getProfile_shouldThrowException_when_givenIdNotExist() {
        assertThrows(ResourceNotFoundException.class, ()->{
            profileService.getProfile("asal");
        });
    }

    @Test
    void deleteProfile_Byid_will_be_empty_when_deleted() {
        profileRepository.deleteById("assal");
        assertEquals(0, profileRepository.findAll().size());
    }
}