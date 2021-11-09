package br.com.zup.Cadastros.config;


import br.com.zup.Cadastros.cadastro.exceptions.CpfJaCadastrado;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import br.com.zup.Cadastros.cadastro.exceptions.CadastroNaoEncontrado;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;


@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<ErroValidacao> manipularErrosDeValidacao(MethodArgumentNotValidException exception) {
        List<ErroValidacao> errosValidacao = new ArrayList<>();

        for (FieldError referencia : exception.getFieldErrors()) {
            ErroValidacao erroValidacao = new ErroValidacao(referencia.getField(), referencia.getDefaultMessage());
            errosValidacao.add(erroValidacao);
        }

        return errosValidacao;
    }


    @ExceptionHandler(CadastroNaoEncontrado.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MensagemErro manipularCadastroNaoEncontrado(CadastroNaoEncontrado exception) {
        return new MensagemErro(exception.getMessage());
    }


    @ExceptionHandler(CpfJaCadastrado.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemErro manipularCpfJaCadastrado(CpfJaCadastrado exception) {
        return new MensagemErro(exception.getMessage());
    }

}
