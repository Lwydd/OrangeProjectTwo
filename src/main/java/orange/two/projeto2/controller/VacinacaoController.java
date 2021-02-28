package orange.two.projeto2.controller;

import orange.two.projeto2.domain.Vacinacao;
import orange.two.projeto2.service.VacinacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("vacinacao")
public class VacinacaoController {
    @Autowired
    private VacinacaoService vacinacaoService;

    @GetMapping
    public ResponseEntity<Iterable<Vacinacao>> listar() {
        return ResponseEntity.ok().body(vacinacaoService.listar());
    }

    @PutMapping
    public ResponseEntity att (@RequestBody Vacinacao vacinacao){
        try {
            vacinacaoService.criar(vacinacao);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletar(@PathVariable("id") Long id) {
        vacinacaoService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody Vacinacao vacinacao) {
        try {
            vacinacaoService.criar(vacinacao);
            return ResponseEntity.created(new URI("")).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}