package teste.juiz;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;

import teste.base.BaseEntity;
import teste.processo.Processo;

@Entity
@Table(name = "juiz")
public class Juiz extends BaseEntity {

	@NotNull
	private String nome;

	@NotNull
	private Long cpf;

	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	
	@ManyToMany
	@JoinTable(name = "processo_juiz", 
	     joinColumns = { @JoinColumn(name = "id_juiz") },
	     inverseJoinColumns = {
    @JoinColumn(name = "id_processo") })
	private List<Processo> processos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Processo> getProcessos() {
		return processos;
	}

	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}
	
	

}
