package com.webdownload.webdown.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webdownload.webdown.model.ChaveAcesso;

@Repository
public interface ChaveRepository extends JpaRepository<ChaveAcesso, String> {
    Optional<ChaveAcesso> findByChaveAndUtilizavel(String chave, boolean utilizavel);
}
