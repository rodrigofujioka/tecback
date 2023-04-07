package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.dto.UsuarioDTO;
import br.com.fujideia.iesp.tecback.model.Usuario;
import br.com.fujideia.iesp.tecback.repository.UsuarioRepository;
import br.com.fujideia.iesp.tecback.util.UtilidadesDesenvolvimento;
import jakarta.el.MethodNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioDTO salvar(UsuarioDTO user) throws Exception {

        Usuario usuario = new Usuario();
        String senha = criptografarSenha(user.getSenha());

        if (StringUtils.isNotBlank(senha)){
            usuario.setSenha(senha);
        }
        usuario.setNomeCompleto(user.getNomeCompleto());
        usuario.setEmail(user.getEmail());
        usuario.setCpf(user.getCpf());
        usuario.setCodSeguranca(user.getCodSeguranca());
        usuario.setDataNasc(user.getDataNasc());
        usuario.setTitularNome(user.getTitularNome());
        usuario.setNumCartao(user.getNumCartao());
        usuario.setValidadeCartao(user.getValidadeCartao());

        if(user.getCpf().length() == 14){
            String cpfFormatado = UtilidadesDesenvolvimento
                    .retiraCpf(user.getCpf());
            usuario.setCpf(cpfFormatado);
        }else{
            usuario.setCpf(user.getCpf());
        }
        repository.save(usuario);
        return user;
    }
    public void alterar(UsuarioDTO user, Long id) throws Exception {

        Optional<Usuario> op = repository.findById(id);
        String senha = criptografarSenha(user.getSenha());

        if(!op.isEmpty()){

            Usuario usuario = op.get();
            usuario.setNomeCompleto(user.getNomeCompleto());
            usuario.setEmail(user.getEmail());
            usuario.setCpf(user.getCpf());
            usuario.setCodSeguranca(user.getCodSeguranca());
            usuario.setDataNasc(user.getDataNasc());
            usuario.setTitularNome(user.getTitularNome());
            usuario.setNumCartao(user.getNumCartao());

            usuario.setValidadeCartao(user.getValidadeCartao());
            usuario.setSenha(senha);

            if(user.getCpf().length() == 14){
                String cpfFormatado = UtilidadesDesenvolvimento
                        .retiraCpf(user.getCpf());
                usuario.setCpf(cpfFormatado);
            }else{
                usuario.setCpf(user.getCpf());
            }
            repository.save(usuario);

        }else{
            throw new MethodNotFoundException();
        }

    }
    public List<Usuario> listar() {
        return repository.findAll();
    }
    public Boolean excluir(Long id){

        try {
            Optional<Usuario> op = repository.findById(id);
            if(!op.isEmpty()){
                repository.deleteById(id);
            }
        }catch (Exception e){
            log.info("Erro ao realizar exclusao", e.getMessage());
            return false;
        }
        return true;
    }
    public Usuario consultarPorId(Long id) throws ChangeSetPersister.NotFoundException {
        return repository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public String criptografarSenha(String senha){

        String senhaCriptografada = BCrypt.hashpw(senha, BCrypt.gensalt());
        return senhaCriptografada;

    }
}
