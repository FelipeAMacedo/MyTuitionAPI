package br.com.felipe.mytuition.app.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.felipe.mytuition.app.entity.Conquista;

@Repository
public interface ConquistaRepository extends JpaRepository<Conquista, Long> {
	
	@Query("select c from Conquista c where c.id NOT IN :listaId OR c.dataAlteracao NOT IN :listaData")
	List<Conquista> buscarNovasAtualizacoes(@Param("listaId") List<Long> listaId, @Param("listaData") List<LocalDateTime> listaData);

}
