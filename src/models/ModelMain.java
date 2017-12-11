package models;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author Briceyda Angeles
 */
public class ModelMain {
    private Connection sql_connection;
    private Statement sql_statement;
    private PreparedStatement sql_prepared_statement;
    private ResultSet sql_result_set;
    private String sql;
    
    private MessageDigest md5;
    private StringBuilder string_builder;
    
}


