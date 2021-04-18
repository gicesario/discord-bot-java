package br.com.dextra.scoremodels.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document
public class RespostasClima {

	@Id
	@NonNull
	private String _id;

	private String q; // questao
	private String p; // pessoa respondeu
	private Integer d; // dia
	private Integer r; // responsta 0=nap; 1=sim





}
