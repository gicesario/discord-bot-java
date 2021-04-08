package br.com.dextra.scoremodels.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("perguntasClima")
public class PerguntasClima {

	@JsonIgnore
	private String guid;

	private String pergunta;

	public PerguntasClima(String guid, String pergunta) {
		super();
		this.guid = guid;
		this.pergunta = pergunta;
	}

	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	@Override
	public String toString() {
		return "Pergunta: [guid=" + guid + ", pergunta=" + pergunta + "]";
	}

}
