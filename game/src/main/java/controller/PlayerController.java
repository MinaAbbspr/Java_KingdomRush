package controller;

import model.Player;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerController {

    private static PlayerController playerController;
    private Player player;

    public static PlayerController getPlayerController() {
        if(playerController == null)
            playerController = new PlayerController();
        return playerController;
    }

    public void Login(String username, String password) throws Exception {
        if(username.isEmpty() || password.isEmpty()){
            throw new NullPointerException("No Text Field should not be Empty");
        }

        String sqlCmd = String.format("SELECT * FROM player WHERE username = '%s'",username);
        ResultSet resultSet = SQLConnection.getSqlConnection().executeSelect(sqlCmd);
        if(resultSet == null)
            throw new Exception("username is not valid");

        resultSet.next();
        if(!resultSet.getString("password").equals(password))
            throw new Exception("password is not valid");

        player = new Player(resultSet.getInt("ID"),username,password,resultSet.getInt("level"),resultSet.getLong("diamond"));
    }

    public void Signup(String username, String password, String checkPassword) throws Exception {
        if(username.isEmpty() || password.isEmpty() || checkPassword.isEmpty())
            throw new NullPointerException("No Text Field should not be Empty");

        String sqlCmd = String.format("SELECT * FROM player WHERE username = '%s'",username);
        ResultSet resultSet = SQLConnection.getSqlConnection().executeSelect(sqlCmd);
        if(resultSet == null ||  !resultSet.next())
            throw new Exception("This username already exist");

        if(! password.equals(checkPassword))
            throw new Exception("Enter the password again");

        String innerCmd = String.format("INSERT INTO player (ID,username,password) VALUES (%s,'%s','%s')",getMaxID()+1, username, password);
        SQLConnection.getSqlConnection().execute(innerCmd);
        player = new Player(getMaxID(),username,password,0,0);
    }

    private int getMaxID() throws SQLException {
        String select = "SELECT MAX(ID) from programmers";
        ResultSet resultSet = SQLConnection.getSqlConnection().executeSelect(select);

        if (resultSet.next())
            return resultSet.getInt("MAX(ID)");
        return 0;
    }
}
