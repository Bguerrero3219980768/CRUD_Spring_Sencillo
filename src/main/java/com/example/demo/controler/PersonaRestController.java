package com.example.demo.controler;

import com.example.demo.interfaceService.IPersonaService;
import com.example.demo.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PersonaRestController {

    @Autowired
    private IPersonaService service;

    @GetMapping("/all")
    public List<Persona> getAll(){
    return service.listar();
    }


    @PostMapping("/save")
    public Persona guardarUsuario(@RequestBody Persona usuario){
        service.save(usuario);
        return usuario;
    }

    @GetMapping( "/{id}")
    public Optional<Persona> obtenerUsuarioPorId(@PathVariable int id,  Model model) {
        Optional<Persona>persona=service.listarId(id);
        model.addAttribute("persona",persona);
        return persona;
    }


    @DeleteMapping( path = "/{id}")
    public String delete(Model model, @PathVariable int id){
        boolean ok;
        try{
            service.delete(id);
            ok = true;
        }catch(Exception err){
            ok = false;
        }

        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }

}
