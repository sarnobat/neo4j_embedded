import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.tooling.GlobalGraphOperations;

GraphDatabaseService graphDb = new GraphDatabaseFactory().newEmbeddedDatabase("yurl.db");

Iterable<Node> allNodes = GlobalGraphOperations.at(graphDb).getAllNodes();
for (final Node node : allNodes) {
	String title = "";
	if (node.hasProperty("title")) {
		title = (String) node.getProperty("title");
	}
	String name = "";
	if (node.hasProperty("name")) {
		name = (String) node.getProperty("name");
	}

	System.out.println("\"" + title + "\",\"" + name + "\"");
	System.out.println(name);
	System.out.println();
}