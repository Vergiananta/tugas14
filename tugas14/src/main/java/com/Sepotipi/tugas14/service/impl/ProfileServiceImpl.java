package com.Sepotipi.tugas14.service.impl;

import com.Sepotipi.tugas14.entity.Account;
import com.Sepotipi.tugas14.entity.Profile;
import com.Sepotipi.tugas14.exception.ResourceNotFoundException;
import com.Sepotipi.tugas14.repository.ProfileRepository;
import com.Sepotipi.tugas14.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    @Override
    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile getProfile(String id) {
        Profile profile;
        if( profileRepository.findById(id).isPresent()) {
          profile = profileRepository.findById(id).get();
        }  else throw new ResourceNotFoundException(id, Profile.class);
        return profile;
    }

    @Override
    public Page<Profile> getAllProfile(Pageable pageable) {
        Page<Profile> profiles = profileRepository.findAll(pageable);
        return profiles;
    }

    @Override
    public void deleteProfile(String id) {
        profileRepository.deleteById(id);
    }
}
