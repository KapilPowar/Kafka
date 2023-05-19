package com.kapil.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kapil.springboot.entity.Wikimedia;

public interface WikimediaDataRepository extends JpaRepository<Wikimedia, Long> {
    
}
