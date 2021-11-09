package br.com.zup.Cadastros.cadastro;

import br.com.zup.Cadastros.cadastro.dtos.CadastroDTO;
import br.com.zup.Cadastros.cadastro.dtos.SaidaCadastrosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cadastros")
public class CadastroController {
    @Autowired
    private CadastroService cadastroService;

    /*
    todo  1 - crie um metodo para cadastrar uma pessoa.
      Para um cadastro todo os campos são obrigatórios EXCETO o campo dataDoCadastro que deve ser preenchido pelo proprio sistema e o client não deve saber da existencia desse campo
     todo 2 - Faça um metodo que retorna a lista inteira de cadastros ou filtrado por cadastros que moram sozinhos, que tem pet ou por idade.
     nessa lista deve ser retornado apenas os campos ID, NOME e SOBRENOME.
     todo 3 - faça um metodo para DELETAR um cadastro por id.
     todo 4 - faça um metodo que retorna TODOS os dados de um usuario pesquisado pelo ID.
     */

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void fazerCadastro(@RequestBody @Valid CadastroDTO cadastroDTO) {
        Cadastro cadastro = new Cadastro();

        cadastro.setCpf(cadastroDTO.getCpf());
        cadastro.setNome(cadastroDTO.getNome());
        cadastro.setSobrenome(cadastroDTO.getSobrenome());
        cadastro.setCidade(cadastroDTO.getCidade());
        cadastro.setBairro(cadastroDTO.getBairro());
        cadastro.setNomeDoParenteProximo(cadastroDTO.getNomeDoParenteProximo());
        cadastro.setMoraSozinho(cadastroDTO.isMoraSozinho());
        cadastro.setTemPet(cadastroDTO.isTemPet());
        cadastro.setIdade(cadastroDTO.getIdade());

        cadastroService.cadastrarPessoa(cadastro);

    }

    @GetMapping
    public List<SaidaCadastrosDTO> exibirPessoasCadastradas(@RequestParam
                                                                    (required = false, name = "mora_sozinho")
                                                                    boolean moraSozinho,
                                                            @RequestParam(required = false, name = "tem_pet")
                                                                    boolean temPet,
                                                            @RequestParam(required = false) Integer idade) {

        List<SaidaCadastrosDTO> pessoasCadastradas = new ArrayList<>();

        for (Cadastro referencia : cadastroService.exibirTodosOsCadastros(moraSozinho, temPet, idade)) {
            pessoasCadastradas.add(new SaidaCadastrosDTO(referencia.getCpf(), referencia.getNome(),
                    referencia.getSobrenome()));
        }

        return pessoasCadastradas;
    }

    @GetMapping("/{cpf}")
    public SaidaCadastrosDTO cadastroID(@PathVariable String cpf) {
        Cadastro cadastro = cadastroService.buscarCadastroId(cpf);
        SaidaCadastrosDTO cadastroId = new SaidaCadastrosDTO(cadastro.getCpf(), cadastro.getNome(), cadastro.getSobrenome());

        return cadastroId;
    }

    @DeleteMapping("/{cpf}")
    public void excluirCadastro(@PathVariable String cpf) {
        cadastroService.deletarCadastro(cpf);
    }

}
