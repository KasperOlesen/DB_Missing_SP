package src;

import org.neo4j.driver.v1.*;

/**
 *
 * @author kAlex
 */
public class Neo4JControl {
        private Driver driver;
	private Session session;

	private void init() {
		driver = GraphDatabase.driver(
                        "bolt://localhost", 
                        AuthTokens.basic("neo4j", "kasper1277"));
		session = driver.session();

	}

	public StatementResult getEndorsesDepthOne(int id) {
		init();
		return session.run("MATCH (a:Person {id:" + id + "})-[r:ENDORSES*1]->(b:Person) RETURN r, a, b");
	}

	public StatementResult getEndorsesDepthTwo(int id) {
		init();
		return session.run("MATCH (a:Person {id:" + id + "})-[r:ENDORSES*1..2]->(b:Person) RETURN r, a, b");
	}

	public StatementResult getEndorsesDepthThree(int id) {
		init();
		return session.run("MATCH (a:Person {id:" + id + "})-[r:ENDORSES*1..3]->(b:Person) RETURN r, a, b");
	}

	public StatementResult getEndorsesDepthFour(int id) {
		init();
		return session.run("MATCH (a:Person {id: " + id + "})-[r:ENDORSES*1..4]->(b:Person) RETURN r, a, b");
	}

	public StatementResult getEndorsesDepthFive(int id) {
		init();
		return session.run("MATCH (a:Person {id: " + id + "})-[r:ENDORSES*1..5]->(b:Person) RETURN r, a, b");
	}

	public void close() {
		if (session != null) {
			session.close();
		}
	}
}
