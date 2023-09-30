package br.com.crud.model;

public class PacoteDeViagem {
	private String destino,descricao;
	private Float preco;
	private int duracaoEmDias;
	private int idPacote;
	public int getIdPacote() {
		return idPacote;
	}
	public void setIdPacote(int idPacote) {
		this.idPacote = idPacote;
	}
	public PacoteDeViagem() {
		
	}
	public PacoteDeViagem(String destino,String descricao,Float preco,int duracaoEmDias){
		this.destino=destino;
		this.descricao=descricao;
		this.preco=preco;
		this.duracaoEmDias=duracaoEmDias;
	}
	public PacoteDeViagem(int idPacote) {
		this.idPacote=idPacote;
	}
	public PacoteDeViagem(String destino, String descricao, Float preco, int duracaoEmDias, int idPacote) {
		this.destino=destino;
		this.descricao=descricao;
		this.preco=preco;
		this.duracaoEmDias=duracaoEmDias;
		this.idPacote=idPacote;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Float getPreco() {
		return preco;
	}
	public void setPreco(Float preco) {
		this.preco = preco;
	}
	public int getDuracaoEmDias() {
		return duracaoEmDias;
	}
	public void setDuracaoEmDias(int duracaoEmDias) {
		this.duracaoEmDias = duracaoEmDias;
	}
}
