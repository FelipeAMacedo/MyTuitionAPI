package br.com.felipe.mytuition.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.felipe.mytuition.app.entity.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

	@Query("SELECT d FROM Disciplina d LEFT JOIN d.usuarioDisciplina ud ON (d.id = ud.disciplina.id AND ud.usuario.email = :email)")
	List<Disciplina> findAll(@Param("email") String email);
	
}
