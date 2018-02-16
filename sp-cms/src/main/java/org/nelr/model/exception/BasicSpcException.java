package org.nelr.model.exception;

import java.util.ArrayList;
import java.util.List;

public class BasicSpcException extends Exception{

	private List<String> listaMensajesError;
	
	public BasicSpcException(){
		
	}
	
	public BasicSpcException(String mensajeError){
		if(this.getListaMensajesError()==null){
			this.setListaMensajesError(new ArrayList<String>());
		}
		this.getListaMensajesError().add(mensajeError);
	}

	public List<String> getListaMensajesError() {
		return listaMensajesError;
	}

	public void setListaMensajesError(List<String> listaMensajesError) {
		this.listaMensajesError = listaMensajesError;
	}
		
}
