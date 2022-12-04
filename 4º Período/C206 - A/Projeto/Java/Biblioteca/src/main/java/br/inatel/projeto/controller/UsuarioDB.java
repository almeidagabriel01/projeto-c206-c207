package br.inatel.projeto.controller;

import br.inatel.projeto.model.Usuario;

import java.sql.SQLException;

public class UsuarioDB extends Database{
    public static boolean insertUsuario(Usuario user) {
        boolean check = false;
        connect();
        String sql = "INSERT INTO Usuario (cpf, nomeCompleto, idade, celular) VALUES (?, ?, ?, ?);";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, user.getCpf());
            pst.setString(2, user.getNomeCompleto());
            pst.setInt(3, user.getIdade());
            pst.setString(4, user.getCelular());
            pst.execute();
            check = true;
        } catch (SQLException error) {
            System.out.println("Operation Error: " + error.getMessage());
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException error) {
                System.out.println("Connection Closure Error: " + error.getMessage());
            }
        }
        return check;
    }

    public static int selectIdUsuario(String cpf) {
        connect();
        String sql = "SELECT idUsuario FROM Usuario WHERE cpf ='" + cpf + "';";
        int resultado = -1;
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                resultado = result.getInt("idUsuario");
            }
        } catch (SQLException error) {
            System.out.println("Operation Error: " + error.getMessage());
        } finally {
            try {
                connection.close();
                statement.close();
                result.close();
            } catch (SQLException error) {
                System.out.println("Connection Closure Error: " + error.getMessage());
            }
        }
        return resultado;
    }

    public static String selectCPF(String nomeCompleto) {
        connect();
        String sql = "SELECT cpf FROM Usuario WHERE nomeCompleto ='" + nomeCompleto + "';";
        String nome = "";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                System.out.println(result.getString("nomeCompleto"));
                System.out.println("--------------------");
                nome = result.getString("nomeCompleto");
            }
        } catch (SQLException error) {
            System.out.println("Operation Error: " + error.getMessage());
        } finally {
            try {
                connection.close();
                statement.close();
                result.close();
            } catch (SQLException error) {
                System.out.println("Connection Closure Error: " + error.getMessage());
            }
        }
        return nome;
    }

    public static boolean updateUsuario(String cpf, String nomeCompleto, int idade, int celular) {
        boolean check = false;
        connect();
        String sql = "UPDATE Usuario SET cpf = ?, nomeCompleto = ?, idade = ?, celular = ? WHERE cpf = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, cpf);
            pst.setString(2, nomeCompleto);
            pst.setInt(3, idade);
            pst.setInt(4, celular);
            pst.setString(5, cpf);
            pst.execute();
            check = true;
        } catch (SQLException error) {
            System.out.println("Operation Error: " + error.getMessage());
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException error) {
                System.out.println("Connection Closure Error: " + error.getMessage());
            }
        }
        return check;
    }

    public static boolean deleteUsuário(String cpf) {
        boolean check = false;
        connect();
        String sql = "DELETE FROM Usuario WHERE cpf = ?;";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, cpf);
            pst.execute();
            check = true;
        } catch (SQLException error) {
            System.out.println("Operation Error: " + error.getMessage());
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException error) {
                System.out.println("Connection Closure Error: " + error.getMessage());
            }
        }
        return check;
    }
}
