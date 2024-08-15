package com.pharmacy.laboratory.infraestructure.repository;

import com.pharmacy.laboratory.domain.entity.Laboratory;
import com.pharmacy.laboratory.domain.service.LaboratoryService;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.Properties;
import java.util.ArrayList;
import java.util.List;

public class LaboratoryRepository implements LaboratoryService {
  private Connection connection;

  public LaboratoryRepository() {
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
  public void add(Laboratory laboratory) {
    String sql = "INSERT INTO countries (name) VALUES (?)";

    try {
      PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
      statement.setString(1, laboratory.getName());
      statement.executeUpdate();

      try (ResultSet generatedKey = statement.getGeneratedKeys()) {
        if (generatedKey.next()) {
          laboratory.setId(generatedKey.getInt(1));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Optional<Laboratory> findById(int id) {
    String sql = "SELECT * FROM countries WHERE id_laboratory = ?";
    try {
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setInt(1, id);
      try (ResultSet result = statement.executeQuery(sql)) {
        Laboratory laboratory = new Laboratory();
        laboratory.setId(result.getInt("id_laboratory"));
        laboratory.setName(result.getString("name"));
        return Optional.of(laboratory);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }

  @Override
  public Optional<List<Laboratory>> showAllInstances() {
    List<Laboratory> countries = new ArrayList<>();
    String sql = "SELECT * FROM countries";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
      ResultSet result = statement.executeQuery(sql);
      while (result.next()) {
        Laboratory resultLaboratory = new Laboratory();
        resultLaboratory.setId(result.getInt("id_laboratory"));
        resultLaboratory.setName(result.getString("name"));
        countries.add(resultLaboratory);
      }
      return Optional.of(countries);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }

  @Override
  public void update(Laboratory laboratory) {
    String sql = "UPDATE countries SET name = ? WHERE id = ?";
    try {
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, laboratory.getName());
      statement.setInt(2, laboratory.getId());
      statement.executeUpdate(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
