package br.com.felipe.mytuition.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.felipe.mytuition.app.entity.Heroi;
import br.com.felipe.mytuition.app.entity.Usuario;

@Repository
public interface HeroiRepository extends JpaRepository<Heroi, Long> {

}
