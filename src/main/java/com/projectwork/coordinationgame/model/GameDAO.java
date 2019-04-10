
import com.projectwork.coordinationgame.model.Game;
import com.projectwork.coordinationgame.model.GameSession;
import com.projectwork.coordinationgame.util.DBUtil;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 
public class GameDAO {
 
    //*******************************
    //SELECT a Game
    //*******************************
    public static Game searchGame (String gameId) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM project_work.game WHERE game_id="+gameId;
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsGS = DBUtil.dbExecuteQuery(selectStmt);
 
            //Send ResultSet to the getGameFromResultSet method and get game session object
            Game game = getGameFromResultSet(rsG);
 
            //Return game object
            return game;
        } catch (SQLException e) {
            System.out.println("While searching a game with " + gameId + " id, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }
 
    //Use ResultSet from DB as parameter and set Game Object's attributes and return game object.
    private static Game getGameFromResultSet(ResultSet rs) throws SQLException
    {
        Game g = null;
        if (rs.next()) {
            g = new Game();
            g.setId(rs.getInt("game_id"));
            g.setGameDataObject(rs.getString("gamedata"));
        }
        return g;
    }
 
    //*******************************
    //SELECT Games
    //*******************************
    public static List<Game> searchGames () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM project_work.game";
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsGs = DBUtil.dbExecuteQuery(selectStmt);
 
            //Send ResultSet to the getGameSessionList method and get game session objects
            ArrayList<Game> gList = getGameList(rsGs);
 
            //Return game objects
            return gList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }
 
    //Select * from project_work.game operation
    private static ArrayList<GameSession> getGameList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare an ArrayList which comprises of Game objects
        ArrayList<Game> gList = new ArrayList();
 
        while (rs.next()) {
            g = new Game();
            g.setId(rs.getInt("game_id"));
            g.setGameDataObject(rs.getString("gamedata"));
            //Add game to the ArrayList
            gList.add(gs);
        }
        //return gList (ArrayList of Games)
        return gList;
    }
 
    //*************************************
    //DELETE a game session
    //*************************************
    public static void deleteGameWithId (String gId) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "BEGIN\n" +
                        "   DELETE FROM project_work.game\n" +
                        "         WHERE game_id ="+ gId +";\n" +
                        "   COMMIT;\n" +
                        "END;";
 
        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }
 
    //*************************************
    //INSERT a game
    //*************************************
    public static void insertGame (String gameDataObject) throws SQLException, ClassNotFoundException {
        //Declare an INSERT statement
        String updateStmt =
                "BEGIN\n" +
                        "INSERT INTO project_work.game\n" +
                        "(game_id, gamedata)\n" +
                        "VALUES\n" +
                        "(game_id.nextval, '"+gameDataObject+"'\n"+
                        "END;";
 
        //Execute INSERT operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while INSERT Operation: " + e);
            throw e;
        }
    }
}
