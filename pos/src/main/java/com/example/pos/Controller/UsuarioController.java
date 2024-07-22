package com.example.pos.Controller;

import com.example.pos.Entity.Usuario;
import com.example.pos.IRepository.IUsuarioRepository;
import com.example.pos.IService.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/guardar")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {return usuarioService.guardarUsuario (usuario);}

    @PutMapping("/{id}")
    public void ActualizarUsuario(@RequestBody Usuario usuario, @PathVariable long id) { usuarioService.ActualizarUsuario(usuario, id);}

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable long id) { usuarioService.eliminarUsuario(id);}

    @GetMapping("")
    public List<Usuario> listarUsuarios(){return usuarioService.listarUsuarios();}

    @GetMapping("/{id}")
    public Optional<Usuario> listarIdUsuario(@PathVariable long id) {return usuarioService.listarIdUsuario(id);}

}
