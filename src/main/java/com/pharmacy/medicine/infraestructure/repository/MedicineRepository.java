package com.pharmacy.medicine.infraestructure.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.pharmacy.medicine.domain.entity.Medicine;
import com.pharmacy.medicine.domain.service.MedicineService;

public class MedicineRepository implements MedicineService {
  private Connection connection;

  public MedicineRepository() {
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
  public void add(Medicine medicine) {
    String sql = "INSERT INTO countries (name) VALUES (?)";

    try {
      PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
      statement.setString(1, medicine.getName());
      statement.executeUpdate();

      try (ResultSet generatedKey = statement.getGeneratedKeys()) {
        if (generatedKey.next()) {
          medicine.setId(generatedKey.getInt(1));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Optional<Medicine> findById(int id) {
    String sql = "SELECT * FROM countries WHERE id_medicine = ?";
    try {
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setInt(1, id);
      try (ResultSet result = statement.executeQuery(sql)) {
        Medicine medicine = new Medicine();
        medicine.setId(result.getInt("id_medicine"));
        medicine.setName(result.getString("name"));
        return Optional.of(medicine);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }

  @Override
  public Optional<List<Medicine>> showAllInstances() {
    List<Medicine> countries = new ArrayList<>();
    String sql = "SELECT * FROM countries";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
      ResultSet result = statement.executeQuery(sql);
      while (result.next()) {
        Medicine resultmedicine = new Medicine();
        resultmedicine.setId(result.getInt("id_medicine"));
        resultmedicine.setName(result.getString("name"));
        countries.add(resultmedicine);
      }
      return Optional.of(countries);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }

  @Override
  public void update(Medicine medicine) {
    String sql = "UPDATE countries SET name = ? WHERE id = ?";
    try {
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, medicine.getName());
      statement.setInt(2, medicine.getId());
      statement.executeUpdate(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
