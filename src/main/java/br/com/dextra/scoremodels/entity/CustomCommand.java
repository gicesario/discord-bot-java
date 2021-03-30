package br.com.dextra.scoremodels.entity;


public class CustomCommand {
	
}

/*

@Document
public class CustomCommand {

	@Id
	@NonNull
	private String id;

	@NonNull
	@Indexed(unique = true)
    private String comando;

	@NonNull
    private String argumentos;


	public String getId() {
		return id;
	}

	public String getComando() {
		return comando;
	}

	public String getArgumentos() {
		return argumentos;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setComando(String comando) {
		this.comando = comando;
	}

	public void setArgumentos(String argumentos) {
		this.argumentos = argumentos;
	}

	@Override
	public String toString() {
		return "Comando [" + comando + ", argumentos=" + argumentos + "]";
	}
}*/
