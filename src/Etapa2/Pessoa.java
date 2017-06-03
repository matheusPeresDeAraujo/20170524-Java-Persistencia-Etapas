package Etapa2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false, unique=false)
	private String matricula;
	
	@Column(nullable=false, length=200)
	private String nome;
	
	@Column(nullable=false)
	private Date nascimento;
	
	@Column(nullable=false, length=1)
	private char sexo;
	
	@Column(length=11)
	private char telefone;
	
	@Column(length=3)
	private char ramal;
	
	@OneToMany(mappedBy = "pessoa", 
			 cascade = CascadeType.ALL, 
			 orphanRemoval = true)
	private List<Projeto> projetos = new ArrayList<>();

	public Pessoa(String matricula, String nome, Date nascimento, char sexo, char telefone, char ramal) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.nascimento = nascimento;
		this.sexo = sexo;
		this.telefone = telefone;
		this.ramal = ramal;
	}

	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public char getTelefone() {
		return telefone;
	}

	public void setTelefone(char telefone) {
		this.telefone = telefone;
	}

	public char getRamal() {
		return ramal;
	}

	public void setRamal(char ramal) {
		this.ramal = ramal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", matricula=" + matricula + ", nome=" + nome + ", nascimento=" + nascimento
				+ ", sexo=" + sexo + ", telefone=" + telefone + ", ramal=" + ramal + "]";
	}
	
	
}
