package basicas;

public class Medicamento {

	private Integer id;
	//essa é a numeracao do medicamento no Ministerio da Saude
	private Integer registroMS;
	private String descricao;
	private String tipo;
	
	public Medicamento(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRegistroMS() {
		return registroMS;
	}

	public void setRegistroMS(Integer registroMS) {
		this.registroMS = registroMS;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((registroMS == null) ? 0 : registroMS.hashCode());
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
		Medicamento other = (Medicamento) obj;
		if (registroMS == null) {
			if (other.registroMS != null)
				return false;
		} else if (!registroMS.equals(other.registroMS))
			return false;
		return true;
	}
	
}
