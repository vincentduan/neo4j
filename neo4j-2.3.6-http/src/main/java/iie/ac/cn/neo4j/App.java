package iie.ac.cn.neo4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/*import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Config;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Values;
*/
/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws SQLException {
		/*Driver driver = GraphDatabase.driver("bolt://localhost", AuthTokens.basic("neo4j", "123456"));
		Session session = driver.session();
		session.run("CREATE (a:Person {name:'Arthur', title:'King'})");
		StatementResult result = session
				.run("MATCH (a:Person) WHERE a.name = 'Arthur' RETURN a.name AS name, a.title AS title");
		while (result.hasNext()) {
			Record record = result.next();
			System.out.println(record.get("title").asString() + " "
					+ record.get("name").asString());
		}
		session.close();
		driver.close();*/
		
		/*Driver driver = GraphDatabase.driver("bolt://localhost:7687",AuthTokens.basic("neo4j", "123456"));
		try (Session session = driver.session()) {
		  StatementResult result = session.run( "MATCH (a:Person) WHERE a.name = 'Arthur' RETURN a.name AS name, a.title AS title");
		  while (result.hasNext()) {
			  Record record = result.next();
		     System.out.println(record.get( "title" ).asString() + " " + record.get("name").asString());
		  }
		}*/
		// Make sure Neo4j Driver is registered
		try {
			Class.forName("org.neo4j.jdbc.Driver");
			// Connect
			Connection con = DriverManager.getConnection("jdbc:neo4j://192.168.192.129:7474/", "neo4j", "123456");

			// Querying
			try(Statement stmt = con.createStatement())
			{
			    ResultSet rs = stmt.executeQuery("MATCH (n:User) RETURN n.name");
			    while(rs.next())
			    {
			        System.out.println(rs.getString("n.name"));
			    }
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
