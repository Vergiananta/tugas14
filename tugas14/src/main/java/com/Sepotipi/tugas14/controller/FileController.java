package com.Sepotipi.tugas14.controller;

import com.Sepotipi.tugas14.entity.Artist;
import com.Sepotipi.tugas14.service.ArtistService;
import com.Sepotipi.tugas14.util.FileUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class FileController {

    @Autowired
    FileUtility fileUtil;

    @Autowired
    ServletContext servletContext;

    @Autowired
    ArtistService artistService;


    @GetMapping("/artist/photo/{id}")
    public ResponseEntity<Resource> getArtistPhoto(@PathVariable String id, HttpServletResponse request){
        Artist artist = artistService.getArtistById(id);

        if (artist == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "File Not Found.");

        Resource resource = fileUtil.read(artist.getPhoto());

        String contentType = null;

        try {
            contentType = servletContext.getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "File Not Found");
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
