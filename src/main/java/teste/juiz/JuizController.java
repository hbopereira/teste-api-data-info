package teste.juiz;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import teste.base.BaseController;

@RestController
@RequestMapping("/api/juizes")
public class JuizController extends BaseController<Juiz, JuizRepository, JuizService> {

	private final JuizRepository juizRepo;
	private final JuizService juizService;
	

	public JuizController(JuizRepository juizRepo, JuizService juizService) {
		this.juizRepo = juizRepo;
		this.juizService = juizService;
	}

	@GetMapping(value = "/listarPorNome")
	public Page<Juiz> listarPorNome(Pageable p, @RequestParam("nome") String nome) {
		return juizRepo.listarPorNome(p, nome);
	}
	

	@GetMapping(value="/monitorarProcessos")
	public void monitorarProcessos() {
		juizService.monitorarProcessos();
	}
	

}
