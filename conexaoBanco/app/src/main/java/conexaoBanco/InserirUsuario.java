package conexaoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InserirUsuario {
	public static void inserirUsuario(Connection conexao, String nome, String email) {
		String sql = "INSERT INTO usuarios (nome, email) VALUES (?, ?)";
		
		try ( PreparedStatement pstmt = conexao.prepareStatement(sql)) {
			pstmt.setString(1, nome);
			pstmt.setString(2, email);
			
			pstmt.executeUpdate();
			
			System.out.println("Usuário Inserido com sucesso");
		} catch (Exception e) {
			System.out.println("Erro ao inserir usuário" + e.getMessage());
		}
	}
}
