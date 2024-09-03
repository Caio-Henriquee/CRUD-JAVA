package br.com.projeto.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.model.Cliente;
import br.com.projeto.api.repository.Repositorio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins="*") //libera a porta a ser usada, é so alterar o parametro, inves da estrela coloca a porta do front-end
public class Controle {
    
    @Autowired
    private Repositorio acao;

    @PutMapping("/")
    public Cliente editar(@RequestBody Cliente c){
      return acao.save(c);
    }

    @GetMapping("/")
    public Iterable<Cliente> listar() {
       return acao.findAll();
    }

    @PostMapping("/")
    public Cliente cadastrar(@RequestBody Cliente c) {
       return acao.save(c);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable long codigo){
       acao.deleteById(codigo);
    }


    
}
