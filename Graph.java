//import java.util.LinkedList;
import java.util.List;

//import testGraph.GraphNode;

public class Graph 
{ 
	private ArrayList<Node> vertices;
	private CircularQue<Node> neighbors;
	
	public Graph()
	{
		this.vertices = new ArrayList<Node>();
		this.neighbors = new CircularQue<Node>();
	}

	public ArrayList<Node> getVertices() 
	{
		return vertices;
	}

	public void setVertices(ArrayList<Node> vertices)
	{
		this.vertices = vertices;
	}
	
	public void removeDups()
	{
		int vertSize = this.vertices.getSize();
		int connecSize = 0;
		int connecData = 0;
		int vertData = 0;
		int targetNode = 0;
		int search = 0;
		
		// Outer loop to cycle the node list
		for(int i = 0; i < vertSize; i++)
		{
			connecSize = vertices.get(i).getConnectedTo().getSize();
			
			// Inner loop to cycle each nodes "edge" list
			for(int j = 0; j < connecSize; j++)
			{
				targetNode = this.vertices.get(i).getConnectedTo().get(j).getData();
				
				this.vertices.get(targetNode - 1).getConnectedTo().remove(0);
				
				
			}
		}
	}
	
	public void visit(Node current)
	{
		if(vertices.get(current.getData() - 1).isVisited())
			return;
		else
		{
			for(int i = 0; i < current.getConnectedTo().getSize(); i++)
			{
				System.out.print(current.getConnectedTo().get(i).getData() + "(" + current.getData() + ") ");
				//vertices.get(current.getConnectedTo().get(i).getData() - 1).setVisited(true);
				this.neighbors.offer(current.getConnectedTo().get(i)); // Addings new nodes to visit to arrayList
			}
			
			vertices.get(current.getData() - 1).setVisited(true);
		}

	}
	
	public void bfsTree(Node startVertex) // Returns string representation of a BFS tree
	{
		
		 if(startVertex ==null) {
	         return;
	     }
	     CircularQue<Node> queue = new CircularQue<Node>();
	     queue.offer(startVertex);
	     queue.offer(null);
	     startVertex.setVisited(true);
	     Node parent=null;
	     Node prev=null;
	     while (!queue.isEmpty())
	     {

	         Node element=queue.poll();
	         if(element==null) {
	             parent = prev;
	             System.out.println();
	             if(queue.isEmpty()) {
	                 break;
	             }
	             element=queue.poll();
	         }
	        
	        
	         if(element!=null && parent!=null) 
	         {
	             System.out.print(element.getData() + "("+parent.getData()+")");
	             ArrayList<Node> neighbours= element.getConnectedTo();
	             for (int i = 0; i < neighbours.getSize(); i++) 
	             {
	                 Node n=neighbours.get(i);
	                 if(n!=null && !n.isVisited())
	                 {
	                     queue.offer(n);
	                     n.setVisited(true);
	   
	                 }
	             }
	             
	             prev=element;
	             queue.offer(null);
	         }else {
	             if(element!=null) {
	                 System.out.print(element.getData() + "("+")");
	                 ArrayList<Node> neighbours=element.getConnectedTo();
	                 for (int i = 0; i < neighbours.getSize(); i++) 
	                 {
	                     Node n=neighbours.get(i);
	                     if(n!=null && !n.isVisited())
	                     {
	                         queue.offer(n);
	                         n.setVisited(true);
	       
	                     }
	                 }
	                 prev=element;
	                 queue.offer(null);
	             }
	            
	         }
	        
	        
	        
	        
	        
	        

	     }
		

	}

	@Override
	public String toString() 
	{
		///////////////// Node List printing ///////////////////////////////////
		String result = "Node list: {";
		int vertSize = vertices.getSize();
		
		for(int i = 0; i < vertSize; i++)
		{
			result += vertices.get(i).getData();
			
			if(i != vertSize - 1)
				result += ",";
		}
		result += "}\n"; 
		
		///////////////// Edge List printing ///////////////////////////////////
		result += "Edge list: {";
		int connecSize = 0;
		
		for(int i = 0; i < vertices.getSize(); i++)
		{
			connecSize = vertices.get(i).getConnectedTo().getSize();
			
			for(int j = 0; j < connecSize; j++)
			{
				result += "(" + vertices.get(i).getData() + "," + vertices.get(i).getConnectedTo().get(j).getData() + ")";
				
				if(j != connecSize - 1)
					result += ",";
			}
			
			
		}
		
		
		return result + "}";
	}
	
	
		
}
