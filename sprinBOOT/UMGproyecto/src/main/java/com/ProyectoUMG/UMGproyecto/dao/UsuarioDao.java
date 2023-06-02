package com.ProyectoUMG.UMGproyecto.dao;

import com.ProyectoUMG.UMGproyecto.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuarios();

    void eliminar(long id);

    void registrar(Usuario usuario);

    boolean verificarCredenciales(Usuario usuario);
}
