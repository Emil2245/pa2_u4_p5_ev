package com.uce.edu.avanzada.pa2_u4_p5_ev.controller;

import com.uce.edu.avanzada.pa2_u4_p5_ev.repository.model.Persona;
import com.uce.edu.avanzada.pa2_u4_p5_ev.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/personas")
//https://localhost/personas/buscar
//https://localhost/personas/actualizar
public class PersonaController {
    @Autowired
    private IPersonaService iPersonaService;

    /*
    Diferentes tipos de request
    GET: consultar recursos
    POST: crear uno a varios recursos
    PUT: actualizar uno o varios recursos
    DELETE: eliminar uno o varios recursos
    PATCH: Sirve para actualizar de manera parcial uno o varios recursos
     */

    //parte del path
    @GetMapping("/buscar-todo")
    public String buscarTodos(Model model){
        List<Persona> lista = this.iPersonaService.buscarTodo();
        model.addAttribute("personas",lista);
        return "vistaListaPersonas";
    }
    @GetMapping("/buscar")
    public String buscarPorCedual(String cedula){
        return "";
    }
    @PutMapping("/actualizar")
    public String actualizar(){
        return "";
    }
    @DeleteMapping("/borrar")
    public String borrar(){
        return "";
    }
    @PostMapping("/guardar")
    public String guardar(){
        return "";
    }


}

