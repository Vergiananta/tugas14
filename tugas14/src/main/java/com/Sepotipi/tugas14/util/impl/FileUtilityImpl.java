package com.Sepotipi.tugas14.util.impl;

import com.Sepotipi.tugas14.util.FileUtility;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUtilityImpl implements FileUtility {
    private final Path storageLocation = Paths.get("/home/melvian/Materi/week-9/tugas14/tugas14/images/Artist Photos/").toAbsolutePath().normalize();
    @Override
    public String store(MultipartFile file, String destination) throws IOException {
        Path target = storageLocation.resolve(destination);
        Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);
        return FilenameUtils.getName(destination);
    }

    @Override
    public Resource read(String fileName) {
        String exceptionMessage = String.format("File %s not found.", fileName);
        try{
            Path file = storageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(file.toUri());

            if (!resource.exists()) throw  new ResponseStatusException(HttpStatus.NOT_FOUND, exceptionMessage);

            return resource;
        } catch (MalformedURLException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exceptionMessage);
        }


    }
}
