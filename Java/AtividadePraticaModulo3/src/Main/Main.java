package Main;

import java.util.Date;
import java.util.Scanner;

import br.com.crud.model.Cliente;
import br.com.crud.model.Contato;
import br.com.crud.model.PacoteDeViagem;
import br.com.crud.model.Reserva;
import br.crud.DAO.ClienteDAO;
import br.crud.DAO.ContatoDAO;
import br.crud.DAO.PacoteDeViagemDAO;
import br.crud.DAO.ReservaDAO;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Cliente cliente = new Cliente();
		ClienteDAO clientedao = new ClienteDAO();
		ContatoDAO contatodao = new ContatoDAO();
		ReservaDAO reservadao = new ReservaDAO();
		PacoteDeViagemDAO pacotedao = new PacoteDeViagemDAO();

		int op;
		System.out.println("Escolha 1 para fazer o cadastro");
		System.out.println("Escolha 2 para excluir seu cadastro");
		System.out.println("Escolha 3 para atualizar os seus dados");
		System.out.println("Escolha 4 para  fazer uma reserva ");
		System.out.println("Escolha 5 para  enviar uma mensagem ");

		op = entrada.nextInt();

		// while para os métodos que os clientes podem fazer : cadastro , exclusão de
		// cadastro , atualização de seus dados ,reservas e enviar mensagens
		while (op != 0) {
			switch (op) {
			case 1:
				cliente.cadastrar();
				break;
			case 2:
				cliente.excluirCadastro();
				break;
			case 3:
				cliente.atualizarDados();
				break;
			case 4:
				cliente.criarReserva();
				break;
			case 5:
				cliente.enviarMensagem();
				;
				break;
			default:
				System.out.println("Escolha um numero valido");
			}

			System.out.println("Escolha 1 para fazer o cadastro");
			System.out.println("Escolha 2 para  excluir o cadastro");
			System.out.println("Escolha 3 para atualizar os seus dados");
			System.out.println("Escolha 4 para  fazer uma reserva ");
			System.out.println("Escolha 5 para  enviar uma  mensagem ");

			op = entrada.nextInt();
			entrada.nextLine();

		}

		// while para todos os metodos da classe clienteDAO
		System.out.println("Agora você está acessando os métodos do clienteDAO");
		System.out.println("Escolha 1 para fazer o cadastro");
		System.out.println("Escolha 2 para  deletar o cliente");
		System.out.println("Escolha 3 para  listar todos os clientes ");
		System.out.println("Escolha 4 para atualizar os  dados de um Cliente");

		op = entrada.nextInt();
		entrada.nextLine();
		while (op != 0) {
			switch (op) {
			case 1:
				String nome, telefone, dataNascimento, cep, email, senha;
				System.out.println("Digite o nome do cliente");
				nome = entrada.nextLine();
				System.out.println("Digite o telefone do cliente");
				telefone = entrada.nextLine();
				System.out.println("Digite a data de nascimento  do cliente");
				dataNascimento = entrada.nextLine();
				System.out.println("Digite o cep do cliente");
				cep = entrada.nextLine();
				System.out.println("Digite o email do cliente");
				email = entrada.nextLine();
				System.out.println("Digite a senha do cliente");
				senha = entrada.nextLine();
				clientedao.CadastrarCliente(new Cliente(nome, telefone, dataNascimento, cep, email, senha));
				break;
			case 2:
				int id;
				System.out.println("Digite o seu  id ");
				id = entrada.nextInt();
				entrada.nextLine();
				System.out.println("Digite seu email  ");
				email = entrada.nextLine();
				System.out.println("Digite a senha ");
				senha = entrada.nextLine();
				clientedao.removerPorId(new Cliente(email, senha, id));
				break;
			case 3:
				System.out.println("Lista dos clientes de sua empresa");
				for (Cliente c : clientedao.listarClientes()) {
					System.out.println("Nome :" + c.getNome());
					System.out.println("Telefone :" + c.getTelefone());
					System.out.println("Data de nascimento :" + c.getDatanascimento());
					System.out.println("Cep :" + c.getCep());
					System.out.println("Email :" + c.getEmail());
					System.out.println("Senha :" + c.getSenha());
					System.out.println("==================");
				}

				break;
			case 4:
				System.out.println("Digite o id do cliente que deseja alterar");
				id = entrada.nextInt();
				nome = entrada.nextLine();
				System.out.println("Digite o  novo nome do cliente");
				nome = entrada.nextLine();
				System.out.println("Digite o novo telefone do cliente");
				telefone = entrada.nextLine();
				System.out.println("Digite a  nova data de nascimento  do cliente");
				dataNascimento = entrada.nextLine();
				System.out.println("Digite o  novo cep do cliente");
				cep = entrada.nextLine();
				System.out.println("Digite o novo  email do cliente");
				email = entrada.nextLine();
				System.out.println("Digite a nova senha  do cliente");
				senha = entrada.nextLine();
				clientedao.atualizarCliente(new Cliente(nome, telefone, dataNascimento, cep, email, senha,id));
				break;
			default:
				throw new IllegalArgumentException("valor inválido: " + op);
			}
			System.out.println("Escolha 1 para fazer o cadastro");
			System.out.println("Escolha 2 para  deletar o cliente");
			System.out.println("Escolha 3 para  listar todos os clientes ");
			System.out.println("Escolha 4 para atualizar os  dados de um Cliente");
			op = entrada.nextInt();
			entrada.nextLine();
		}
		// while para classe ContatoDAO
		System.out.println("Agora você está acessando os métodos do ContatoDAO");
		System.out.println("Escolha 1 para inserir uma mensagem");
		System.out.println("Escolha 2 para  deletar uma mensagem");
		System.out.println("Escolha 3 para  atualizar uma mensagem ");
		System.out.println("Escolha 4 para listar as mensagens recebidas");

		op = entrada.nextInt();
		entrada.nextLine();
		while (op != 0) {
			switch (op) {
			case 1:
				String assunto, mensagem;
				int idCliente;
				System.out.println("Digite o Assunto ");
				assunto = entrada.nextLine();
				System.out.println("Digite A mensagem ");
				mensagem = entrada.nextLine();
				System.out.println("Digite seu numero de identificação");
				idCliente = entrada.nextInt();
				contatodao.inserirMensagem(new Contato(assunto, mensagem, new Cliente(idCliente)));
				break;
			case 2:
				int idContato;
				System.out.println("Digite o id da mensagem que deseja apagar");
				idContato = entrada.nextInt();
				contatodao.apagarMensagem(new Contato (idContato));
				break;
			case 3:
				System.out.println("Digite o id da mensagem que deseja atualizar: ");
				idContato = entrada.nextInt();
				entrada.nextLine();
				System.out.println("Digite a nova  mensagem ");
				mensagem = entrada.nextLine();
				System.out.println("Digite o novo assunto da mensagem ");
				assunto = entrada.nextLine();
				contatodao.atualizarMensagem(new Contato(idContato,assunto,mensagem));
				break;
			case 4:
				System.out.println("Mensagens recebidas");
				for (Contato c : contatodao.listaMensagens()) {
					System.out.println("Id do contato :"+c.getIdContato());
					System.out.println("Nome do Cliente " + c.getCliente().getNome());
					System.out.println("Assunto :" + c.getAssunto());
					System.out.println("Mensagem :" + c.getMensagem());
					System.out.println("======================");
				}

				break;
			default:
				throw new IllegalArgumentException("valor inválido value: " + op);
			}

			System.out.println("Escolha 1 para inserir uma mensagem");
			System.out.println("Escolha 2 para  deletar uma mensagem");
			System.out.println("Escolha 3 para  atualizar uma mensagem ");
			System.out.println("Escolha 4 para listar as mensagens recebidas");
			op = entrada.nextInt();
			entrada.nextLine();
		}

		// while para ReservaDAO
		System.out.println("Agora você está acessando os métodos do reserva");
		System.out.println("Escolha 1 para criar uma reserva");
		System.out.println("Escolha 2 para  deletar uma reserva");
		System.out.println("Escolha 3 para  atualizar uma reserva ");
		System.out.println("Escolha 4 para listar as reservas de sua empresa");

		op = entrada.nextInt();
		entrada.nextLine();
		while (op != 0) {
			switch (op) {
			case 1:
				String status, dataViagem;
				int idCliente, idPacote;
				Date dataReserva;
				System.out.println("Digite o status da Reserva ");
				status = entrada.nextLine();
				System.out.println("Digite a data da viagem ");
				dataViagem = entrada.nextLine();
				System.out.println("Digite  o seu id  ");
				idCliente = entrada.nextInt();
				System.out.println("Digite o id do pacote de viagem  ");
				idPacote = entrada.nextInt();
				dataReserva = new Date();
				reservadao.cadastrarReserva(new Reserva(dataReserva,dataViagem,status,new Cliente(idCliente), new PacoteDeViagem(idPacote)));
				break;
			case 2:
				int idReserva;
				System.out.println("Digite o id da reserva que deseja cancelar");
				idReserva = entrada.nextInt();
				reservadao.cancelarReserva(idReserva);
				break;
			case 3:
				System.out.println("Digite  o id da Reserva  ");
				idReserva = entrada.nextInt();
				entrada.nextLine();
				System.out.println("Digite o status da Reserva ");
				status = entrada.nextLine();
				System.out.println("Digite a data da viagem ");
				dataViagem = entrada.nextLine();
				
				dataReserva = new Date();
				reservadao.atualizarReserva(new Reserva(dataReserva,dataViagem,status,idReserva));
				break;
			case 4:
				System.out.println("Reservas de sua empresa ");
				for (Reserva r : reservadao.listarReservas()) {
					System.out.println("Id do cliente : " + r.getCliente().getIdCliente());
					System.out.println("Nome do Cliente :"+ r.getCliente().getNome());
					System.out.println("Destino :" + r.getPacote().getDestino());
					System.out.println("Status da reserva :" + r.getStatus());
					System.out.println("Data que foi feita a reserva : " + r.getDataReserva());
					System.out.println("Data da viagem : " + r.getDataDeViagem());
					System.out.println("======================");
				}

				break;
			default:
				throw new IllegalArgumentException("valor inválido value: " + op);
			}
			System.out.println("Escolha 1 para criar uma reserva");
			System.out.println("Escolha 2 para  deletar uma reserva");
			System.out.println("Escolha 3 para  atualizar uma reserva ");
			System.out.println("Escolha 4 para listar as reservas de sua empresa");
			
			op = entrada.nextInt();
			entrada.nextLine();
		}
