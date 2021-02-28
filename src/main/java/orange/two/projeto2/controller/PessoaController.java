package orange.two.projeto2.controller;

import orange.two.projeto2.domain.Pessoa;
import orange.two.projeto2.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<Iterable<Pessoa>> listar() {
        return ResponseEntity.ok().body(pessoaService.listar());
    }

    @PutMapping
    public ResponseEntity att(@RequestBody Pessoa pessoa){
        try {
            pessoaService.criar(pessoa);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletar(@PathVariable("id") Long id) {
        pessoaService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody Pessoa pessoa) {
        try {
            pessoaService.criar(pessoa);
            return ResponseEntity.created(new URI("")).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}