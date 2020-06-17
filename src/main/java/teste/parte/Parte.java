package teste.parte;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;

import teste.base.BaseEntity;
import teste.endereco.EnderecoParte;

@Entity
@Table(name = "parte")
public class Parte extends BaseEntity {

	@NotNull
	private String nome;

	@NotNull
	private Long cpf;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@NotNull
	@Column(name = "tipoParte")
	private String tipoParte;
	
	@OneToOne
	@JoinColumn(name="id_endparte")
	private EnderecoParte endParte;

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

	public String getTipoParte() {
		return tipoParte;
	}

	public void setTipoParte(String tipoParte) {
		this.tipoParte = tipoParte;
	}

	public EnderecoParte getEndParte() {
		return endParte;
	}

	public void setEndParte(EnderecoParte endParte) {
		this.endParte = endParte;
	}
	
	

}
