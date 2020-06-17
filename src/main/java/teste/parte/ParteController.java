package teste.parte;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import teste.base.BaseController;
import teste.processo.Processo;

@RestController
@RequestMapping(value="/api/partes")
public class ParteController extends BaseController<Parte,ParteRepository,ParteService>{
	
	private final ParteRepository parteRepo;
	private final ParteService parteService;

	public ParteController(ParteRepository parteRepo, ParteService parteService) {
		this.parteRepo = parteRepo;
		this.parteService = parteService;
	}
	
	@PostMapping(value="/salvar")
	public ResponseEntity<String> salvar(@RequestBody Parte parte) {
		try {
			Optional<Parte> resultado = parteService.salvar(parte);
			if (resultado.isPresent()) {
				return ResponseEntity.status(HttpStatus.CREATED).body(resultado.get().getId().toString());
			}
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.badRequest().build();
	}
	
	
	@GetMapping(value="/listarPorNome")
	public Page<Parte> listarPorNome(Pageable p, @RequestParam("nome") String nome){
		return parteRepo.listarPorNome(p, nome);
	}

}
