
import com.projectwork.coordinationgame.util.DBUtil;
 
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mohamad Hassan
 */
 
public class GameSessionDAO {
 
    //*******************************
    //SELECT an GameSession
    //*******************************
    public static GameSession searchGameSession (String gameSessionId) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM project_work.game_session WHERE game_session_id="+gameSessionId;
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsGS = DBUtil.dbExecuteQuery(selectStmt);
 
            //Send ResultSet to the getGameSessionFromResultSet method and get game session object
            GameSession gameSession = getGameSessionFromResultSet(rsGS);
 
            //Return game session object
            return gameSession;
        } catch (SQLException e) {
            System.out.println("While searching a game session with " + gameSessionId + " id, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }
 
    //Use ResultSet from DB as parameter and set GameSession Object's attributes and return game session object.
    private static GameSession getGameSessionFromResultSet(ResultSet rs) throws SQLException
    {
        GameSession gs = null;
        if (rs.next()) {
            gs = new GaneSession();
            gs.setGameSessionId(rs.getInt("game_session_id"));
            gs.setPlayerComment(rs.getString("player_comment"));
            gs.setFirstTime(rs.getBoolean("first_time"));
            gs.setStartLocalDateTime(new LocalDateTime(rs.getString("start_timestamp")));
            gs.setEndLocalDateTime(new LocalDateTime(rs.getString("end_timestamp")));
        }
        return gs;
    }
 
    //*******************************
    //SELECT GameSessions
    //*******************************
    public static List<GameSession> searchGameSessions () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM project_work.game_session";
 
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsGSs = DBUtil.dbExecuteQuery(selectStmt);
 
            //Send ResultSet to the getGameSessionList method and get game session objects
            ArrayList<GameSession> gsList = getGameSessionList(rsGSs);
 
            //Return game session objects
            return gsList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }
 
    //Select * from project_work.game_session operation
    private static ArrayList<GameSession> getGameSessionList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare an ArrayList which comprises of GameSession objects
        ArrayList<GameSession> gsList = new ArrayList();
 
        while (rs.next()) {
            gs = new GameSession();
            gs.setGameSessionId(rs.getInt("game_session_id"));
            gs.setPlayerComment(rs.getString("player_comment"));
            gs.setFirstTime(rs.getBoolean("first_time"));
            gs.setStartLocalDateTime(new LocalDateTime(rs.getString("start_timestamp")));
            gs.setEndLocalDateTime(new LocalDateTime(rs.getString("end_timestamp")));
            //Add game session to the ArrayList
            gsList.add(gs);
        }
        //return gsList (ArrayList of GameSession)
        return gsList;
    }
 
    //*************************************
    //DELETE a game session
    //*************************************
    public static void deleteGSWithId (String gsId) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "BEGIN\n" +
                        "   DELETE FROM project_work.game_session\n" +
                        "         WHERE game_session_id ="+ gsId +";\n" +
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
    //INSERT a game session
    //*************************************
    public static void insertGS (String playerComment, String firstTime, String startDateTime, String endDateTime) throws SQLException, ClassNotFoundException {
        //Declare an INSERT statement
        String updateStmt =
                "BEGIN\n" +
                        "INSERT INTO project_work.game_session\n" +
                        "(game_session_id, player_comment, first_time, start_timestamp, end_timestamp)\n" +
                        "VALUES\n" +
                        "(game_session_id.nextval, '"+playerComment+"', '"+firstTime+"','"+startDateTime+"','"+endDateTime+"'\n"+
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
