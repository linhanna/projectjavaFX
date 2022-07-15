package com.example.javafxproject.data;

import com.example.javafxproject.data.models.Admin;
import com.example.javafxproject.data.models.Book;

import java.sql.*;
import java.util.ArrayList;

public class DBConnection {
    private Connection connection;

    public static final String URL = "jdbc:mysql://localhost/bookmanagement";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";

    public DBConnection(){
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connect successfully!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Book> getBook(){
        ArrayList<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try {
            ResultSet results = connection.prepareStatement(sql).executeQuery();
            while (results.next()){
                Book fruit = new Book(
                        results.getInt("id"),
                        results.getString("name"),
                        results.getInt("quality"),
                        results.getFloat("price"),
                        results.getString("typebook"),
                        results.getString("image")
                                        );
                list.add(fruit);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    public void Add(Book pro){
        String sql = "INSERT INTO books (name, image, price, typebook, quality) VALUE ('"+ pro.name+"','"+ pro.image+"','"+ pro.price+"','"+ pro.typebook+"',"+ pro.quality+")";
        try {
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Update(Book pro){
        String sql = "UPDATE books SET name = '"+ pro.name +"', image = '"+ pro.image+"', price = '"+ pro.price+"', typebook = '"+ pro.typebook+"', quality = '"+ pro.quality+"' WHERE id = "+ pro.id;
        try {
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Delete(int id){
        String sql = "DELETE FROM books WHERE id = "+ id;
        try {
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //conect with database Admin
    public ArrayList<Admin> getAdmin() {
        ArrayList<Admin> admins = new ArrayList<>();
        try {
            var result = this.connection.prepareStatement("Select * from admin").executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String password = result.getString("password");
                System.out.println(id);
                System.out.println(name);
                System.out.println(password);
                admins.add(new Admin(id, name, password));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return admins;
    }
}
