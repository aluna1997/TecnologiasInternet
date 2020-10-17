package com.restfulwebservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.restfulwebservices.repository.UsuarioRepository;
import java.util.List;
import com.restfulwebservices.model.Usuario;

@Service
public class UsuarioServiceImp implements UsuarioService{
	
	@Autowired
	private UsuarioRepository repoUsuario; 
	
	@Override
	public List<Usuario> getUsuarios(){
		return repoUsuario.findAll();
	}
	
	public ResponseEntity<Object> getUsuario(int id){
		return new ResponseEntity<>(repoUsuario.findById(id), HttpStatus.OK);
	}
	
	public ResponseEntity<Object> createUsuario(Usuario usuario){
		return new ResponseEntity<>(repoUsuario.save(usuario), HttpStatus.OK);
	}
	
	public void updateUsuario(int id, Usuario usuario) {
		repoUsuario.save(usuario);
	}
	
	public void deleteUsuario(int id) {
		repoUsuario.deleteById(id);
	}
	
}
