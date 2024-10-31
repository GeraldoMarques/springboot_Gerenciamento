package com.exemplo.telefone.service;

import com.exemplo.telefone.model.Telefone;
import com.exemplo.telefone.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository telefoneRepository;

    public List<Telefone> listarTodos() {
        return telefoneRepository.findAll();
    }

    public Optional<Telefone> buscarPorId(int id) {
        return telefoneRepository.findById(id);
    }

    public Telefone salvar(Telefone telefone) {
        return telefoneRepository.save(telefone);
    }

    public void deletar(int id) {
        telefoneRepository.deleteById(id);
    }
}
