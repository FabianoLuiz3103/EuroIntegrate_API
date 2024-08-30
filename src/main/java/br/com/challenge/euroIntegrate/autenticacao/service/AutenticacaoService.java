package br.com.challenge.euroIntegrate.autenticacao.service;

import br.com.challenge.euroIntegrate.autenticacao.dto.LoginDTO;
import br.com.challenge.euroIntegrate.autenticacao.dto.TokenDTO;
import br.com.challenge.euroIntegrate.autenticacao.usuario.UsuarioDetailsImpl;
import br.com.challenge.euroIntegrate.autenticacao.repository.UsuarioRepository;
import br.com.challenge.euroIntegrate.colaborador.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public TokenDTO autenticarUsuario(LoginDTO login){
        var usernamePasswordAutentication = new UsernamePasswordAuthenticationToken(login.email(), login.senha());
        var authentication = authenticationManager.authenticate(usernamePasswordAutentication);
        var usuarioDetails = (UsuarioDetailsImpl) authentication.getPrincipal();
        return new TokenDTO(tokenService.gerarToken(usuarioDetails));

    }

}
