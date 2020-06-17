package teste.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class BaseController<ENTITY extends BaseEntity, REPOSITORY extends BaseRepository<ENTITY>, SERVICE extends BaseService<ENTITY, REPOSITORY>> {
	@Autowired
	private SERVICE service;

	@Autowired
	private REPOSITORY repo;

	@PostMapping
	public ResponseEntity<String> salvar(@RequestBody ENTITY entity) {
		try {
			Optional<ENTITY> resultado = service.salvar(entity);
			if (resultado.isPresent()) {
				return ResponseEntity.status(HttpStatus.CREATED).body(resultado.get().getId().toString());
			}
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.badRequest().build();
	}

	@GetMapping
	public Page<ENTITY> listarTodos(Pageable p) {
		return repo.listarTodos(p);

	}

}