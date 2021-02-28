package orange.two.projeto2.service;

import orange.two.projeto2.domain.Pessoa;
import orange.two.projeto2.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public Iterable<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    public void deletar(Long id) {
        Optional<Pessoa> pessoaOpt = pessoaRepository.findById(id);
        if (pessoaOpt.isPresent()) {
            pessoaRepository.delete(pessoaOpt.get());
        }
    }

    public void criar(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }

    public void att(Pessoa pessoa) throws Exception {
        if (pessoa.getId() == null){
            throw new Exception("");
        }
            Optional<Pessoa> pessoaOpt = pessoaRepository.findById(pessoa.getId());
            if (pessoaOpt.isPresent()) {
                pessoaRepository.save(pessoa);
            } else {
            throw new Exception("");
        }
    }
}
