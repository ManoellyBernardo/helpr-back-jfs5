package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.Cliente;
import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.soulcodeacademy.helpr.domain.dto.ClienteDTO;
import org.soulcodeacademy.helpr.domain.dto.FuturoCandidatoDTO;
import org.soulcodeacademy.helpr.domain.enums.Setor;
import org.soulcodeacademy.helpr.services.FuturoCandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/futuros-candidatos")
public class FuturoCandidatoController {

    @Autowired
    private FuturoCandidatoService futuroCandidatoService;

    @GetMapping
    public List<FuturoCandidato> listarTodosFuturosCandidatos() {
        return futuroCandidatoService.listar();
    }

    @GetMapping("/{id}")
    public FuturoCandidato getFuturoCandidato(@PathVariable Integer id) {
        return this.futuroCandidatoService.getFunturoCandidato(id);
    }

    @GetMapping("/por-nome")
    public List<FuturoCandidato> buscarFuturosCandidatosPorNome(@RequestParam("nome") String nome) {
        return futuroCandidatoService.buscarCandidatosPorNome(nome);
    }

    @GetMapping("/por-email")
    public FuturoCandidato buscarFuturosCandidatosPorEmail(@RequestParam("email") String email) {
        return futuroCandidatoService.getFunturoCandidatoPorEmail(email);
    }

    @GetMapping("/por-setor")
    public List<FuturoCandidato> buscarFuturosCandidatosPorSetor(@RequestParam("setor") Setor setor) {
        return futuroCandidatoService.buscarCandidatosPorSetor(setor);
    }

    @PostMapping
    public FuturoCandidato salvarFuturoCandidato(@Valid @RequestBody FuturoCandidatoDTO dto) {
        return this.futuroCandidatoService.salvar(dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        this.futuroCandidatoService.deletar(id);
    }

}
