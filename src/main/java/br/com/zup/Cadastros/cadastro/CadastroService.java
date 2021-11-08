package br.com.zup.Cadastros.cadastro;

import br.com.zup.Cadastros.cadastro.dtos.CadastroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
        }else if (idade != null){
            return cadastroRepository.findAllByIdade(idade);
        }
        Iterable<Cadastro> cadastros = cadastroRepository.findAll();
        return (List<Cadastro>) cadastros;
    }

    public Cadastro buscarCadastroId(String cpf){
        Optional<Cadastro> cadastro = cadastroRepository.findById(cpf);
        if (cadastro.isEmpty()){
            throw  new RuntimeException("Cadastro não encontrado");
        }

        return cadastro.get();
    }

    public void deletarCadastro(String cpf){
        Cadastro deletarCadastro = buscarCadastroId(cpf);
        cadastroRepository.delete(deletarCadastro);
    }

}
