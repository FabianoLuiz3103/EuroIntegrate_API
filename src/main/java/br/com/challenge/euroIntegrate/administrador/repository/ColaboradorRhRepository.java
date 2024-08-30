package br.com.challenge.euroIntegrate.administrador.repository;

import br.com.challenge.euroIntegrate.administrador.model.ColaboradorRh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ColaboradorRhRepository extends JpaRepository<ColaboradorRh, Long> {
    Optional<ColaboradorRh> findByEmailRh(String email);

    @Query("SELECT cr.id FROM ColaboradorRh cr WHERE cr.emailRh = :email")
    Optional<Long> findRhIdByEmail(@Param("email") String email);
}
