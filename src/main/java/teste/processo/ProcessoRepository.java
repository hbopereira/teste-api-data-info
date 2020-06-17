package teste.processo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import teste.base.BaseRepository;

@Repository
public interface ProcessoRepository extends BaseRepository<Processo> {
	
	@Query(value="select * from processo where nr_processo like :numpro", nativeQuery=true)
	public Page<Processo> listarPorNumPro(Pageable p, @Param("numpro") String numpro);

}
