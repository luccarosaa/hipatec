package com.solucao.hipatec.controller;

import com.solucao.hipatec.model.Estudante;
import com.solucao.hipatec.service.EstudanteService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(originPatterns = {"http://localhost:*", "http://127.0.0.1:*", "http://192.168.*:*"})
@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    private final EstudanteService service;

    public EstudanteController(
            EstudanteService service
    ) {
        this.service = service;
    }

    // LISTAR ESTUDANTES
    @GetMapping
    public List<Estudante> listar() {
        return service.listar();
    }

    // SALVAR ESTUDANTE
    @PostMapping
    public Estudante salvar(@RequestBody Estudante estudante) {
        return service.salvar(estudante);
    }

    @PostMapping("/login")
    public Map<String, Object> login(
            @RequestParam String email,
            @RequestParam String senha
    ) {
        Integer userId = service.login(email, senha);
        boolean authenticated = userId != null && userId > 0;

        return Map.of(
                "authenticated", authenticated,
                "userId", userId,
                "message", authenticated ? "Login realizado com sucesso." : "Email ou senha inválidos."
        );
    }
}