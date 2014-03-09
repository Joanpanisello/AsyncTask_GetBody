package iesebre.DAM2.httprequestgetbody;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnBoton1 = (Button)findViewById(R.id.button1);
		
		btnBoton1.setOnClickListener(new View.OnClickListener() {
		    public void onClick(View arg0)
		    {
		    	 String missatge = null;
				 Log.d(missatge,"Botón 1 pulsado!");
				 DownloadTask baixa = (DownloadTask) new DownloadTask().execute("http://www.google.es");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public class DownloadTask extends AsyncTask<String, Long, String> {
		  protected String doInBackground(String... urls) {
		  
		    	String string = null;
		    	string =  HttpRequest.get(urls[0]).body();
	
		      return string;
		   
		  }

		  protected void onProgressUpdate(Long... progress) {
		    Log.d("MyApp", "Downloaded bytes: " + progress[0]);
		  }

		  protected void onPostExecute(String string) {
		   
		     Log.d("MyApp", "Code Google: " + string);

		  }
		  
	}

}
