package ie.gmit.computing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Node implements Serializable {
	private static final long serialVersionUID = 777L;
	private String name;
	private Node parent;
	private List<Node> children = new ArrayList<Node>();
	private ImageIcon image = null;
	

	public Node(String name, Node parent) {
		super();
		this.name = name;
		this.parent = parent;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Node getParent(){
		return this.parent;
	}
	
	public void setParent(Node parent){
		this.parent = parent;
	}
	
	public void addChildren(Node child){
		this.children.add(child);
	}
	
	public void deleteChildren(Node child){
		this.children.remove(child);
	}
	
	public void insertChild(Node next, Node index){
		if(children.size() > 0)
		{
			for(Node child : children)
			{
				child.setParent(index);
				index.addChildren(child);
			}
			this.children = null;
		}
		this.children.add(next);
		next.setParent(this);
	}
	
	public List<Node> getChildren()
	{
		return children;
	}
	
	public Node [] children(){
		if(this.hasChildren())
		{
			Node[] temp = new Node[children.size()];
			for(int i = 0; i < temp.length; i++)
			{
				temp[i] = children.get(i);
			}
			return temp;
		}
		return null;
	}
	
	public ImageIcon getImage(){
		return this.image;
	}
	
	public void setImage(ImageIcon image){
		this.image = image;
	}
	
	public boolean hasChildren(){
		return this.children.size()>0;
	}
	
	public boolean isLeaf(){
		if(this.children.size() > 0)
		{
			return false;
		}
		return true;
	}
	
	public boolean isRoot(){
		if(this.parent == null)
		{
			return true;
		}
		return false;
	}
	
	public boolean hasImage(){
		return this.image != null;
	}
}
