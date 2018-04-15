package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN 'true' ELSE 'false' END FROM Usuario u WHERE u.email = :email")
	public Boolean existsByEmail(@Param("email") String username);

}
