package br.com.felipe.mytuition.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.felipe.mytuition.app.entity.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, String> {


}
