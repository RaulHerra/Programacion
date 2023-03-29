package com.mockExam.model;

import java.util.Objects;

public class Usuario {

	private String login;
	private String pass;
	
	
	public Usuario(String login, String pass) {
		super();
		this.login = login;
		this.pass = pass;
	}

	public String getLogin() {
		return login;
	}
	
	public boolean setPass(String vieja, String nueva) {
		boolean cambiada=false;
		
		if(this.pass.equals(vieja)) {
			this.pass=nueva;
			cambiada = true;
		}
		return cambiada;
	}
	
	public boolean checkPass(String pass) {
		return this.pass.equals(pass);
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(login);
	}


	@Override
	public boolean equals(Object obj) {
		boolean sonIguales = this==obj;
		
		if(!sonIguales && obj != null && obj instanceof Usuario) {
			Usuario casteado = (Usuario)obj;
			
			sonIguales = casteado.login.equals(this.login);
		}
		return sonIguales;
	}
}
