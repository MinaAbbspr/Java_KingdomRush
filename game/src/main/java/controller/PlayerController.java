package controller;

import model.Backpack;
import model.Player;
import model.spell.Bomb;
import model.spell.Coin;
import model.spell.Freeze;
import model.spell.Heart;

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

    public Player getPlayer() {
        return player;
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

        player = new Player(resultSet.getInt("ID"),username,password,resultSet.getInt("level"),resultSet.getLong("diamond"),
                new Backpack(resultSet.getInt("health"),resultSet.getInt("freeze"),resultSet.getInt("coin"),resultSet.getInt("littleBoy")));
    }

    public void Signup(String username, String password, String checkPassword) throws Exception {
        if(username.isEmpty() || password.isEmpty() || checkPassword.isEmpty())
            throw new NullPointerException("No Text Field should not be Empty");

        String sqlCmd = String.format("SELECT ID FROM player WHERE username = '%s'",username);
        ResultSet resultSet = SQLConnection.getSqlConnection().executeSelect(sqlCmd);
        if(resultSet != null && resultSet.next())
            throw new Exception("This username already exist");

        if(! password.equals(checkPassword))
            throw new Exception("Enter the password again");

        String innerCmd = String.format("INSERT INTO player (ID,username,password) VALUES (%s,'%s','%s')",getMaxID()+1, username, password);
        SQLConnection.getSqlConnection().execute(innerCmd);
        player = new Player(getMaxID(),username,password,0,0,new Backpack(0,0,0,0));
    }

    private int getMaxID() throws SQLException {
        String select = "SELECT MAX(ID) from programmers";
        ResultSet resultSet = SQLConnection.getSqlConnection().executeSelect(select);

        if (resultSet!= null && resultSet.next())
            return resultSet.getInt("MAX(ID)");
        return 0;
    }

    public void save(){
        String innerCmd = String.format("UPDATE player SET username = '%s', password = '%s', level = %s, diamond = %s, health = %s, freeze = %s, coin = %s, littleBoy = %s WHERE ID = %s",
                player.getUsername(),player.getPassword(),player.getLevel(),player.getDiamond(),player.getBackpack().getHealth(),
                player.getBackpack().getFreeze(),player.getBackpack().getCoin(),player.getBackpack().getLittleBoy(),player.getID());
        SQLConnection.getSqlConnection().execute(innerCmd);
    }

    public void checkChanges(String username, String password) throws Exception {
        if(!username.equals(player.getUsername())){
            String sqlCmd = String.format("SELECT * FROM player WHERE username = '%s'",username);
            ResultSet resultSet = SQLConnection.getSqlConnection().executeSelect(sqlCmd);
            if(resultSet != null && resultSet.next())
                throw new Exception("This username already exist");
            else
                player.setUsername(username);
        }
        else
            player.setPassword(password);
    }

    public void buy(String spell) throws Exception {
        switch (spell){
            case "health" ->{
                Heart heart = new Heart();
                if(player.getDiamond() < heart.getPrice())
                    throw new Exception();

                player.setDiamond(player.getDiamond() - heart.getPrice());
                player.getBackpack().addHealth();
            }
            case "coin" ->{
                Coin coin = new Coin();
                if(player.getDiamond() < coin.getPrice())
                    throw new Exception();

                player.setDiamond(player.getDiamond() - coin.getPrice());
                player.getBackpack().addCoin();
            }
            case "littleBoy" ->{
                Bomb bomb = new Bomb();
                if(player.getDiamond() < bomb.getPrice())
                    throw new Exception();

                player.setDiamond(player.getDiamond() - bomb.getPrice());
                player.getBackpack().addLittleBoy();
            }
            case "freeze" -> {
                Freeze freeze = new Freeze();
                if(player.getDiamond() < freeze.getPrice())
                    throw new Exception();

                player.setDiamond(player.getDiamond() - freeze.getPrice());
                player.getBackpack().addFreeze();
            }
        }
    }
}
