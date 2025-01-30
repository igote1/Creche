package com.tads.creche.Repository;

import com.tads.creche.Model.Aluno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepositorio {

    Connection connection = BancoDados.getConnection();

    public List<Aluno> getAlunos(){
        List<Aluno> alunos = new ArrayList<>();

        String sql = "SELECT * FROM aluno";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Aluno aluno = new Aluno();
                aluno.setNome(resultSet.getString("nome"));
                aluno.setIdade(resultSet.getInt("idade"));
                aluno.setSerie(resultSet.getInt("serie"));

                alunos.add(aluno);
            }

        }catch (SQLException e){
            System.out.println("erro");;
        }

        return alunos;
    }

    public boolean delete(Aluno aluno) {
        String sql = "DELETE FROM aluno WHERE id = ?";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, aluno.getId());
            preparedStatement.execute();
            return true;

        } catch(Exception e) {
            e.printStackTrace();
            return false;
        } finally {

            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection!= null) connection.close();

            } catch(Exception e) {
                e.printStackTrace();
            }
        }

    }
    public boolean cadastrarAlunos(Aluno aluno){

        String sql = "INSERT INTO Aluno (nome, idade, serie)\n" +
                "VALUES (?,?,?);";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, aluno.getNome());
            preparedStatement.setInt(2, aluno.getIdade());
            preparedStatement.setInt(3, aluno.getSerie());

            preparedStatement.execute();
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    public boolean alterar(Aluno aluno) {
        String sql = "UPDATE aluno SET nome=?, idade=?, serie=? WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setInt(3, aluno.getSerie());
            stmt.setInt(4, aluno.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
}
