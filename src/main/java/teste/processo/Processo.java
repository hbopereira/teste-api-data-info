package teste.processo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import teste.base.BaseEntity;
import teste.classe.Classe;
import teste.juiz.Juiz;
import teste.parte.Parte;

@Entity
@Table(name = "processo")
public class Processo extends BaseEntity {


	@NotNull
	@Column(name = "nr_processo")
	private String nrProcesso;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "data_criacao")
	private Date dataCriacao;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "data_distribuicao")
	private Date dataDistribuicao;

	@OneToOne
	@JoinColumn(name = "id_classe")
	private Classe classe;

	@ManyToMany
	@JoinTable(name = "processo_parte", joinColumns = { @JoinColumn(name = "id_processo") }, inverseJoinColumns = {
			@JoinColumn(name = "id_parte") })
	private List<Parte> partes;

	@JsonIgnore
	@ManyToMany(mappedBy = "processos")
	private List<Juiz> juizes;

	public Date getDataDistribuicao() {
		return dataDistribuicao;
	}

	public void setDataDistribuicao(Date dataDistribuicao) {
		this.dataDistribuicao = dataDistribuicao;
	}

	public List<Parte> getPartes() {
		return partes;
	}

	public void setPartes(List<Parte> partes) {
		this.partes = partes;
	}

	public List<Juiz> getJuizes() {
		return juizes;
	}

	public void setJuizes(List<Juiz> juizes) {
		this.juizes = juizes;
	}

	public String getNrProcesso() {
		return nrProcesso;
	}

	public void setNrProcesso(String nrProcesso) {
		this.nrProcesso = nrProcesso;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

}
