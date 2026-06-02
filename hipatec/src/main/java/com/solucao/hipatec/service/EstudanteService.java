package com.solucao.hipatec.service;

import com.solucao.hipatec.model.Estudante;
import com.solucao.hipatec.repository.EstudanteRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudanteService {

    private final EstudanteRepository repository;

    public EstudanteService(EstudanteRepository repository) {
        this.repository = repository;
    }

    public List<Estudante> listar() {
        return repository.findAll();
    }

    public Estudante salvar(Estudante estudante) {
        return repository.save(estudante);
    }
    public Integer login(String email, String senha) {
        return repository.findByEmailAndSenha(email, senha)
                .map(Estudante::getId)
                .orElse(0);
    }
}