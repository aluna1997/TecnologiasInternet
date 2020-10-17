package com.restfulwebservices.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_usuario;
	@Size(min = 3, message = "El nobre del usuario debe tener al menos 3 letras")
	private String usuario;
	@Size(min = 5, message = "La contraseña debe tener al menos longitud 5")
	private String password;
	private Integer tipo_usuario;
	
	public Usuario() {
		
	}

	public Usuario(Integer id_usuario,
			@Size(min = 3, message = "El nobre del usuario debe tener al menos 3 letras") String usuario,
			@Size(min = 5, message = "La contraseña debe tener al menos longitud 5") String password,
			Integer tipo_usuario) {
		super();
		this.id_usuario = id_usuario;
		this.usuario = usuario;
		this.password = password;
		this.tipo_usuario = tipo_usuario;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(Integer tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", usuario=" + usuario + ", password=" + password
				+ ", tipo_usuario=" + tipo_usuario + "]";
	}
	
	
	
}
