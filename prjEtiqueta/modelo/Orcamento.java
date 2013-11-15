package modelo;

public class Orcamento {
	private String CODFIL;
	private String NUMORC;
	private String ITEM;
	private String QTCOMP;
	private String DESCRICAO;
	private String CODBARRA;
	private String PRECOUNIT;
	private String CODITPROD;
	
	public Orcamento(String codfil, String numorc, String item, String qtcomp,
			String descricao, String codbarra, String precounit, String CODITPROD) {
		super();
		CODFIL = codfil;
		NUMORC = numorc;
		ITEM = item;
		QTCOMP = qtcomp;
		DESCRICAO = descricao;
		CODBARRA = codbarra;
		PRECOUNIT = precounit;
		this.CODITPROD = CODITPROD;
	}

	public String getCODFIL() {
		return CODFIL;
	}

	public void setCODFIL(String codfil) {
		CODFIL = codfil;
	}

	public String getNUMORC() {
		return NUMORC;
	}

	public void setNUMORC(String numorc) {
		NUMORC = numorc;
	}

	public String getITEM() {
		return ITEM;
	}

	public void setITEM(String item) {
		ITEM = item;
	}

	public String getQTCOMP() {
		return QTCOMP;
	}

	public void setQTCOMP(String qtcomp) {
		QTCOMP = qtcomp;
	}

	public String getDESCRICAO() {
		return DESCRICAO;
	}

	public void setDESCRICAO(String descricao) {
		DESCRICAO = descricao;
	}

	public String getCODBARRA() {
		return CODBARRA;
	}

	public void setCODBARRA(String codbarra) {
		CODBARRA = codbarra;
	}

	public String getPRECOUNIT() {
		return PRECOUNIT;
	}

	public void setPRECOUNIT(String precounit) {
		PRECOUNIT = precounit;
	}

	public String getCODITPROD() {
		return CODITPROD;
	}

	public void setCODITPROD(String coditprod) {
		CODITPROD = coditprod;
	}
	
}
