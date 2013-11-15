package modelo;

import java.sql.Date;

public class Nota {
	private String codfil;
	private String fantasia;
	private String item;
	private String tpnota;
	private String numnota;
	private String serie;
	private String coditprod;
	private String digitprod;
	private Date dtnota;
	private String razsoc;
	private String descricao;
	private String codprod;
	private String digprod;
	private String codbarra;
	private String coditem;
	private String preco;
	private String codforne;
	private String codlinha;
	private String codfam;
	private String codgrupo;
	private String codsubgp;
	private String quantidade; 
	
	public Nota(String codfil, String fantasia, String item, String tpnota,
			String numnota, String serie, String coditprod, String digitprod,
			Date dtnota, String razsoc, String descricao, String codprod,
			String digprod, String codbarra, String coditem, String preco,
			String codforne, String codlinha, String codfam, String codgrupo,
			String codsubgp, String quantidade) {
		super();
		this.codfil = codfil;
		this.fantasia = fantasia;
		this.item = item;
		this.tpnota = tpnota;
		this.numnota = numnota;
		this.serie = serie;
		this.coditprod = coditprod;
		this.digitprod = digitprod;
		this.dtnota = dtnota;
		this.razsoc = razsoc;
		this.descricao = descricao;
		this.codprod = codprod;
		this.digprod = digprod;
		this.codbarra = codbarra;
		this.coditem = coditem;
		this.preco = preco;
		this.codforne = codforne;
		this.codlinha = codlinha;
		this.codfam = codfam;
		this.codgrupo = codgrupo;
		this.codsubgp = codsubgp;
		this.quantidade = quantidade;
	}

	public String getCodfil() {
		return codfil;
	}

	public void setCodfil(String codfil) {
		this.codfil = codfil;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getTpnota() {
		return tpnota;
	}

	public void setTpnota(String tpnota) {
		this.tpnota = tpnota;
	}

	public String getNumnota() {
		return numnota;
	}

	public void setNumnota(String numnota) {
		this.numnota = numnota;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getCoditprod() {
		return coditprod;
	}

	public void setCoditprod(String coditprod) {
		this.coditprod = coditprod;
	}

	public String getDigitprod() {
		return digitprod;
	}

	public void setDigitprod(String digitprod) {
		this.digitprod = digitprod;
	}

	public Date getDtnota() {
		return dtnota;
	}

	public void setDtnota(Date dtnota) {
		this.dtnota = dtnota;
	}

	public String getRazsoc() {
		return razsoc;
	}

	public void setRazsoc(String razsoc) {
		this.razsoc = razsoc;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodprod() {
		return codprod;
	}

	public void setCodprod(String codprod) {
		this.codprod = codprod;
	}

	public String getDigprod() {
		return digprod;
	}

	public void setDigprod(String digprod) {
		this.digprod = digprod;
	}

	public String getCodbarra() {
		return codbarra;
	}

	public void setCodbarra(String codbarra) {
		this.codbarra = codbarra;
	}

	public String getCoditem() {
		return coditem;
	}

	public void setCoditem(String coditem) {
		this.coditem = coditem;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getCodforne() {
		return codforne;
	}

	public void setCodforne(String codforne) {
		this.codforne = codforne;
	}

	public String getCodlinha() {
		return codlinha;
	}

	public void setCodlinha(String codlinha) {
		this.codlinha = codlinha;
	}

	public String getCodfam() {
		return codfam;
	}

	public void setCodfam(String codfam) {
		this.codfam = codfam;
	}

	public String getCodgrupo() {
		return codgrupo;
	}

	public void setCodgrupo(String codgrupo) {
		this.codgrupo = codgrupo;
	}

	public String getCodsubgp() {
		return codsubgp;
	}

	public void setCodsubgp(String codsubgp) {
		this.codsubgp = codsubgp;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

}
