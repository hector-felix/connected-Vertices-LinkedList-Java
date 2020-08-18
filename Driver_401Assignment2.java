import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver_401Assignment2 
{

	public static void main(String[] args) throws IOException
	{
		InputStreamReader rdr = new InputStreamReader(System.in);
		BufferedReader console = new BufferedReader(rdr);
		Double probConnected = 0.25;
		
		int n = 0;
		
		System.out.println("Please enter integer n:");
		n = Integer.parseInt(console.readLine());
		
		Graph myGraph = new Graph();
		///////////////////////////////////////////////////////////////////////
		for(int i = 1; i <= n; i++)
		{
			Node myNode = new Node(i);
			
			myGraph.getVertices().add(myNode);
		}
		// Graph created with all vertices but no connections yet thats next :)
		
		////////////////////////////////////////////////////////////////////////////////
		ArrayList<Node> verticeList = myGraph.getVertices();
		
		for(int i = 0; i < verticeList.getSize(); i++)
		{
			Node iNode = verticeList.get(i);
			
			for(int j = i; j < verticeList.getSize(); j++)
			{
				Node jNode = verticeList.get(j);
				
				if(verticeList.get(i) != verticeList.get(j))
				{
					double chance = Math.random();
					
					if(chance <= probConnected)
					{
						iNode.getConnectedTo().add(jNode); 
						jNode.getConnectedTo().add(iNode);
					}
				}
								
			}
			
		}
		
		myGraph.removeDups();
		// God willing this has attatched all the edges but you know we'll see about that
		
		System.out.println(myGraph);
		
		System.out.println("Enter start vertex");
		int input = Integer.parseInt(console.readLine());
		
		Node startNode = myGraph.getVertices().get(input - 1);
		
		myGraph.bfsTree(startNode);
		
		
		
	}
	
	
	
	
	public static String print(int[] array) // Prints lists
	{
		String result = "{";
		
		for(int i = 0; i < array.length - 1; i++)
		{
			result += array[i] + ", ";
		}
		
		result += array[array.length - 1] + "}";
		
		return result;
	}

	
	
}
