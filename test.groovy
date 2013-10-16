import org.neo4j.graphdb.*;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.tooling.GlobalGraphOperations;

GraphDatabaseService graphDb = new GraphDatabaseFactory().newEmbeddedDatabase("sridharData.db");

//
// Create node
//

Transaction tx = graphDb.beginTx();
try
{

	Node firstNode = graphDb.createNode();
	firstNode.setProperty( "name", "Sridhar");
	firstNode.setProperty( "url", "http://www.objectivity.com" );
	// Updating operations go here
	tx.success();
}
finally
{
	tx.finish();
}


//
// Print nodes
//

Transaction tx2 = graphDb.beginTx();
try
{

	Iterable<Node> allNodes = GlobalGraphOperations.at(graphDb).getAllNodes();
	for (final Node node : allNodes) {
		String title = "";
		if (node.hasProperty("name")) {
			title = (String) node.getProperty("name");
		}
		String name = "";
		if (node.hasProperty("url")) {
			name = (String) node.getProperty("url");
		}
	
		System.out.println("\"" + title + "\",\"" + name + "\"");
		System.out.println(name);
		System.out.println();
	}
}
finally
{
	tx.finish();
}
