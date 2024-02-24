package com.uce.edu.avanzada.pa2_u4_p5_ev.repository;

import com.uce.edu.avanzada.pa2_u4_p5_ev.repository.model.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
@Transactional
public class PersonaRepositoryImpl implements IPersonaRepository{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void insertar(Persona persona) {
        this.entityManager.persist(persona);
    }

    @Override
    public void actualizar(Persona persona) {
        this.entityManager.merge(persona);
    }

    @Override
    public Persona consultarPorCedula(String cedula) {
        return this.entityManager.createQuery("select p from Persona p where p.cedula=:cedula ", Persona.class)
                .setParameter("cedula",cedula)
                .getResultList().get(0);
    }

    @Override
    public List<Persona> consultarTodo() {
        return this.entityManager.createQuery("select p from Persona p", Persona.class)
                .getResultList();
    }

    @Override
    public void eliminarPorCedula(String cedula) {
        this.entityManager.createQuery("delete Persona f where f.cedula= :cedula")
                .setParameter("cedula", cedula)
                .executeUpdate();
    }

}
