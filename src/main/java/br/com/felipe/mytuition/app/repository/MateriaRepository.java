package br.com.felipe.mytuition.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.felipe.mytuition.app.entity.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, String> {

	@Query("SELECT m FROM Materia m WHERE m.disciplina.id = :id")
	List<Materia> findByDisciplinaId(@Param("id") Long id);

}
