package com.Sepotipi.tugas14.repository;

import com.Sepotipi.tugas14.entity.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, String>, JpaSpecificationExecutor<Album> {

    public Page<Album> findAllByTitleContainsAndDescriptionContains(String title, String desc, Pageable pageable);
}
