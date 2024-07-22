package com.example.pos.IService;

import com.example.pos.Entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Usuario guardarUsuario(Usuario usuario);
    void ActualizarUsuario(Usuario usuario, long id);
    void eliminarUsuario(long id);
    Optional<Usuario> listarIdUsuario(long id);
    List<Usuario> listarUsuarios();
}
