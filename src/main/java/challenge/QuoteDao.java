package challenge;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuoteDao {

    private Connection con;

    public Quote getQuote() throws SQLException {
        String sql = "SELECT actor, detail FROM scripts WHERE type = 'Dialogue' AND actor IS NOT NULL ORDER BY RANDOM() LIMIT 1";

        try {
            con = ConnectionFactory.createConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            // criando objeto quote
            Quote quote = new Quote();
            quote.setActor(result.getString("actor"));
            quote.setQuote(result.getString("detail"));

            return quote;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close();
        }
    }

    public Quote getQuoteByActor(String actor) throws SQLException {
        String sql = "SELECT actor, detail FROM scripts WHERE type = 'Dialogue' AND actor = ? ORDER BY RANDOM() LIMIT 1";

        try {
            con = ConnectionFactory.createConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, actor);
            ResultSet result = stmt.executeQuery();

            // criando objeto quote
            Quote quote = new Quote();
            quote.setActor(result.getString("actor"));
            quote.setQuote(result.getString("detail"));

            return quote;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close();
        }
    }

}
