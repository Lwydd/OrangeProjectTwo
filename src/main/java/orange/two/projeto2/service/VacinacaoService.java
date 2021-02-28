package orange.two.projeto2.service;

import orange.two.projeto2.domain.Vacinacao;
import orange.two.projeto2.repository.VacinacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VacinacaoService {
    @Autowired
    private VacinacaoRepository vacinacaoRepository;

    public Iterable<Vacinacao> listar() {
        return vacinacaoRepository.findAll();
    }

    public void deletar(Long id) {
        Optional<Vacinacao> VacinacaoOpt = vacinacaoRepository.findById(id);
        if (VacinacaoOpt.isPresent()) {
            vacinacaoRepository.delete(VacinacaoOpt.get());
        }
    }

    public void criar(Vacinacao vacinacao) {
        vacinacaoRepository.save(vacinacao);
    }

    public void att(Vacinacao vacinacao) throws Exception {
        if (vacinacao.getId() == null){
            throw new Exception("");
        }
        Optional<Vacinacao> vacinacaoOpt = vacinacaoRepository.findById(vacinacao.getId());
        if (vacinacaoOpt.isPresent()) {
            vacinacaoRepository.save(vacinacao);
        } else {
            throw new Exception("");
        }
    }
}