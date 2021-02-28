package orange.two.projeto2.repository;

import orange.two.projeto2.domain.Vacinacao;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacinacaoRepository extends PagingAndSortingRepository <Vacinacao,Long> {
}
