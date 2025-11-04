package com.example.veterinaria.controller;

import com.example.veterinaria.model.Persona;
import com.example.veterinaria.service.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/persona")
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController (PersonaService personaService){
        this.personaService = personaService;
    }

    @GetMapping
    public List<Persona> obtenerPersona(){
        return personaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> obtenerMascotaPorId(@PathVariable Integer id){
        return personaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?>
    crearMascota(@RequestBody Persona persona){
        if(persona.getNombres() == null || persona.getNombres().trim().isEmpty()){
            return ResponseEntity.badRequest().body("El campo es obligatorio");
        }
        if(persona.getApellidos() == null || persona.getApellidos().trim().isEmpty()){
            return ResponseEntity.badRequest().body("El campo es obligatorio");
        }
        if(persona.getDni() == null){
            return ResponseEntity.badRequest().body("El campo es obligatorio");
        }
        if(persona.getEmail() == null || persona.getEmail().trim().isEmpty()){
            return ResponseEntity.badRequest().body("El campo es obligatorio");
        }
        if(persona.getTelefono() == null){
            return ResponseEntity.badRequest().body("El campo es obligatorio");
        }
        return ResponseEntity.ok(personaService.crearPersona(persona));
    }
}
