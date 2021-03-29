package br.com.dextra.scoremodels.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.dextra.scoremodels.entity.CustomCommand;


@Repository
public interface CommandRepository extends MongoRepository<CustomCommand, String> {

	@Query("{'comando' : ?}")
	Optional<CommandRepository> buscaApoliceByNumero(String comando);
	
	public Optional<List<CustomCommand>> buscaComandos (String identifier);
	
}
