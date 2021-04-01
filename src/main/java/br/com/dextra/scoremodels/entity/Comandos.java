package br.com.dextra.scoremodels.entity;



public class Comandos {

	private String id;
    private String comando;

	public String getId() {
		return id;
	}

	public String getComando() {
		return comando;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setComando(String comando) {
		this.comando = comando;
	}

	@Override
	public String toString() {
		return "Comando: [comando=" + comando + "]";
	}

}
