package br.crud.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



import br.com.crud.Factory.ConectionFactory;
import br.com.crud.model.Cliente;

public class ClienteDAO {

	public void CadastrarCliente(Cliente cliente) {
		Connection conn = null;
		PreparedStatement pstm = null;
		PreparedStatement ClientePstm=null;
		String sql = "insert into cliente(Nome,Telefone,DataNascimento,Cep,Email,Senha) values(?,?,?,?,?,?)";
		String ClienteQuery="select count(*) from cliente where nome =?";
		try {
			conn = ConectionFactory.conectar();
			ClientePstm=conn.prepareStatement(ClienteQuery);
			ClientePstm.setString(1, cliente.getNome());
			ResultSet CliResultset=ClientePstm.executeQuery();
			if(CliResultset.next() && CliResultset.getInt(1)>0) {
				System.out.println("O Nome de Usuário é inválido, escolha outro");
				return;
			}
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getTelefone());
			pstm.setString(3, cliente.getDatanascimento());
			pstm.setString(4, cliente.getCep());
			pstm.setString(5, cliente.getEmail());
			pstm.setString(6, cliente.getSenha());
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstm != null) {
					pstm.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void removerPorId(Cliente cliente) {
		// resolvi usar o email e a senha por que a classe cliente também utiliza esse método ,evitando que um cliente  delete outro acidentalmente utilizando apenas o id
		String sql1="delete from reserva where Cliente_idCliente=?";
		String sql2="delete from contato where Cliente_idcliente=?";
		String sql = "delete from cliente where idCliente=? and senha=? and email=?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		PreparedStatement pstm1 = null;
		PreparedStatement pstm2 = null;
		try {
			conn = ConectionFactory.conectar();
			pstm1 = conn.prepareStatement(sql1);
			pstm1.setInt(1, cliente.getIdCliente());
			pstm1.execute();
			
			pstm2=conn.prepareStatement(sql2);
			pstm2.setInt(1, cliente.getIdCliente());
			pstm2.execute();
			
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, cliente.getIdCliente());
			pstm.setString(2, cliente.getSenha());
			pstm.setString(3, cliente.getEmail());
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (pstm1 != null) {
					pstm1.close();
				}
				if (pstm2 != null) {
					pstm2.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void atualizarCliente(Cliente cliente) {

		Connection conn = null;
		PreparedStatement pstm = null;
		String sql = "update cliente set Nome=?,Telefone=?,DataNascimento=?,Cep=?,email=?,Senha=?   where idCliente=?";
		try {
			conn = ConectionFactory.conectar();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getTelefone());
			pstm.setString(3, cliente.getDatanascimento());
			pstm.setString(4, cliente.getCep());
			pstm.setString(5, cliente.getEmail());
			pstm.setString(6, cliente.getSenha());
			pstm.setInt(7, cliente.getIdCliente());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstm != null) {
					pstm.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public List<Cliente> listarClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		String sql = "select * from cliente";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset=null;
		try {
			conn=ConectionFactory.conectar();
			pstm=conn.prepareStatement(sql);
			rset=pstm.executeQuery();
			while(rset.next()) {
				Cliente cliente= new Cliente();
				cliente.setNome(rset.getString("Nome"));
				cliente.setTelefone(rset.getString("Telefone"));
				cliente.setDatanascimento(rset.getString("Datanascimento"));
				cliente.setCep(rset.getString("Cep"));
				cliente.setEmail(rset.getString("Email"));
				cliente.setSenha(rset.getString("Senha"));
				clientes.add(cliente);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return clientes;
	}
}