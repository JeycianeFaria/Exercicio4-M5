package br.com.zup.Cadastros.cadastro;

import br.com.zup.Cadastros.cadastro.dtos.CadastroDTO;
import br.com.zup.Cadastros.cadastro.dtos.SaidaCadastrosDTO;
import br.com.zup.Cadastros.cadastro.dtos.SaidaDetalhadaCadastroDTO;
import org.modelmapper.ModelMapper;
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
    @Autowired
    private ModelMapper modelMapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void fazerCadastro(@RequestBody @Valid CadastroDTO cadastroDTO) {
        Cadastro cadastro = modelMapper.map(cadastroDTO, Cadastro.class);
        cadastroService.cadastrarPessoa(cadastro);

    }

    @GetMapping
    public List<SaidaCadastrosDTO> exibirPessoasCadastradas(@RequestParam
                                                                    (required = false, name = "mora_sozinho")
                                                                    Boolean moraSozinho,
                                                            @RequestParam(required = false, name = "tem_pet")
                                                                    Boolean temPet,
                                                            @RequestParam(required = false) Integer idade) {

        List<SaidaCadastrosDTO> pessoasCadastradas = new ArrayList<>();

        for (Cadastro referencia : cadastroService.exibirTodosOsCadastros(moraSozinho, temPet, idade)) {
            SaidaCadastrosDTO saidaCadastrosDTO = modelMapper.map(referencia, SaidaCadastrosDTO.class);
            pessoasCadastradas.add(saidaCadastrosDTO);
        }

        return pessoasCadastradas;
    }

    @GetMapping("/{cpf}")
    public SaidaDetalhadaCadastroDTO cadastroID(@PathVariable String cpf) {
        Cadastro cadastro = cadastroService.buscarCadastroId(cpf);
        SaidaDetalhadaCadastroDTO cadastroId = modelMapper.map(cadastro, SaidaDetalhadaCadastroDTO.class);

        return cadastroId;
    }

    @DeleteMapping("/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirCadastro(@PathVariable String cpf) {
        cadastroService.deletarCadastro(cpf);
    }

}
