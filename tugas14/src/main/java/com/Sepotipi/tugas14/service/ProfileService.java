package com.Sepotipi.tugas14.service;

import com.Sepotipi.tugas14.entity.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProfileService {
    public Profile saveProfile(Profile profile);
    public Profile getProfile(String id);
    public Page<Profile> getAllProfile(Pageable pageable);
    public void deleteProfile(String id);
}
