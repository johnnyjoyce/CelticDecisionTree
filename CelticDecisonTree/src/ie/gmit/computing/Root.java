package ie.gmit.computing;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Root extends Activity {
	
	public Node currentNode = new Node("", null);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_root);
		
		Intent i = getIntent();
		currentNode = (Node) i.getSerializableExtra("start");
		
	}
	
	public void refreshScreen(Node node){
		setContentView(R.layout.activity_root);
		LinearLayout buttons = (LinearLayout) findViewById(R.id.dynamicBtns);
		Button backBtn = (Button) findViewById(R.id.back);
		backBtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view){
				if(currentNode.getParent() != null){
					refreshScreen(currentNode.getParent());
				}
			}
		});
		currentNode = node;
		TextView title = (TextView) findViewById(R.id.current);
		title.setText(currentNode.getName());
		if(currentNode.getChildren() != null){
			List<Node> children = currentNode.getChildren();
			for (int i = 0; i < children.size(); i++) {
				Button button = new Button(this);
				button.setText(children.get(i).getName().toString());
				button.setId(i);
				final int buttonID = button.getId();
				buttons.addView(button);
				button.setOnClickListener(new View.OnClickListener() {
					public void onClick(View view) {
						refreshScreen(currentNode.getChildren().get(buttonID));
					}
				});
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.root, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
