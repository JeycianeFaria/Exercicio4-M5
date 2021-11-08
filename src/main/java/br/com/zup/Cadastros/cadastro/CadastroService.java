package br.com.zup.Cadastros.cadastro;

import br.com.zup.Cadastros.cadastro.dtos.CadastroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CadastroService {
    @Autowired
    private CadastroRepository cadastroRepository;

    public void cadastrarPessoa(Cadastro cadastroRecebido){
        cadastroRecebido.setDataDoCadastro(LocalDate.now());
        cadastroRepository.save(cadastroRecebido);
    }

}
