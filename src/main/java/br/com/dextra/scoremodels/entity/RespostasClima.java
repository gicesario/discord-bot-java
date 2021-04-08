package br.com.dextra.scoremodels.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RespostasClima {

	@JsonIgnore
	private String guid;

	private String idMembro;
	private String guidPergunta;
	private String resposta;
	private LocalDate data;

	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getIdMembro() {
		return idMembro;
	}
	public void setIdMembro(String idMembro) {
		this.idMembro = idMembro;
	}
	public String getGuidPergunta() {
		return guidPergunta;
	}
	public void setGuidPergunta(String guidPergunta) {
		this.guidPergunta = guidPergunta;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "RespostasClima [idMembro=" + idMembro + ", guidPergunta=" + guidPergunta + ", resposta=" + resposta
				+ ", data=" + data + "]";
	}

}
