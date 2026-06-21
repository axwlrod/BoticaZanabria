package com.api.zanabria.boticazanabria.service;

import com.api.zanabria.boticazanabria.model.Usuario;
import com.api.zanabria.boticazanabria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicelmpl implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario buscarPorUsuario(String usuario) {
        return usuarioRepository.findByUsuario(usuario);
    }

    @Override
    public boolean iniciarSesion(String usuario, String contrasena) {
        Usuario user = usuarioRepository.findByUsuario(usuario);
        
        if (user != null && user.getActivo()) {
            return user.getContrasena().equals(contrasena);
        }
        
        return false;
    }
}