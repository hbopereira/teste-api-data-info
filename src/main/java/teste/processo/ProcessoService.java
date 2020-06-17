package teste.processo;

import java.util.Optional;

import org.springframework.stereotype.Service;

import teste.base.BaseService;
import teste.juiz.JuizRepository;
import teste.parte.Parte;
import teste.resumo.JuizResumo;

@Service
public class ProcessoService extends BaseService<Processo, ProcessoRepository> {

	private final ProcessoRepository proRepo;

	public ProcessoService(ProcessoRepository proRepo) {
		this.proRepo = proRepo;
	}
	

	public Optional<Processo> salvar(Processo processo) {

		//verificarSeProcessoContemTiposPartesIguais(processo);
		verificarSeArrayParteVazioOuTamanho(processo);
		verificarSeClasseEstaVinculadoAoProcesso(processo);

		Processo novo = proRepo.save(processo);
		return Optional.of(novo);

	}
	

	public void verificarSeProcessoContemTiposPartesIguais(Processo processo) {	
		for (Parte p : processo.getPartes()) {
			if (p.getTipoParte().equals(p.getTipoParte())) {
				throw new RuntimeException("O processo não pode conter tipos de partes iguais!");

			}
		}
	}

	public void verificarSeArrayParteVazioOuTamanho(Processo processo) {
		if (processo.getPartes().isEmpty() || processo.getPartes().size() == 1) {
			throw new RuntimeException("Para cadastrar um processo por favor vincule as partes necessarias!");
		}
	}

	public void verificarSeClasseEstaVinculadoAoProcesso(Processo processo) {
		if (processo.getClasse() == null) {
			throw new RuntimeException("Para cadastrar um processo por favor vincule uma classe ao mesmo!");
		}
	}

}
