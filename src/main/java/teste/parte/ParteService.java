package teste.parte;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import teste.base.BaseService;
import teste.endereco.EnderecoParte;
import teste.endereco.EnderecoParteRepository;

@Service
public class ParteService extends BaseService<Parte, ParteRepository> {

	private final ParteRepository parteRepo;
	private final EnderecoParteRepository endParteRepo;

	public ParteService(ParteRepository parteRepo, EnderecoParteRepository endParteRepo) {
		this.parteRepo = parteRepo;
		this.endParteRepo = endParteRepo;
	}

	public Optional<Parte> salvar(Parte parte) {
		EnderecoParte endParte = buscarCep(parte.getEndParte().getCep());
		parte.setEndParte(endParte);
		Parte nova = parteRepo.save(parte);
		return Optional.of(nova);
	}

	public EnderecoParte buscarCep(String cep) {

		try {
			URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
			URLConnection urlConnection = url.openConnection();
			InputStream is = urlConnection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			StringBuilder sb = new StringBuilder();
			br.lines().forEach(l -> sb.append(l.trim()));
			JSONObject jsonEndereco = new JSONObject(sb.toString());

			EnderecoParte endParte = montarESalvarObjetoEnderecoParte(jsonEndereco);
			return endParte;

		} catch (Exception e) {
			throw new RuntimeException("Erro inesparado com a validacao do CEP");
		}
	}

	public EnderecoParte montarESalvarObjetoEnderecoParte(JSONObject jsonEndereco) {
		EnderecoParte endParte = new EnderecoParte();
		endParte.setBairro(jsonEndereco.getString("bairro"));
		endParte.setCep(jsonEndereco.getString("cep"));
		endParte.setCidade(jsonEndereco.getString("localidade"));
		endParte.setEstado(jsonEndereco.getString("uf"));
		endParte.setLogradouro(jsonEndereco.getString("logradouro"));

		return endParteRepo.save(endParte);

	}

}
