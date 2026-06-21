
package com.api.zanabria.boticazanabria.service;

import com.api.zanabria.boticazanabria.model.Usuario;

public interface IUsuarioService {
    Usuario buscarPorUsuario(String usuario); 
    boolean iniciarSesion(String usuario, String contrasena);
}
