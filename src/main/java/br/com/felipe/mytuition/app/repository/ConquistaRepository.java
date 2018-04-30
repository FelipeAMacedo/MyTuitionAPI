package br.com.felipe.mytuition.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.felipe.mytuition.app.entity.Conquista;

@Repository
public interface ConquistaRepository extends JpaRepository<Conquista, Long> {

}
