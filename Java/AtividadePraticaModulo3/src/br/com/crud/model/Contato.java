package br.com.crud.model;

public class Contato {
private String assunto ;
private String mensagem;
private int idContato;
private Cliente cliente;


public int getIdContato() {
	return idContato;
}
public void setIdContato(int idContato) {
	this.idContato = idContato;
}
public Contato(String assunto, String mensagem) {
	this.assunto=assunto;
	this.mensagem=mensagem;
	
}
public Contato(){
	
}

public Contato(String assunto, String mensagem, Cliente cliente) {
	this.assunto=assunto;
	this.mensagem=mensagem;
	this.cliente=cliente;
}
public Contato(int idContato) {
	this.idContato=idContato;
}
public Contato(int idContato,  String assunto, String mensagem) {
	this.idContato=idContato;
	this.assunto=assunto;
	this.mensagem=mensagem;
}
public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
public String getAssunto() {
	return assunto;
}
public void setAssunto(String assunto) {
	this.assunto = assunto;
}
public String getMensagem() {
	return mensagem;
}
public void setMensagem(String mensagem) {
	this.mensagem = mensagem;
}

}
