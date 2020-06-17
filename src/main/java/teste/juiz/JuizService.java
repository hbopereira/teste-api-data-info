package teste.juiz;

import java.util.Date;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import teste.base.BaseService;
import teste.processo.Processo;
import teste.processo.ProcessoRepository;
import teste.resumo.JuizResumo;

@Service
public class JuizService extends BaseService<Juiz, JuizRepository> {

	private final JuizRepository juizRepo;
	private final ProcessoRepository proRepo;

	public JuizService(JuizRepository juizRepo, ProcessoRepository proRepo) {
		this.juizRepo = juizRepo;
		this.proRepo = proRepo;
	}

	@Scheduled(cron = "0 0/1 * * * *")
	public void monitorarProcessos() {
		JuizResumo juizResumo = juizRepo.listarJuizesESeusProcessosPorQuantidade().get(0);
		
		
		if (juizRepo.existsById(juizResumo.getId())) {
			List<Processo> processos = proRepo.findAll();
			
			for(Processo p: processos) {
				Date data = new Date();
				p.setDataDistribuicao(data);
			}

			Juiz juiz = new Juiz();
		    
			juiz.setId(juizResumo.getId());
			juiz.setCpf(juizResumo.getCpf());
			juiz.setNome(juizResumo.getNome());
			juiz.setDataNascimento(juizResumo.getDataNascimento());
			juiz.setProcessos(processos);

			juizRepo.save(juiz);
		}

	}

}
