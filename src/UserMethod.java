import java.sql.*;

public class UserMethod implements UserDAO {

static Connection con;
static PreparedStatement ps;
static Statement statement;
public  static User user;
@Override
public User getUser(String username,String pass){
User u =new User();

try {
    con=MyConnectionProvider.getCon();
ps=con.prepareStatement("SELECT *from auth.users where UserName=? and Password = ?");
ps.setString(1,username);
ps.setString(2,pass);


    ResultSet rs= ps.executeQuery();
    if(rs.next()){
u.setUsername(rs.getString(1));
u.setPassword(rs.getString(2));
u.setMoney(rs.getInt(3));


    }





} catch (SQLException e) {
    e.printStackTrace();
}

        return u;
    }
    @Override
    public User getMONEY(String money){
    User u1=new User();

try{
    con=MyConnectionProvider.getCon();
statement=con.createStatement();
ResultSet resultSet=statement.executeQuery("select money from auth.users");
if(resultSet.next()) {
    u1.setMoney(resultSet.getInt(3));

}
} catch (SQLException e) {
    e.printStackTrace();
}
        return u1;
    }
}