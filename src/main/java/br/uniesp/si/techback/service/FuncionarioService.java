package br.uniesp.si.techback.service;

import br.uniesp.si.techback.client.ViaCepClient;
import br.uniesp.si.techback.dto.ViaCepResponseDTO;
import br.uniesp.si.techback.model.Funcionario;
import br.uniesp.si.techback.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final ViaCepClient viaCepClient;

    public Funcionario incluir(Funcionario funcionario) {
        if (funcionario.getCep() != null && !funcionario.getCep().isBlank()) {
            String cepLimpo = funcionario.getCep().replaceAll("\\D", "");
            ViaCepResponseDTO endereco = viaCepClient.buscarPorCep(cepLimpo);

            funcionario.setCep(endereco.getCep());
            funcionario.setLogradouro(endereco.getLogradouro());
            funcionario.setBairro(endereco.getBairro());
            funcionario.setLocalidade(endereco.getLocalidade());
            funcionario.setUf(endereco.getUf());
        }

        return funcionarioRepository.save(funcionario);
    }
}

