/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Interface.MovieInterface;
import Model.Movie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class MovieImp implements MovieInterface {

    static Connection con = null;

    @Override
    public int addMovie(Movie movie) {
        int n = 0;
        try {

            con = new DatabaseConnection().getConnection();
            String query = "insert into movie(id,image,title,genre,director,cast,duration,language"
                    + ",release_date,trailer_url,display,detail) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, movie.getId());
            ps.setString(2, movie.getImage());
            ps.setString(3, movie.getTitle());
            ps.setString(4, movie.getGenre());
            ps.setString(5, movie.getDirector());
            ps.setString(6, movie.getCast());
            ps.setString(7, movie.getDuration());
            ps.setString(8, movie.getLanguage());
            ps.setString(9, movie.getRelease_date());
            ps.setString(10, movie.getTrailer_url());
            ps.setString(11, movie.getDisplay());
            ps.setString(12, movie.getDetail());
            n = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public void updateMovie(Movie movie) {
        try {
            con = new DatabaseConnection().getConnection();
            String query = "update movie set image=?,title=?,genre=?,director=?,cast=?,duration=?,language=?"
                    + ",release_date=?,trailer_url=?,display=?,detail=? where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, movie.getImage());
            ps.setString(2, movie.getTitle());
            ps.setString(3, movie.getGenre());
            ps.setString(4, movie.getDirector());
            ps.setString(5, movie.getCast());
            ps.setString(6, movie.getDuration());
            ps.setString(7, movie.getLanguage());
            ps.setString(8, movie.getRelease_date());
            ps.setString(9, movie.getTrailer_url());
            ps.setString(10, movie.getDisplay());
            ps.setString(11, movie.getDetail());
            ps.setInt(12, movie.getId());

            ps.executeUpdate();
            con.close();
            logMessage("Updated Successful!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMovie(int id) {
        try {
            con = new DatabaseConnection().getConnection();
            String query = "delete from movie where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            con.close();
            logMessage("Deleted Successful!");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public List<Movie> getAllMovie() {
        List<Movie> list = new ArrayList<>();
        try {
            con = new DatabaseConnection().getConnection();
            String query = "select * from movie";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setImage(rs.getString("image"));
                movie.setTitle(rs.getString("title"));
                movie.setGenre(rs.getString("genre"));
                movie.setDirector(rs.getString("director"));
                movie.setCast(rs.getString("cast"));
                movie.setDuration(rs.getString("duration"));
                movie.setLanguage(rs.getString("language"));
                movie.setRelease_date(rs.getString("release_date"));
                movie.setTrailer_url(rs.getString("trailer_url"));
                movie.setDisplay(rs.getString("display"));
                movie.setDetail(rs.getString("detail"));

                list.add(movie);
            }
            rs.close();
            statement.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list.reversed();
    }

    @Override
    public Movie getMovie(int id) {
        Movie movie = null;
        try {
            con = new DatabaseConnection().getConnection();
            String query = "select * from movie where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            // Execute the query
            ResultSet rs = ps.executeQuery();  // Use executeQuery for SELECT statements
            
            while (rs.next()) {
                movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setImage(rs.getString("image"));
                movie.setTitle(rs.getString("title"));
                movie.setGenre(rs.getString("genre"));
                movie.setDirector(rs.getString("director"));
                movie.setCast(rs.getString("cast"));
                movie.setDuration(rs.getString("duration"));
                movie.setLanguage(rs.getString("language"));
                movie.setRelease_date(rs.getString("release_date"));
                movie.setTrailer_url(rs.getString("trailer_url"));
                movie.setDisplay(rs.getString("display"));
                movie.setDetail(rs.getString("detail"));
            }
            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movie;
    }

    @Override
    public void logMessage(String log) {

        JOptionPane.showMessageDialog(null, log, "", JOptionPane.INFORMATION_MESSAGE);
    }

}
