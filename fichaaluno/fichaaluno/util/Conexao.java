package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static final String URL =
        "jdbc:mysql://localhost:3306/matriculaaluno";

    private static final String USUARIO =
        "root";

    private static final String SENHA =
        "1213Clau!";

    public static Connection conectar() {

        Connection conn = null;

        try {

            Class.forName(
                "com.mysql.cj.jdbc.Driver"
            );

            conn = DriverManager.getConnection(
                URL,
                USUARIO,
                SENHA
            );

            System.out.println(
                "Conexão realizada com sucesso!"
            );

        } catch (Exception e) {

            System.out.println(
                "Erro na conexão: " + e.getMessage()
            );
        }

        return conn;
    }
}