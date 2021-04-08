package br.com.dextra.scoremodels.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PerguntasCafe {

	@JsonIgnore
	private String guid;

	private String idMembro;
	private String pergunta;
	private LocalDate data;
	private boolean debatida;

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
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public boolean getDebatida() {
		return debatida;
	}
	public void setDebatida(boolean debatida) {
		this.debatida = debatida;
	}
	@Override
	public String toString() {
		return "Perguntas Cafe: [guid=" + guid + ", idMembro=" + idMembro + ", pergunta=" + pergunta + ", data=" + data
				+ ", debatida=" + debatida + "]";
	}

}
