
public class Node 
{
	private int data;
	
	private ArrayList<Node> connectedTo;
	
	private boolean visited;
	
	public Node(int data)
	{
		this.data = data;
		this.connectedTo = new ArrayList<Node>();
	}

	public int getData() 
	{
		return data;
	}

	public void setData(int data) 
	{
		this.data = data;
	}

	public ArrayList<Node> getConnectedTo() 
	{
		return connectedTo;
	}

	public void setConnectedTo(ArrayList<Node> connectedTo) 
	{
		this.connectedTo = connectedTo;
	}

	public boolean isVisited() 
	{
		return visited;
	}

	public void setVisited(boolean visited) 
	{
		this.visited = visited;
	}

	@Override
	public String toString() 
	{
		return "Node [data=" + data + ", connectedTo=" + connectedTo + ", visited=" + visited + "]";
	}
	
	
}
