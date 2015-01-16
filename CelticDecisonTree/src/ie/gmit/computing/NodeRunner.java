package ie.gmit.computing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.content.Context;
import android.content.Intent;
import android.widget.Button;

public class NodeRunner {
	public static void main(String[] args) throws Exception
	{
		
		Node root = new Node("Start", null);
		
		Node solid = new Node ("Solid", root);
		root.addChildren(solid);

		Node flexible = new Node ("Flexible", root);
		root.addChildren(flexible);
		
		Node hard = new Node ("Hard", solid);
		solid.addChildren(hard);
		
		Node squashed = new Node ("Can be squashed", solid);
		//squashed.setImage(new ImageIcon("me.png"));	//DCIM/photos/.....
		solid.addChildren(squashed);
		
		Node filmatious = new Node("Filmatious", flexible);
		flexible.addChildren(filmatious);
		
		Node surface = new Node("Large Surface Area", flexible);
		flexible.addChildren(surface);
		
		Node smooth = new Node("Smooth Edges", hard);
		hard.addChildren(smooth);
		
		Node irregular = new Node("Irregular Edges", hard);
		hard.addChildren(irregular);
		
		Node styrene = new Node("Styrene", squashed);
		//styrene.setImage(new ImageIcon("me.png"));	//DCIM/photos/.....
		squashed.addChildren(styrene);
		
		Node fibre = new Node("Fibre", filmatious);
		//fibre.setImage(new ImageIcon("me.png"));	//DCIM/photos/.....
		filmatious.addChildren(fibre);
		
		Node film = new Node("Film", surface);
		//film.setImage(new ImageIcon("me.png"));	//DCIM/photos/.....
		surface.addChildren(film);
		
		Node pellet = new Node("Resin Pellet", smooth);
		smooth.addChildren(pellet);
		
		Node item = new Node("Fragment of Larger Item",  irregular);
		irregular.addChildren(item);
		
		Node cylindrical = new Node("Cylindrical", pellet);
		pellet.addChildren(cylindrical);
		
		Node rounded = new Node("Rounded", pellet);
		pellet.addChildren(rounded);
		
		Node edges = new Node("Edges", item);
		item.addChildren(edges);
		
		Node lng = new Node("Long", cylindrical);
		//lng.setImage(new ImageIcon("me.png"));	//DCIM/photos/.....
		cylindrical.addChildren(lng);
		
		Node flat = new Node("Flat", cylindrical);
		//flat.setImage(new ImageIcon("me.png"));	//DCIM/photos/.....
		cylindrical.addChildren(flat);
		
		Node oval = new Node("Oval", rounded);
		//oval.setImage(new ImageIcon("me.png"));	//DCIM/photos/.....
		rounded.addChildren(oval);
		
		Node sphere = new Node("Sphere", rounded);
		//sphere.setImage(new ImageIcon("me.png"));	//DCIM/photos/.....
		rounded.addChildren(sphere);
		
		Node aangular = new Node("All Angular", edges);
		//aangular.setImage(new ImageIcon("me.png"));	//DCIM/photos/.....
		edges.addChildren(aangular);
		
		Node mangular = new Node("Most Angular", edges);
		//mangular.setImage(new ImageIcon("me.png"));	//DCIM/photos/.....
		edges.addChildren(mangular);
		
		Node mrounded = new Node("Most Rounded", edges);
		//mrounded.setImage(new ImageIcon("me.png"));	//DCIM/photos/.....
		edges.addChildren(mrounded);
		
		Node arounded = new Node("All Rounded", edges);
		//arounded.setImage(new ImageIcon("me.png"));	//DCIM/photos/.....
		edges.addChildren(arounded);
		
		//Save the tree......
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("tree.ser"));
		
		out.writeObject(root);
		out.flush();
		out.close();
		
		//Load the tree
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("tree.ser")));
		
		root = (Node) in.readObject();
		System.out.println(root.getName());
		
		//Get the root node to pass onto the Root.java page for the refresh buttons
		Intent i = new Intent().putExtra("start", root);
		//startActivity(i);
		
	}	
}