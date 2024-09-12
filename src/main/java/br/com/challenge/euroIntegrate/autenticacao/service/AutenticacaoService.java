package br.com.challenge.euroIntegrate.autenticacao.service;

import br.com.challenge.euroIntegrate.administrador.repository.ColaboradorRhRepository;
import br.com.challenge.euroIntegrate.autenticacao.dto.LoginDTO;
import br.com.challenge.euroIntegrate.autenticacao.dto.TokenDTO;
import br.com.challenge.euroIntegrate.autenticacao.usuario.RoleName;
import br.com.challenge.euroIntegrate.autenticacao.usuario.UsuarioDetailsImpl;
import br.com.challenge.euroIntegrate.autenticacao.repository.UsuarioRepository;
import br.com.challenge.euroIntegrate.colaborador.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;

@Service
public class AutenticacaoService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private ColaboradorRhRepository colaboradorRhRepository;

    public TokenDTO autenticarUsuario(LoginDTO login){
        var usernamePasswordAutentication = new UsernamePasswordAuthenticationToken(login.email(), login.senha());
        var authentication = authenticationManager.authenticate(usernamePasswordAutentication);
        var usuarioDetails = (UsuarioDetailsImpl) authentication.getPrincipal();
        var papel = usuarioDetails.getAuthorities().stream()
                .findFirst()
                .map(GrantedAuthority::getAuthority)
                .orElseThrow(() -> new RuntimeException("Usuário não possui papel"));
        Long id = null;

        if(papel.equalsIgnoreCase(RoleName.ROLE_CUSTOMER.name())){
            id = colaboradorRepository.findIdByEmail(usuarioDetails.getUsername()).orElseThrow(
                    () -> new RuntimeException("Colaborador não encontrado!")
            );
        }
        if(papel.equalsIgnoreCase(RoleName.ROLE_ADMINISTRATOR.name())){
            id  = colaboradorRhRepository.findRhIdByEmail(usuarioDetails.getUsername()).orElseThrow(
                    () -> new RuntimeException("Colaborador rh não encontrado!")
            );
        }

        return new TokenDTO(tokenService.gerarToken(usuarioDetails), id, papel);

    }




}
