package br.com.felipe.mytuition.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.felipe.mytuition.app.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN 'true' ELSE 'false' END FROM Usuario u WHERE u.email = :email")
	Boolean existsByEmail(@Param("email") String username);

	@Query("SELECT u from Usuario u WHERE u.email = :email AND u.senha = :senha")
	Usuario login(@Param("email") String email, @Param("senha") String senha);

}
