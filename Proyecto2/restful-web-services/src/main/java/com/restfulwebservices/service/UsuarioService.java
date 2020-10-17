package com.restfulwebservices.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.restfulwebservices.model.*;

public interface UsuarioService {
	public abstract List<Usuario> getUsuarios();
	public abstract ResponseEntity<Object> getUsuario(int id);
	public abstract ResponseEntity<Object> createUsuario(Usuario usuario);
	public abstract void updateUsuario(int id, Usuario usuario);
	public abstract void deleteUsuario(int id);
}
