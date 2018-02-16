package org.nelr.model.web;

public class MensajeErrorDTO {

	public String idCampo;
	public String etiqueta;
	
	public MensajeErrorDTO(){
		
	}
	
	public MensajeErrorDTO(String idCampo, String etiqueta){
		this.idCampo = idCampo;
		this.etiqueta = etiqueta;
	}
	
	public String getIdCampo() {
		return idCampo;
	}
	public void setIdCampo(String idCampo) {
		this.idCampo = idCampo;
	}
	public String getEtiqueta() {
		return etiqueta;
	}
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

}
