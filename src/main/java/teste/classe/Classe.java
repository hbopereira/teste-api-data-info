package teste.classe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import teste.base.BaseEntity;

@Entity
@Table(name = "classe")
public class Classe extends BaseEntity {

	@NotNull
	@Column(name = "id_cnj")
	private String idCnj;

	@NotNull
	@Column(name = "ds_classe")
	private String dsClasse;

	@NotNull
	private String sigla;

	@NotNull
	private String tipo;

	public String getIdCnj() {
		return idCnj;
	}

	public void setIdCnj(String idCnj) {
		this.idCnj = idCnj;
	}

	public String getDsClasse() {
		return dsClasse;
	}

	public void setDsClasse(String dsClasse) {
		this.dsClasse = dsClasse;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
