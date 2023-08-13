package com.cognizant.intermediate.apirestful.repository;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MySqlDummyJdbcRepository {
    private final DataSource dataSource;
    public MySqlDummyJdbcRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public void loadBooks() throws SQLException {
        Connection connection = dataSource.getConnection();
        Assert.notNull(connection, "Connection established for MySqlDummyJdbcRepository");
        String QUERY = """
                        insert into api_restful_db.book_records (id, book_name, author, price) 
                        values(2, "Ramayana V2", "Tulsidas", 10.23);
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.executeUpdate();
    }

    public void fetchBooks() throws SQLException {
       Connection connection = dataSource.getConnection();
       Assert.notNull(connection, "Connection established for MySqlDummyJdbcRepository");
       ResultSet resultSet = connection.prepareStatement("select * from api_restful_db.book_records").executeQuery();
       while(resultSet.next()){
            System.out.printf("Book[ID: %d, NAME: %s, AUTHOR: %s, PRICE:%.2f]\n", resultSet.getInt(1), resultSet.getString(2)
            , resultSet.getString(3), resultSet.getFloat(4));
       }

    }
}
