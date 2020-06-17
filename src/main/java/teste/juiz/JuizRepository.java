package teste.juiz;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import teste.base.BaseRepository;
import teste.resumo.JuizResumo;

@Repository
public interface JuizRepository extends BaseRepository<Juiz>{
	
	@Query(value="select * from juiz where nome like :nome", nativeQuery=true)
	public Page<Juiz> listarPorNome(Pageable p, @Param("nome") String nome);
	
	
	@Query(value="SELECT   id,nome,data_nascimento,cpf, " + 
			"         count(j.nome) AS Qtd " + 
			"FROM  juiz j " + 
			"INNER join processo_juiz pj on pj.id_juiz = j.id " + 
			"GROUP BY j.id, j.nome,j.data_nascimento,j.cpf " + 
			"HAVING   COUNT(j.nome) >=1 " + 
			"ORDER BY COUNT(j.nome) asc ",nativeQuery = true)
	public List<JuizResumo> listarJuizesESeusProcessosPorQuantidade();

}