// while para Pacote de Viagem
		System.out.println("Agora você está acessando os métodos do pacote De viagem");
		System.out.println("Escolha 1 para criar um novo pacote de viagem");
		System.out.println("Escolha 2 para  deletar um pacote de viagem");
		System.out.println("Escolha 3 para  atualizar um pacote de viagem ");
		System.out.println("Escolha 4 para listar pacotes de viagem de sua empresa");

		op = entrada.nextInt();
		entrada.nextLine();
		while (op != 0) {
			switch (op) {
			case 1:

				String destino, descricao;
				int duracaoEmDias;
				Float preco;
				System.out.println("Digite o Destino ");
				destino = entrada.nextLine();
				System.out.println("Digite a descricâo ");
				descricao = entrada.nextLine();
				System.out.println("Digite a duração em dias ");
				duracaoEmDias = entrada.nextInt();
				System.out.println("Digite o preço do pacote   ");
				preco = entrada.nextFloat();
				pacotedao.cadastrarPacote(new PacoteDeViagem(destino, descricao, preco, duracaoEmDias));
				break;
			case 2:
				int idPacote;
				System.out.println("Digite o id do pacote que deseja excluir");
				idPacote = entrada.nextInt();
				pacotedao.deletarPacote(idPacote);
				break;
			case 3:
				System.out.println("Para atualizar o pacote :");
				System.out.println("Digite o id do pacote que deseja atualizar:   ");
				idPacote = entrada.nextInt();
				entrada.nextLine();
				System.out.println("Digite o  Destino ");
				destino = entrada.nextLine();
				System.out.println("Digite a descricâo ");
				descricao = entrada.nextLine();
				System.out.println("Digite a duração em dias ");
				duracaoEmDias = entrada.nextInt();
				System.out.println("Digite o preço do pacote   ");
				preco = entrada.nextFloat();

				pacotedao.atualizarPacote(new PacoteDeViagem(destino, descricao, preco, duracaoEmDias,idPacote));
				break;
			case 4:
				System.out.println("Pacotes  de sua empresa ");
				for (PacoteDeViagem p : pacotedao.listarPacotes()) {
					System.out.println("Id do Pacote : " + p.getIdPacote());
					System.out.println("Descrição :" + p.getDescricao());
					System.out.println("Destino : " + p.getDestino());
					System.out.println("Preço : " + p.getPreco());
					System.out.println("======================");
				}

				break;
			default:
				throw new IllegalArgumentException("valor inválido value: " + op);
			}
			System.out.println("Escolha 1 para criar um Pacote");
			System.out.println("Escolha 2 para  deletar um Pacote");
			System.out.println("Escolha 3 para  atualizar um Pacote ");
			System.out.println("Escolha 4 para listar os Pacotes de sua empresa");
			op = entrada.nextInt();
			entrada.nextLine();
		}

	}
}
