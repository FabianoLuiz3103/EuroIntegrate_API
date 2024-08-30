package br.com.challenge.euroIntegrate.autenticacao.repository;

import br.com.challenge.euroIntegrate.autenticacao.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
}
