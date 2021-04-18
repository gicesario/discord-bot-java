package br.com.dextra.scoremodels.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document
public class Influenciadores {

	@Id
	@NonNull
	private String _id;

	private String p;
	private String i;
	private Integer d;


}
