package com.Sepotipi.tugas14.repository;

import com.Sepotipi.tugas14.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, String>, JpaSpecificationExecutor<Song> {

    public Page<Song> findAllByTitleContains(String title, Pageable pageable);
}
