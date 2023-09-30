package br.com.crud.model;

import java.util.Date;

public class Reserva {
	private Date dataReserva;
	private String dataDeViagem;
	private String status;
	private Cliente cliente;
	private PacoteDeViagem pacote;
	private int idReserva;
	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
public PacoteDeViagem getPacote() {
		return pacote;
	}
	public void setPacote(PacoteDeViagem pacote) {
		this.pacote = pacote;
	}
	public Reserva(Date dataReserva,String dataDeViagem,String status,Cliente cliente,PacoteDeViagem pacote) {
		this.dataReserva=dataReserva;
		this.dataDeViagem=dataDeViagem;
		this.status=status;
		this.cliente=cliente;
		this.pacote=pacote;
	}
	public Reserva() {
		// TODO Auto-generated constructor stub
	}
	public Reserva(Date dataReserva, String dataDeViagem, String status, int idReserva) {
		this.dataReserva=dataReserva;
		this.dataDeViagem=dataDeViagem;
		this.status=status;
		this.idReserva=idReserva;
	}
	public Date getDataReserva() {
		return dataReserva;
	}
	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}
	public String getDataDeViagem() {
		return dataDeViagem;
	}
	public void setDataDeViagem(String dataDeViagem) {
		this.dataDeViagem = dataDeViagem;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
