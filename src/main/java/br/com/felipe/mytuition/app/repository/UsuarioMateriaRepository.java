package br.com.felipe.mytuition.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.felipe.mytuition.app.entity.UsuarioMateria;
import br.com.felipe.mytuition.app.entity.UsuarioMateriaId;

@Repository
public interface UsuarioMateriaRepository extends JpaRepository<UsuarioMateria, UsuarioMateriaId> {

}
