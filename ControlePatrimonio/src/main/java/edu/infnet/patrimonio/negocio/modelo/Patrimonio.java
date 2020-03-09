package edu.infnet.patrimonio.negocio.modelo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Patrimonio")
public class Patrimonio {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	private Integer id;
	@Column
	private String descricao;
	@Column
	private String localizacao;
	
	public Patrimonio() {
	}

	public Patrimonio(Integer id) {
		this.id = id;
	}
	
	public Patrimonio(Integer id, String descricao, String localizacao) {
		this.id = id;
		this.descricao = descricao;
		this.localizacao = localizacao;
	}

	public Patrimonio(String descricao, String localizacao) {
		this.descricao = descricao;
		this.localizacao = localizacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	@Override
	public String toString() {
		return "Patrimonio [id=" + id + ", descricao=" + descricao + ", localizacao=" + localizacao + "]";
	}

	
}
