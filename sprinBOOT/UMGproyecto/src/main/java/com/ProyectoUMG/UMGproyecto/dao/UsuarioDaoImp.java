package com.ProyectoUMG.UMGproyecto.dao;

import com.ProyectoUMG.UMGproyecto.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional

public class UsuarioDaoImp implements UsuarioDao{
    @PersistenceContext
     EntityManager entityManager;

    @Override
    public List<Usuario> getUsuarios() {

        String query="FROM Usuario";
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void eliminar(long id) {
        Usuario usuario = entityManager.find(Usuario.class,id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }
    @Override
    public boolean verificarCredenciales(Usuario usuario) {
        String query="FROM Usuario WHERE email=:email and password=:password";
        List<Usuario> lista=entityManager.createQuery(query)
                .setParameter("email",usuario.getEmail())
                .setParameter("password",usuario.getPassword())
                .getResultList();
        return !lista.isEmpty();
    }

}
