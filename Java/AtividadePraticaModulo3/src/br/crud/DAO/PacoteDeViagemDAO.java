package br.crud.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.Factory.ConectionFactory;
import br.com.crud.model.PacoteDeViagem;

public class PacoteDeViagemDAO {
public void cadastrarPacote(PacoteDeViagem pacoteDeViagem) {
	Connection conn=null;
	PreparedStatement pstm=null;
	String sql="insert into pacotedeviagem (Destino,Descricao,DuracaoEmDias,Preco)values(?,?,?,?)";
	try {
		conn=ConectionFactory.conectar();
		pstm=conn.prepareStatement(sql);
		pstm.setString(1, pacoteDeViagem.getDestino());
		pstm.setString(2, pacoteDeViagem.getDescricao());
		pstm.setInt(3, pacoteDeViagem.getDuracaoEmDias());
		pstm.setDouble(4, pacoteDeViagem.getPreco());
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
public void deletarPacote(int idPacote) {
	String sql1="delete from reserva where PacoteDeViagem_idPacote=?";
	String sql2="delete from pacotedeviagem where idPacote=?";
	Connection conn= null;
	PreparedStatement pstm1=null;
	PreparedStatement pstm2=null;
	try {
		conn=ConectionFactory.conectar();
		pstm1=conn.prepareStatement(sql1);
		pstm1.setInt(1, idPacote);
		pstm1.execute();
		
		pstm2=conn.prepareStatement(sql2);
		pstm2.setInt(1, idPacote);
		pstm2.execute();
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(conn!=null) {
				conn.close();
			}
			if(pstm1!=null) {
				pstm1.close();
			}
			if(pstm2!=null) {
				pstm2.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
public void atualizarPacote(PacoteDeViagem pacoteDeViagem ) {

	String sql="update pacotedeviagem set Destino=?,Descricao=?,DuracaoEmDias=?, Preco=? where idPacote=?";
	Connection conn=null;
	PreparedStatement pstm=null;
	try {
		conn=ConectionFactory.conectar();
		pstm=conn.prepareStatement(sql);
		pstm.setString(1, pacoteDeViagem.getDestino());
		pstm.setString(2, pacoteDeViagem.getDescricao());
		pstm.setInt(3, pacoteDeViagem.getDuracaoEmDias());
		pstm.setDouble(4, pacoteDeViagem.getPreco());
		pstm.setInt(5,pacoteDeViagem.getIdPacote());
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
			// TODO: handle exception
		}
	}
}
public List<PacoteDeViagem> listarPacotes(){
	List<PacoteDeViagem> pacotesDeViagem=new ArrayList<PacoteDeViagem>();
	String sql="select * from pacotedeviagem";
	Connection conn=null;
	PreparedStatement pstm=null;
	ResultSet rset=null;
	int cont=0;
	try {
		conn=ConectionFactory.conectar();
		pstm=conn.prepareStatement(sql);
		rset=pstm.executeQuery();
		while(rset.next()) {
			cont++;
			PacoteDeViagem pacoteDeViagem=new PacoteDeViagem();
		pacoteDeViagem.setDescricao(rset.getString("Descricao"));
		pacoteDeViagem.setDestino(rset.getString("Destino"));
		pacoteDeViagem.setPreco(rset.getFloat("Preco"));
		pacoteDeViagem.setDuracaoEmDias(rset.getInt("DuracaoEmDias"));
		pacoteDeViagem.setIdPacote(rset.getInt("idPacote"));
		pacotesDeViagem.add(pacoteDeViagem);
		}
		System.out.println("Numero de pacotes de sua empresa "+cont);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return pacotesDeViagem;
}
}

