package com.solucao.hipatec.controller;

import com.solucao.hipatec.model.Mentoria;
import com.solucao.hipatec.service.MentoriaService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(originPatterns = {"http://localhost:*", "http://127.0.0.1:*", "http://192.168.*:*"})
@RestController
@RequestMapping("/mentorias")
public class MentoriaController {

    private final MentoriaService service;

    public MentoriaController(MentoriaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Mentoria> listar() {
        return service.listar();
    }

    @PostMapping
    public Mentoria salvar(@RequestBody Mentoria mentoria) {
        return service.salvar(mentoria);
    }
}