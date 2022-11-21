package com.example.demo.interfaceService;

import com.example.demo.modelo.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {
    public List<Persona>listar();
    public Optional<Persona>listarId(int id);
    public int save(Persona p);
    public void delete(int id);
}
