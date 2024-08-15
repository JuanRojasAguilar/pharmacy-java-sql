package com.pharmacy.customer.infraestructure.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.pharmacy.customer.domain.entity.CustomerDTO;
import com.pharmacy.customer.domain.service.CustomerService;

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
  public void add(CustomerDTO customer) {
    String sql = "INSERT INTO customers (first_name, last_name, id_city, email, birth_date, longitude, latitude) VALUES (?,?,?,?,?,?,?)";

    try {
      PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
      statement.setString(1, customer.getFirstName());
      statement.setString(2, customer.getLastName());
      statement.setInt(3, getIdCityFromName(customer.getCity()));
      statement.setString(4, customer.getEmail());
      statement.setDate(5, customer.getBirthDate());
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
  public Optional<CustomerDTO> findById(int id) {
    String sql = "SELECT c.id_customer, c.first_name, c.last_name, c.email, c.birth_date, ct.name, c.longitude, c.latitude " + 
      "FROM customers AS c " +
      "JOIN cities AS ct USING(id_city) " +
      "WHERE id_customer = ? ";

    try {
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setInt(1, id);
      try (ResultSet result = statement.executeQuery(sql)) {

        int idCustomer = result.getInt("c.id_customer");
        String firstName = result.getString("c.first_name");
        String lastName = result.getString("c.last_name");
        String email = result.getString("c.email");
        Date birthDate = result.getDate("c.birth_date");
        String cityName = result.getString("ct. name");
        double longitude = result.getDouble("c.longitude");
        double latitude = result.getDouble("c.latitude");

        CustomerDTO customer = new CustomerDTO(idCustomer, firstName, lastName, cityName, email, birthDate, longitude, latitude);
        return Optional.of(customer);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }

  @Override
  public Optional<List<CustomerDTO>> showAllInstances() {
    List<CustomerDTO> customers = new ArrayList<>();
    String sql = "SELECT * FROM customer";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
      ResultSet result = statement.executeQuery(sql);
      while (result.next()) {
        int idCustomer = result.getInt("c.id_customer");
        String firstName = result.getString("c.first_name");
        String lastName = result.getString("c.last_name");
        String email = result.getString("c.email");
        Date birthDate = result.getDate("c.birth_date");
        String cityName = result.getString("ct. name");
        double longitude = result.getDouble("c.longitude");
        double latitude = result.getDouble("c.latitude");

        CustomerDTO customer = new CustomerDTO(idCustomer, firstName, lastName, cityName, email, birthDate, longitude, latitude);

        customers.add(customer);
      }
      return Optional.of(customers);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }

  @Override
  public void update(CustomerDTO customer) {
    String sql = "UPDATE countries" + 
      "SET first_name = ?, last_name = ?, id_city = ?, email = ? , birth_date = ?, longitude = ?, latitude = ?" + 
      "WHERE id = ?";
    try {
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, customer.getFirstName());
      statement.setString(2, customer.getLastName());
      statement.setInt(3, getIdCityFromName(customer.getCity()));
      statement.setString(4, customer.getEmail());
      statement.setDate(5, customer.getBirthDate());
      statement.setDouble(6, customer.getLongitude());
      statement.setDouble(7, customer.getLatitude());
      statement.setInt(8, customer.getId());
      statement.executeUpdate(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(int id) {
    String sql = "DELETE FROM customers WHERE id_customer = ?";
    try {
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setInt(1, id);
      statement.executeUpdate(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private int getIdCityFromName(String cityName) {
    String sql = "SELECT DISTINCT id_city FROM cities WHERE name IN (?)";
    try {
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, cityName);
      ResultSet result = statement.executeQuery();
      return result.getInt("id_city");
    } catch (SQLException e) {
      e.printStackTrace();
      return 0;
    }
  }
}
