/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.FuncionarioDTO2;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Renata
 */
public class FuncionarioDAO2 {

    Connection conn;

    PreparedStatement ps;

    ResultSet rs;

    ArrayList<FuncionarioDTO2> lista = new ArrayList<>();

    public void CadastrarFuncionario(FuncionarioDTO2 objetodto) {
        String sql = "insert into funcionario(nome_funcionario,email_funcionario,endereco_funcionario)values(?,?,?)";
        conn = new ConexaoDAO2().conectabd();

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, objetodto.getNome_funcionario());
            ps.setString(2, objetodto.getEmail_funcionario());
            ps.setString(3, objetodto.getEndereco_funcionario());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "CADASTRAR FUNCIONARIO " + e.getMessage());

        }

    }

    public void alterarfuncionario(FuncionarioDTO2 objetodto) {
        String sql = "update funcionario set nome_funcionario = ?, email_funcionario = ?, endereco_funcionario = ? where codigo_funcionario = ?";
        conn = new ConexaoDAO2().conectabd();

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, objetodto.getNome_funcionario());
            ps.setString(2, objetodto.getEmail_funcionario());
            ps.setString(3, objetodto.getEndereco_funcionario());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ALTERAR FUNCIONARIO " + e.getMessage());
        }

    }

    public void excluirfuncionario(FuncionarioDTO2 objeto) {
        String sql = "delete from funcionario where codigo_funcionario = ?";
        conn = new ConexaoDAO2().conectabd();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, objeto.getCod_funcionario());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "EXCLUIR FUNCIONARIO " + e.getMessage());
        }

    }

    public ArrayList<FuncionarioDTO2> PesquisarFuncioario() {
        String sql = "select * from funcionario";
        conn = new ConexaoDAO2().conectabd();

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                FuncionarioDTO2 dto = new FuncionarioDTO2();
                dto.setCod_funcionario(rs.getInt("codigo_funcionario"));
                dto.setNome_funcionario(rs.getString("nome_funcionario"));
                dto.setEmail_funcionario(rs.getString("email_funcionario"));
                dto.setEndereco_funcionario(rs.getString("endereco_funcionario"));
                lista.add(dto);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Pesquisar funcionario " +e);
        }
        return lista;
    }

}
