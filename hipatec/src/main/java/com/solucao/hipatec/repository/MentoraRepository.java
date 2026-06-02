package com.solucao.hipatec.repository;

import com.solucao.hipatec.model.Mentora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MentoraRepository extends JpaRepository<Mentora, Integer> {
    Optional<Mentora> findByEmailAndSenha(String email, String senha);

}