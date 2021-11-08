package br.com.zup.Cadastros.cadastro;

import br.com.zup.Cadastros.cadastro.dtos.CadastroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CadastroService {
    @Autowired
    private CadastroRepository cadastroRepository;

    public void cadastrarPessoa(Cadastro cadastroRecebido){
        cadastroRecebido.setDataDoCadastro(LocalDate.now());
        cadastroRepository.save(cadastroRecebido);
    }

    public List<Cadastro>  exibirTodosOsCadastros(boolean moraSozinho, boolean temPet, Integer idade){
        if (moraSozinho){
            return cadastroRepository.findAllByMoraSozinho(moraSozinho);
        }else if (temPet){
            return cadastroRepository.findAllByTemPet(temPet);
        }else if (idade != 0){
            return cadastroRepository.findAllByIdade(idade);
        }
        Iterable<Cadastro> cadastros = cadastroRepository.findAll();
        return (List<Cadastro>) cadastros;
    }

}
