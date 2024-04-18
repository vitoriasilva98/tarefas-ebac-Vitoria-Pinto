package br.com.vitoria.dao.jdbc;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConnectionFactory {

    private static Connection connection;

    private ConnectionFactory(Connection connection) {
        this.connection = connection;
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = initConnection();
        } else if (connection != null && connection.isClosed()) {
            connection = initConnection();
        }
        return connection;
    }

    private static Connection initConnection() {
        try {
            Map<String, String> credentials = databaseCredentials();

            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + credentials.get("schema"),
                    credentials.get("username"), credentials.get("password"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Map<String, String> databaseCredentials() {

        Map<String, String> credentials = new HashMap<>();

        try {
            Properties properties = new Properties();

            InputStream input = ConnectionFactory.class.getClassLoader().getResourceAsStream("config.properties"); // Selecionando o arquivo

            if (input == null) {
                throw new FileNotFoundException("O arquivo de configuração do banco não foi encontrado");
            }

            properties.load(input); // Leitura do arquivo

            if (properties.getProperty("BD_POSTGRE_USERNAME") == null ||
                    properties.getProperty("BD_POSTGRE_PASSWORD") == null
                    || properties.getProperty("BD_POSTGRE_SCHEMA") == null) {
                throw new RuntimeException("Existem divergências nas credenciais do banco de dados");
            }

            credentials.put("username", properties.getProperty("BD_POSTGRE_USERNAME"));
            credentials.put("password", properties.getProperty("BD_POSTGRE_PASSWORD"));
            credentials.put("schema", properties.getProperty("BD_POSTGRE_SCHEMA"));

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar  credenciais do banco de dados", e);
        }

        return credentials;
    }
}
