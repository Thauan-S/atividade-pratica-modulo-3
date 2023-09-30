package br.crud.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.Factory.ConectionFactory;
import br.com.crud.model.Cliente;
import br.com.crud.model.PacoteDeViagem;
import br.com.crud.model.Reserva;

public class ReservaDAO {
	public void cadastrarReserva(Reserva reserva) {
		String sql="insert into reserva(Status,DataReserva,DataViagem,Cliente_idCliente,PacoteDeViagem_idPacote) values(?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstm=null;
		try {
			conn=ConectionFactory.conectar();
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, reserva.getStatus());
			pstm.setDate(2,new Date(reserva.getDataReserva().getTime()));
			pstm.setString(3, reserva.getDataDeViagem());
			pstm.setInt(4,reserva.getCliente().getIdCliente() );
			pstm.setInt(5, reserva.getPacote().getIdPacote());
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstm!=null) {
					pstm.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public void cancelarReserva(int idReserva) {
		String sql = "delete from reserva where idReserva=?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn=ConectionFactory.conectar();
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, idReserva);
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstm!=null) {
					pstm.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public void atualizarReserva(Reserva reserva) {
		String sql = "update  reserva set Status=?,DataReserva=?,DataViagem=? where idReserva=?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn=ConectionFactory.conectar();
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, reserva.getStatus());
			pstm.setDate(2,new Date( reserva.getDataReserva().getTime()));
			pstm.setString(3, reserva.getDataDeViagem());
			pstm.setInt(4, reserva.getIdReserva());
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Reserva> listarReservas(){
		List<Reserva>reservas=new ArrayList<Reserva>();
		String sql = "select status,datareserva,dataviagem,Cliente_idCliente,cliente.nome,pacotedeviagem.destino from reserva\r\n"
				+ " join cliente on cliente.idCliente = reserva.Cliente_idCliente\r\n"
				+ " join pacotedeviagem on pacotedeviagem.idpacote=reserva.pacotedeviagem_idpacote";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset=null;
		int contador=0;
		try {
			conn=ConectionFactory.conectar();
			pstm=conn.prepareStatement(sql);
			rset=pstm.executeQuery();
			
			while(rset.next()) {
				contador++;
				Reserva reserva= new Reserva();
				Cliente cliente=new Cliente();
				PacoteDeViagem pacotedeviagem=new PacoteDeViagem();
				cliente.setIdCliente(rset.getInt("Cliente_idCliente"));
				cliente.setNome(rset.getString("nome"));
				reserva.setCliente(cliente);
				pacotedeviagem.setDestino(rset.getString("destino"));
				reserva.setPacote(pacotedeviagem);
				reserva.setStatus(rset.getString("Status"));
				reserva.setDataReserva(rset.getDate("DataReserva"));
				reserva.setDataDeViagem(rset.getString("DataViagem"));
				
			reservas.add(reserva);
			
			}
			System.out.println("Numero de reservas da sua empresa "+ contador);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstm!=null) {
					pstm.close();
				}
				if(rset!=null) {
					rset.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return reservas;
		
	}
}
