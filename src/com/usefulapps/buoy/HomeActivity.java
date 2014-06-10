package com.usefulapps.buoy;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


import com.google.android.gms.common.GooglePlayServicesClient;
//import com.google.android.gms.common.GooglePlayServicesClient;
import com.parse.Parse;
import com.parse.ParseObject;

public class HomeActivity extends Activity 
	implements GooglePlayServicesClient.ConnectionCallbacks,
			GooglePlayServicesClient.OnConnectionFailedListener
{

	
	/** Location Client */
	//private LocationClient mLocationClient_ = null;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_home);

        
        /** Parse init */
        Log.i("PARSE", "About to initialize Parse...");
        Parse.initialize(this, "HDZb5G8H5pZgZKNPrp1KbSjwChffmd39pwK2gDQw", "X8502ZHhy68PWW4duoA9en42t1Gnv1WHpSD9q7wu");
        Log.i("PARSE", "Parse initialized.");
        
        /** Parse test */
        Log.i("PARSE", "Attempting to store a ParseObject...");
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
	    testObject.saveEventually();
        Log.i("PARSE", "ParseObject stored.");

        
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_home, container, false);
            return rootView;
        }
    }

}
