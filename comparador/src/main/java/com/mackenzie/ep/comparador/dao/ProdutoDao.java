package com.mackenzie.ep.comparador.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mackenzie.ep.comparador.model.Produto;
import com.mackenzie.ep.comparador.model.Produtos;

public class ProdutoDao extends GenericDao {
	public Produtos getProdutos(){
        String sql = "SELECT * FROM Produto";
        Produtos produtos = new Produtos();
        try{
            Connection con = super.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nome"));	
                produto.setDescricao(rs.getString("descricao"));
                produto.setValor(rs.getDouble("valor"));
                produtos.addProduto(produto);
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        return produtos;
	}
	
	public Produto getProduto(int idProduto){
        String sql = "SELECT * FROM Produto where idProduto = "+idProduto;
        Produto produto = new Produto();
        try{
            Connection con = super.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Boolean response = rs.next();
            if(!response){
            	return null;
            }
            produto.setIdProduto(rs.getInt("idProduto"));
            produto.setNome(rs.getString("nome"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setValor(rs.getDouble("valor"));
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        return produto;
	}
}
	
