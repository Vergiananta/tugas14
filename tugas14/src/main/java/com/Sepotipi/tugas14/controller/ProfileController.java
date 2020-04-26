package com.Sepotipi.tugas14.controller;


import com.Sepotipi.tugas14.entity.Profile;
import com.Sepotipi.tugas14.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @PostMapping("/sign-up")
    public void saveProfile(@RequestBody Profile profile){
        profileService.saveProfile(profile);
    }

    @GetMapping("/{idProfile}")
    public Profile getProfileById(@PathVariable(name = "idProfile") String id){
        return profileService.getProfile(id);
    }

    @GetMapping
    public Page<Profile> getAllProfile(@RequestParam(name = "page") Integer page,@RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return profileService.getAllProfile(pageable);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        profileService.deleteProfile(id);
    }
}
