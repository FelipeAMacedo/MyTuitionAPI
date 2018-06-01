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

	@Query("select c from Conquista c where (c.id NOT IN :listaId AND c.dataAlteracao NOT IN :listaData) AND (c.disciplina = null OR c.disciplina IN (select ud.disciplina from UsuarioDisciplina ud Where ud.id.usuarioId = :email))")
	List<Conquista> buscarNovasAtualizacoes(@Param("listaId") List<Long> listaId,
			@Param("listaData") List<LocalDateTime> listaData, @Param("email") String email);

	
	@Query("select c from Conquista c where (c.id NOT IN :listaId OR c.dataAlteracao NOT IN :listaData)")
	List<Conquista> buscarNovasAtualizacoes(@Param("listaId") List<Long> listaId,
			@Param("listaData") List<LocalDateTime> listaData);
	
	@Query("select c from Conquista c where (c.disciplina = null OR c.disciplina IN (select ud.disciplina from UsuarioDisciplina ud Where ud.id.usuarioId = :email))")
	List<Conquista> buscarNovasAtualizacoes(@Param("email") String email);
	
	
	
	@Query("select c from Conquista c where c.id = :id AND c.dataAlteracao != :dataAlteracao")
	Conquista verificarAtualizacao(@Param("id") Long id, @Param("dataAlteracao") LocalDateTime dataAlteracao);
	
	@Query("select c from Conquista c where c.id NOT IN :listaId AND (c.disciplina = null OR c.disciplina IN (select ud.disciplina from UsuarioDisciplina ud Where ud.id.usuarioId = :email))")
	List<Conquista> buscarNovasConquistas(@Param("listaId") List<Long> listaId, @Param("email") String email);
}
