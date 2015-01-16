package ie.gmit.computing;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CameraAct extends Activity {

	private static final long LOCATION_REFRESH_TIME = 0;

	private static final float LOCATION_REFRESH_DISTANCE = 0;

	ImageView imgFavourite;
	
	private final LocationListener mLocationListener = new LocationListener(){
		public void onLocationChanged(final Location location){
			
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			
		}

		@Override
		public void onProviderEnabled(String provider) {
			
		}

		@Override
		public void onProviderDisabled(String provider) {
			
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera);
		
		Button cont = (Button) findViewById(R.id.btnContinue);
        cont.setOnClickListener(new OnClickListener()
        {
        	
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(CameraAct.this, Root.class);
				startActivity(intent);
				
			}
		});
		
		LocationManager mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		
		mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, LOCATION_REFRESH_TIME, LOCATION_REFRESH_DISTANCE, mLocationListener);
		
		GPSTracker mGPS = new GPSTracker(this);

	    TextView text = (TextView) findViewById(R.id.texts);
	    if(mGPS.canGetLocation ){
	    mGPS.getLocation();
	    text.setText("Lat" + mGPS.getLatitude() + "Lon" + mGPS.getLongitude());
	    }else{
	        text.setText("Unabletofind");
	        System.out.println("Unable");
	    }
		
		imgFavourite = (ImageView) findViewById(R.id.imageView1);
        
        imgFavourite.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				open();
				
			}
		});		
	}
	
	public void open(){
    	Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
    	startActivityForResult(intent, 0);
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent data){
    	super.onActivityResult(requestCode, resultCode, data);
    	Bitmap bp = (Bitmap) data.getExtras().get("data");
    	imgFavourite.setImageBitmap(bp);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.camera, menu);
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
