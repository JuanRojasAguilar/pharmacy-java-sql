package com.pharmacy.customer.infraestructure.repository;

import com.pharmacy.customer.domain.entity.Customer;
import com.pharmacy.customer.domain.service.CustomerService;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.Properties;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements CustomerService {
  private Connection connection;

  public CustomerRepository() {
    try {
      Properties props = new Properties();
      props.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
      String url = props.getProperty("url");
      String user = props.getProperty("user");
      String password = props.getProperty("password");
      connection = DriverManager.getConnection(url, user, password);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void add(Customer customer) {
    String sql = "INSERT INTO customers (first_name, last_name, id_city, email, birth_date, longitude, latitude) VALUES (?,?,?,?,?,?,?)";

    try {
      PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
      statement.setString(1, customer.getFirstName());
      statement.setString(2, customer.getLastName());
      statement.setInt(3, customer.getIdCity());
      statement.setString(4, customer.getEmail());
      statement.setDate(5, customer.getSqlDate());
      statement.setDouble(6, customer.getLongitude());
      statement.setDouble(7, customer.getLatitude());
      statement.executeUpdate();

      try (ResultSet generatedKey = statement.getGeneratedKeys()) {
        if (generatedKey.next()) {
          customer.setId(generatedKey.getInt(1));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Optional<Customer> findById(int id) {
    String sql = "SELECT * FROM customers WHERE id_customer = ?";
    try {
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setInt(1, id);
      try (ResultSet result = statement.executeQuery(sql)) {

        int idCustomer = result.getInt("id_customer");
        String firstName = result.getString("first_name");
        String lastName = result.getString("last_name");
        String email = result.getString("email");
        Date birthDate = result.getDate("birth_date");
        double longitude = result.getDouble("longitude");
        double latitude = result.getDouble("latitude");

        Customer customer = new Customer(idCustomer, firstName, lastName, email, birthDate, longitude, latitude);
        return Optional.of(customer);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }

  @Override
  public Optional<List<Customer>> showAllInstances() {
    List<Customer> customers = new ArrayList<>();
    String sql = "SELECT * FROM customer";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
      ResultSet result = statement.executeQuery(sql);
      while (result.next()) {
int idCustomer = result.getInt("id_customer");
        String firstName = result.getString("first_name");
        String lastName = result.getString("last_name");
        String email = result.getString("email");
        Date birthDate = result.getDate("birth_date");
        double longitude = result.getDouble("longitude");
        double latitude = result.getDouble("latitude");

        Customer customer = new Customer(idCustomer, firstName, lastName, email, birthDate, longitude, latitude);
        customers.add(customer)
      }
      return Optional.of(customers);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }

  @Override
  public void update(Customer customer) {
    String sql = "UPDATE countries SET name = ? WHERE id = ?";
    try {
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, country.getName());
      statement.setInt(2, country.getId());
      statement.executeUpdate(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
