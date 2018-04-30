package br.com.felipe.mytuition.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.felipe.mytuition.app.entity.UsuarioConquista;
import br.com.felipe.mytuition.app.entity.UsuarioConquistaId;

@Repository
public interface UsuarioConquistaRepository extends JpaRepository<UsuarioConquista, UsuarioConquistaId> {

}
