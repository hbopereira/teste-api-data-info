package teste.processo;

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

@RestController
@RequestMapping("/api/processos")
public class ProcessoController extends BaseController<Processo,ProcessoRepository,ProcessoService>{
	
	private final ProcessoRepository proRepo;
	private final ProcessoService proService;
	
	public ProcessoController(ProcessoRepository proRepo, ProcessoService proService) {
		this.proRepo = proRepo;
		this.proService = proService;
	}
	
	@PostMapping(value="/salvar")
	public ResponseEntity<String> salvar(@RequestBody Processo processo) {
		try {
			Optional<Processo> resultado = proService.salvar(processo);
			if (resultado.isPresent()) {
				return ResponseEntity.status(HttpStatus.CREATED).body(resultado.get().getId().toString());
			}
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping(value="/listarPorNumPro")
	public Page<Processo> listarPorNumPro(Pageable p, @RequestParam("numpro") String numpro){
		return proRepo.listarPorNumPro(p, numpro);
	}
	
	

}
