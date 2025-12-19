package com.webdownload.webdown.repository;

import org.springframework.stereotype.Repository;

import com.webdownload.webdown.model.UsuarioLog;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UsuarioLogRepository extends JpaRepository<UsuarioLog, Long> {
    
}
