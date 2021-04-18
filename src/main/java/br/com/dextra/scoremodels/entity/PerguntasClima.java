package br.com.dextra.scoremodels.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document
public class PerguntasClima {

	@Id
	@NonNull
	private String _id;

	private String n; // numero da pergunta
	private String p; // pergunta


}
