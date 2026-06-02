package com.solucao.hipatec.service;

import com.solucao.hipatec.model.Mentora;
import com.solucao.hipatec.repository.MentoraRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentoraService {

    private final MentoraRepository repository;

    public MentoraService(MentoraRepository repository) {
        this.repository = repository;
    }

    public List<Mentora> listar() {
        return repository.findAll();
    }

    public Mentora salvar(Mentora mentora) {
        return repository.save(mentora);
    }

    public Integer login(String email, String senha) {
        return repository.findByEmailAndSenha(email, senha)
                .map(Mentora::getId)
                .orElse(0);
    }
}