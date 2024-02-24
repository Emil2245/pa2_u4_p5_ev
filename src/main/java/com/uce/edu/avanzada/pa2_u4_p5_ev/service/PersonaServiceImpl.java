package com.uce.edu.avanzada.pa2_u4_p5_ev.service;

import com.uce.edu.avanzada.pa2_u4_p5_ev.repository.IPersonaRepository;
import com.uce.edu.avanzada.pa2_u4_p5_ev.repository.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService
{
    @Autowired
    private IPersonaRepository iPersonaRepository;
    @Override
    public void guardar(Persona persona) {
        this.iPersonaRepository.insertar(persona);
    }

    @Override
    public void actualizar(Persona persona) {
        this.iPersonaRepository.actualizar(persona);
    }

    @Override
    public Persona buscarPorCedula(String cedula) {
        return this.iPersonaRepository.consultarPorCedula(cedula);
    }

    @Override
    public List<Persona> buscarTodo() {
        return this.iPersonaRepository.consultarTodo();
    }

    @Override
    public void eliminarPorCedula(String cedula) {
        this.iPersonaRepository.eliminarPorCedula(cedula);
    }
}
