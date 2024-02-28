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
    //viaja el modelo en el respond
    @GetMapping("/buscarTodo")
    //http://localhost:8080/personas/buscarTodo
    public String buscarTodos(Model model) {
        List<Persona> lista = this.iPersonaService.buscarTodo();
        model.addAttribute("personas", lista);
        return "vistaListaPersonas";
    }

    @GetMapping("/buscarPorCedula/{cedulaPersona}")
    //http://localhost:8080/personas/buscarPorCedula/98347598
    public String buscarPorCedula(@PathVariable("cedulaPersona") String cedula, Model model) {
        Persona persona = this.iPersonaService.buscarPorCedula(cedula);
        model.addAttribute("persona", persona);
        return "vistaPersona";
    }

    @PutMapping("/actualizar/{cedulaPersona}")
    //viaja el modelo en el request
    public String actualizar(@PathVariable("cedulaPersona") String cedula, Persona actualizarPersona) {
        Persona aux = this.iPersonaService.buscarPorCedula(cedula);
        aux.setNombre(actualizarPersona.getNombre());
        aux.setApellido(actualizarPersona.getApellido());
        aux.setApellido(actualizarPersona.getApellido());
        aux.setCedula(actualizarPersona.getCedula());
        aux.setGenero(actualizarPersona.getGenero());
        this.iPersonaService.actualizar(aux);
        return "redirect:/personas/buscarTodo";
    }

    @PostMapping("/insertar")
    public String insertar(Persona insertarPersona) {
        this.iPersonaService.guardar(insertarPersona);
        return "redirect:/personas/buscarTodo";
    }

    @GetMapping("/nuevaPersona")
    public String mostrarNuevaPersona(Model model){
        model.addAttribute("persona", new Persona());
        return "vistaNuevaPersona";
    }
    @DeleteMapping("/borrar/{cedula}")
    public String borrar(@PathVariable("cedula") String cedula) {
        this.iPersonaService.eliminarPorCedula(cedula);
        return "redirect:/personas/buscarTodo";
    }



}

