package br.com.crud.model;


import java.util.Date;
import java.util.Scanner;

import br.crud.DAO.ClienteDAO;
import br.crud.DAO.ContatoDAO;
import br.crud.DAO.ReservaDAO;

public class Cliente {
	private String nome;
	private String telefone;
	private String datanascimento;
	private String cep;
	private String email;
	private String senha;
	private int idCliente;
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public Cliente(String nome, String telefone, String datanascimento, String cep, String email,
			String senha) {
		this.nome=nome;
		this.telefone=telefone;
		this.datanascimento=datanascimento;
		this.cep=cep;
		this.email=email;
		this.senha=senha;
	}
	
	public Cliente(int idCliente) {
		this.idCliente=idCliente;
	}
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	 
	public int getIdCliente() {
		return idCliente;
	}
	public Cliente(String email,String senha, int idCliente) {
	
		this.email=email;
		this.senha=senha;
		this.idCliente=idCliente;
	}
	public Cliente(String nome, String telefone, String dataNascimento, String cep, String email) {
		this.nome=nome;
		this.telefone=telefone;
		this.datanascimento=dataNascimento;
		this.cep=cep;
		this.email=email;
	}
	public Cliente(String nome, String telefone, String dataNascimento, String cep, String email, String senha,
			int idCliente) {
		this.nome=nome;
		this.telefone=telefone;
		this.datanascimento=dataNascimento;
		this.cep=cep;
		this.email=email;
		this.senha=senha;
		this.idCliente=idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(String datanascimento) {
		this.datanascimento = datanascimento;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void enviarMensagem() {
		Scanner entrada=new Scanner(System.in);
		String assunto,mensagem;
		int idCliente;
		ContatoDAO contatodao=new ContatoDAO();
		System.out.println("Digite o Assunto ");
		assunto=entrada.nextLine();
		System.out.println("Digite A mensagem ");
		mensagem=entrada.nextLine();
		System.out.println("Digite seu numero de identificação");
		idCliente=entrada.nextInt();
		contatodao.inserirMensagem(new Contato(assunto,mensagem,new Cliente(idCliente) ));
	}
	
	public void cadastrar() {
		ClienteDAO clientedao=new ClienteDAO();
		String nome,telefone,dataNascimento,cep,senha,email;
		Scanner entrada=new Scanner(System.in);
		System.out.println("Digite o nome:  ");
		 nome=entrada.nextLine();
		System.out.println("Digite o telefone:  ");
		 telefone=entrada.nextLine();
		System.out.println("Digite a data nascimento:  ");
		 dataNascimento=entrada.nextLine();
		System.out.println("Digite o cep:   ");
		 cep=entrada.nextLine();
		System.out.println("Digite o email:   ");
		 email=entrada.nextLine();
		System.out.println("Digite a senha:  ");
		 senha=entrada.nextLine();
		
		clientedao.CadastrarCliente(new Cliente(nome,telefone,dataNascimento,cep,email,senha));
		
	}
	public void atualizarDados() {
		ClienteDAO clientedao=new ClienteDAO();
		Scanner entrada=new Scanner(System.in);
		System.out.println("Digite o nome:  ");
		String nome=entrada.nextLine();
		System.out.println("Digite o telefone:  ");
		String telefone=entrada.nextLine();
		System.out.println("Digite a data nascimento:  ");
		String datanascimento=entrada.nextLine();
		System.out.println("Digite o cep:   ");
		String cep=entrada.nextLine();
		System.out.println("Digite o email:   ");
		String email=entrada.nextLine();
		System.out.println("Digite a senha:  ");
		String senha=entrada.nextLine();
		System.out.println("Digite o id:  ");
		int id=entrada.nextInt();
		
		
		clientedao.atualizarCliente(new Cliente(nome,telefone,datanascimento,cep,email,senha, id));
		
	}
	public void excluirCadastro() {
		ClienteDAO clientedao=new ClienteDAO();
		Scanner entrada=new Scanner(System.in);
		System.out.println("Digite o email:  ");
		String email=entrada.nextLine();
		System.out.println("Digite a senha:  ");
		String senha=entrada.nextLine();
		System.out.println("Digite o seu id:  ");
		int id=entrada.nextInt();
		clientedao.removerPorId(new Cliente(email,senha,id));
	}
	public void criarReserva() {
		ReservaDAO reservadao=new ReservaDAO();
		
		Scanner entrada=new Scanner(System.in);
		String status;
		String dataViagem;
		int cliente_idCliente,pacoteDeViagem;
		
		System.out.println("Digite a data da Viagem");
		dataViagem=entrada.nextLine();
		System.out.println("Digite o status da Viagem");
		status=entrada.nextLine();
		System.out.println("Digite o seu numero de identificação");
		cliente_idCliente=entrada.nextInt();
		System.out.println("Digite o  numero de identificação do pacote");
		pacoteDeViagem=entrada.nextInt();
		Date dataReserva=new Date();
		System.out.println();
		reservadao.cadastrarReserva(new Reserva(dataReserva,dataViagem,status,new Cliente(cliente_idCliente),new PacoteDeViagem(pacoteDeViagem)) );
		
		
	}
	
}
