package com.Sepotipi.tugas14.service.impl;

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
        Profile profile = profileRepository.findById(id).get();
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
