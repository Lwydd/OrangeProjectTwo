package orange.two.projeto2.repository;

import orange.two.projeto2.domain.Pessoa;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends PagingAndSortingRepository <Pessoa,Long> {

}
