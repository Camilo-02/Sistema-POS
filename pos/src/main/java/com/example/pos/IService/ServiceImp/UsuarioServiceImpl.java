package com.example.pos.IService.ServiceImp;

import com.example.pos.Entity.Usuario;
import com.example.pos.IRepository.IUsuarioRepository;
import com.example.pos.IService.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final IUsuarioRepository usuarioRepository;
    Usuario usuario = new Usuario();

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void ActualizarUsuario(Usuario usuario, long id) {

        Optional<Usuario> optional = usuarioRepository.findById(id);

        if (optional.isPresent()) {
            usuario.setId(usuario.getId());
            usuario.setNombre(usuario.getNombre());
            usuario.setEmail(usuario.getEmail());
            usuario.setContrasena(usuario.getContrasena());

            usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("Usuario no existente");
        }
    }

    @Override
    public void eliminarUsuario(long id) {
        usuarioRepository.delete(usuario);
    }

    @Override
    public Optional<Usuario> listarIdUsuario(long id) {
        return usuarioRepository.findById(id);
    }


    @Override
    public List<Usuario> listarUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll();
    }
}
