package com.solucao.hipatec.controller;

import com.solucao.hipatec.model.Mentora;
import com.solucao.hipatec.service.MentoraService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(originPatterns = {"http://localhost:*", "http://127.0.0.1:*", "http://192.168.*:*"})
@RestController
@RequestMapping("/mentoras")
public class MentoraController {

    private final MentoraService service;

    public MentoraController(MentoraService service) {
        this.service = service;
    }

    @GetMapping
    public List<Mentora> listar() {
        return service.listar();
    }

    @PostMapping
    public Mentora salvar(@RequestBody Mentora mentora) {
        return service.salvar(mentora);
    }

    // LOGIN
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