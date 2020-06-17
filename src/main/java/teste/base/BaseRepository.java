package teste.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean 
public interface BaseRepository<ENTITY> extends JpaRepository<ENTITY, Long>{

	@Query(
			nativeQuery = true, 
			countQuery = "select count(id) from #{#entityName}", 
			value = "select * from #{#entityName} order by id")
	Page<ENTITY> listarTodos(Pageable pageable);

	
}
