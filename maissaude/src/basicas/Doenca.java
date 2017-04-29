package basicas;

public class Doenca {

	private Integer id;
	private String descricao;
	private String causa;
	private String gravidade;
	
	public Doenca(){}

	public Doenca(Integer id, String descricao, String causa, String gravidade) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.causa = causa;
		this.gravidade = gravidade;
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

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public String getGravidade() {
		return gravidade;
	}

	public void setGravidade(String gravidade) {
		this.gravidade = gravidade;
	}
	
	
}
