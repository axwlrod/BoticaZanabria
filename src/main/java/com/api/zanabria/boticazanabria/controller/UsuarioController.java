package com.api.zanabria.boticazanabria.controller;

import com.api.zanabria.boticazanabria.model.Usuario;
import com.api.zanabria.boticazanabria.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.zanabria.boticazanabria.dto.UsuarioResponseDTO;
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;
    @PostMapping("/login")
    public Object login(@RequestBody Usuario usuario) {
        boolean esValido = usuarioService.iniciarSesion(usuario.getUsuario(), usuario.getContrasena());

        if (esValido) {
            Usuario userDB = usuarioService.buscarPorUsuario(usuario.getUsuario());

            return new UsuarioResponseDTO(
                userDB.getIdUsuario(), 
                userDB.getUsuario(), 
                userDB.getActivo()
            );
        }
        return "Credenciales incorrectas"; 
    }  
}
