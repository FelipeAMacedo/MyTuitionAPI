package br.com.felipe.mytuition.app.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.felipe.mytuition.app.entity.Conteudo;
import br.com.felipe.mytuition.app.entity.Materia;

@Repository
public interface ConteudoRepository extends JpaRepository<Materia, String> {

	@Query("SELECT c FROM Conteudo c WHERE c.materia.id = :id ORDER BY c.ordem")
	Set<Conteudo> findByMateriaId(@Param("id") Long id);

//	@Query("SELECT c FROM Conteudo c WHERER c.materia.id IN :ids")
//	Set<Conteudo> findQuestionsByMateriaId(@Param("ids") List<Long> ids);
	
	@Query("SELECT c FROM Conteudo c WHERE c.materia.id = :id AND size(c.alternativas) > 0")
	Set<Conteudo> findQuestionsByMateriaId(@Param("id") Long id);

}
