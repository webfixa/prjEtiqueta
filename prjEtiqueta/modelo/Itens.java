package modelo;

public class Itens 
{
	private int item;
	private String descricao;
	private String cod_barras;
	private int qnt;
	private int filial;
	private String preco;
	private String verificador;
	private String produto;
	private String prodVerificador;
	private String estoque;
	
	public Itens(int item, String descricao, String cod_barras, int qnt,
			int filial, String preco, String verificador, String produto, String proVerificador, String estoque) {
		super();
		this.item = item;
		this.descricao = descricao;
		this.cod_barras = cod_barras;
		this.qnt = qnt;
		this.filial = filial;
		this.preco = preco;
		this.verificador = verificador;
		this.produto = produto;
		this.prodVerificador = prodVerificador;
		this.estoque = estoque;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCod_barras() {
		return cod_barras;
	}

	public void setCod_barras(String cod_barras) {
		this.cod_barras = cod_barras;
	}

	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}

	public int getFilial() {
		return filial;
	}

	public void setFilial(int filial) {
		this.filial = filial;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getVerificador() {
		return verificador;
	}

	public void setVerificador(String verificador) {
		this.verificador = verificador;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getProdVerificador() {
		return prodVerificador;
	}

	public void setProdVerificador(String prodVerificador) {
		this.prodVerificador = prodVerificador;
	}

	public String getEstoque() {
		return estoque;
	}

	public void setEstoque(String estoque) {
		this.estoque = estoque;
	}
	
	
}
