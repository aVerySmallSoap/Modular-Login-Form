package Databases.LoginHandler;

import Databases.LoginHandler.Exceptions.NullInputException;
import Managers.Interfaces.IDatabaseUserRegistration;
import Managers.QueryManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRegistration implements IDatabaseUserRegistration {
    QueryManager queryManager;
    private int ID_counter;
    public UserRegistration(QueryManager QueryManager){
        this.queryManager = QueryManager;
        this.ID_counter = this.getLatestIDCount();
    }

    @Override
    public boolean RegisterUser(String Username, String Password) {
        try {
            if(Username.equals("") || Password.equals("")){
                throw new NullInputException();
            }else{
            ++ID_counter;
            PreparedStatement pt = queryManager.getDatabaseManagerConnection().prepareStatement(
                    "insert into logins (ID, user_name, pass_word) values (?,?,?)");
            pt.setInt(1, ID_counter);
            pt.setString(2, Username);
            pt.setString(3, Password);
            pt.executeUpdate();
            return true;
            }
        }catch (NullInputException e){
            System.out.println("Null input exception: invalid input as it is null.");
            return false;
        }catch (SQLException e){
            System.out.println("Something happened!\n" + e);
            return false;
        }
    }

    private int getLatestIDCount(){
        try{
            Statement st = queryManager.getDatabaseManagerConnection().createStatement();
            String getID = "select COUNT(distinct ID) from logins";
            ResultSet rs = st.executeQuery(getID);
            if(rs.next()) {
                return rs.getInt(1);
            }else {
                return 0;
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
