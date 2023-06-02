package com.ProyectoUMG.UMGproyecto.controles;

import com.ProyectoUMG.UMGproyecto.dao.UsuarioDao;
import com.ProyectoUMG.UMGproyecto.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class usuarioControl {
    @Autowired
    private UsuarioDao usuarioDao;
    //para primer usuario
    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Francisco");
        usuario.setApellido("Sutuj");
        usuario.setEmail("fran@gmail.com");
        usuario.setTelefono("59044319");
        return usuario;
    }
    @RequestMapping(value = "usuarios",method = RequestMethod.GET)
    public List<Usuario> getUsuarios(){
     return usuarioDao.getUsuarios();
    }
    @RequestMapping(value = "usuarios",method = RequestMethod.POST)
    public void registrarUsuarios(@RequestBody Usuario usuario){usuario.getPassword();

        usuarioDao.registrar(usuario);
    }
    //para editar usuario
    @RequestMapping(value = "usuario1234")
    public Usuario editar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Francisco");
        usuario.setApellido("Sutuj");
        usuario.setEmail("fran@gmail.com");
        usuario.setTelefono("59044319");
        return usuario;
    }
    //para eliminar un usuario
    @RequestMapping(value = "usuarios/{id}",method = RequestMethod.DELETE)
    public void eliminar(@PathVariable long id){
        usuarioDao.eliminar(id);
    }
    //para buscar un usuario
    @RequestMapping(value = "usuario12")
    public Usuario buscar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Francisco");
        usuario.setApellido("Sutuj");
        usuario.setEmail("fran@gmail.com");
        usuario.setTelefono("59044319");
        return usuario;
    }
}
