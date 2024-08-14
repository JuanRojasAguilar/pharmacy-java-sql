package com.pharmacy.country.infraestructure.repository;

import com.pharmacy.country.domain.entity.Country;
import com.pharmacy.country.domain.service.CountryService;
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

public class CountryRepository implements CountryService {
  private Connection connection;

  public CountryRepository() {
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
  public void add(Country country) {
    String sql = "INSERT INTO countries (name) VALUES (?)";

    try {
      PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
      statement.setString(1, country.getName());
      statement.executeUpdate();

      try (ResultSet generatedKey = statement.getGeneratedKeys()) {
        if (generatedKey.next()) {
          country.setId(generatedKey.getInt(1));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Optional<Country> findById(int id) {
    String sql = "SELECT * FROM countries WHERE id_country = ?";
    try {
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setInt(1, id);
      try (ResultSet result = statement.executeQuery(sql)) {
        Country country = new Country();
        country.setId(result.getInt("id_country"));
        country.setName(result.getString("name"));
        return Optional.of(country);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }

  @Override
  public Optional<List<Country>> showAllInstances() {
    List<Country> countries = new ArrayList<>();
    String sql = "SELECT * FROM countries";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
      ResultSet result = statement.executeQuery(sql);
      while (result.next()) {
        Country resultCountry = new Country();
        resultCountry.setId(result.getInt("id_country"));
        resultCountry.setName(result.getString("name"));
        countries.add(resultCountry);
      }
      return Optional.of(countries);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }

  @Override
  public void update(Country country) {
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
