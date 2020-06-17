package teste.parte;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import teste.base.BaseRepository;
import teste.processo.Processo;

@Repository
public interface ParteRepository  extends BaseRepository<Parte>{
	
	@Query(value="select * from parte where nome like :nome", nativeQuery=true)
	public Page<Parte> listarPorNome(Pageable p, @Param("nome") String nome);

}
