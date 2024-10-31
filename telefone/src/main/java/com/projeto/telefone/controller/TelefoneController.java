package com.exemplo.telefone.controller;

import com.exemplo.telefone.model.Telefone;
import com.exemplo.telefone.service.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {

    @Autowired
    private TelefoneService telefoneService;

    @GetMapping
    public List<Telefone> listarTodos() {
        return telefoneService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Telefone> buscarPorId(@PathVariable int id) {
        return telefoneService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Telefone salvar(@RequestBody Telefone telefone) {
        return telefoneService.salvar(telefone);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        telefoneService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
