package iie.ac.cn;

import java.io.File;

import org.neo4j.cypher.internal.javacompat.ExecutionEngine;
import org.neo4j.cypher.internal.javacompat.ExecutionResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class TestExcution {
	public static void main(String[] args) {
		GraphDatabaseFactory graphDbFactory = new GraphDatabaseFactory();

	      GraphDatabaseService graphDb = graphDbFactory.newEmbeddedDatabase(new File("C:/TPNeo4jDB"));
	      Result result = graphDb.execute("MATCH (java:JAVA) RETURN java");
	      System.out.println(result);
	      /*ExecutionEngine execEngine = new ExecutionEngine(null, null);
	      ExecutionResult execResult = execEngine.execute("MATCH (java:JAVA) RETURN java");
	      String results = execResult.dumpToString();*/
	}
}
