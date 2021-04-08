package br.com.dextra.scoremodels.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Influenciadores {

	@JsonIgnore
	private String guid;
	private String idAdmirador;
	private String idInfluenciador;
	private Integer anoMes;

	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getIdAdmirador() {
		return idAdmirador;
	}
	public void setIdAdmirador(String idAdmirador) {
		this.idAdmirador = idAdmirador;
	}
	public String getIdInfluenciador() {
		return idInfluenciador;
	}
	public void setIdInfluenciador(String idInfluenciador) {
		this.idInfluenciador = idInfluenciador;
	}
	public Integer getAnoMes() {
		return anoMes;
	}
	public void setAnoMes(Integer anoMes) {
		this.anoMes = anoMes;
	}
	@Override
	public String toString() {
		return "Influenciadores [idAdmirador=" + idAdmirador + ", idInfluenciador=" + idInfluenciador + ", anoMes="
				+ anoMes + "]";
	}

}
