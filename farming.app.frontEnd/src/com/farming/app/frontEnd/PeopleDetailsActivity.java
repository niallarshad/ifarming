package com.farming.app.frontEnd;

import java.io.IOException;

import com.farming.app.frontEnd.answersendpoint.Answersendpoint;
import com.farming.app.frontEnd.answersendpoint.model.Answers;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.jackson.JacksonFactory;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class PeopleDetailsActivity extends Activity {
	protected static Answers CP; // gotten from previous screen
	TextView text,text1,text2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_people_details);
		// set your text feilds
		text = (TextView) findViewById(R.id.textView2);
		text1 = (TextView) findViewById(R.id.textView4);
		text2 = (TextView) findViewById(R.id.textView6);
		text.setText(CP.getAnswer());
		text1.setText(CP.getLike());
		text2.setText(CP.getDislike());
	}
	// like button
	public void Like(View v) {
		new EndpointsTask(this).execute(getApplicationContext());
	} 
	// disLike button
	public void Dislike(View v) {
		new EndpointsTask1(this).execute(getApplicationContext());
	}
	public class EndpointsTask extends AsyncTask<Context, Integer, Long> { // start AsyncTask
		Context context;
		private ProgressDialog pd;

		public EndpointsTask(Context context) {
			this.context = context;
		}

		protected void onPreExecute() {
			super.onPreExecute();
			pd = new ProgressDialog(context);
			pd.setMessage("Liking");
			pd.show();
		}

		protected Long doInBackground(Context... contexts) {

			Answersendpoint.Builder endpointBuilder = new Answersendpoint.Builder(
					AndroidHttp.newCompatibleTransport(), new JacksonFactory(),
					new HttpRequestInitializer() {
						public void initialize(HttpRequest httpRequest) {
						}
					}); // connect to database
			Answersendpoint endpoint = CloudEndpointUtils.updateBuilder(
					endpointBuilder).build();
			try {
				int like = Integer.parseInt(CP.getLike()); // its stored as a string on the database so parse it to an int
				like++; // increment it
				CP.setLike(Integer.toString(like)); // parse it back a string and set it
				endpoint.updateAnswers(CP).execute(); // database
			} catch (IOException e) {
				e.printStackTrace();
			}
			return (long) 0;
		}

		protected void onPostExecute(Long l) {
			pd.dismiss();
			text1.setText(CP.getLike());  // refresh text field
			return;
		}
	}// end AsyncTask
	public class EndpointsTask1 extends AsyncTask<Context, Integer, Long> { // start AsyncTask
		Context context;
		private ProgressDialog pd;

		public EndpointsTask1(Context context) {
			this.context = context;
		}

		protected void onPreExecute() {
			super.onPreExecute();
			pd = new ProgressDialog(context);
			pd.setMessage("Disliking....");
			pd.show();
		}

		protected Long doInBackground(Context... contexts) {

			Answersendpoint.Builder endpointBuilder = new Answersendpoint.Builder(
					AndroidHttp.newCompatibleTransport(), new JacksonFactory(),
					new HttpRequestInitializer() {
						public void initialize(HttpRequest httpRequest) {
						}
					}); // connect to database
			Answersendpoint endpoint = CloudEndpointUtils.updateBuilder(
					endpointBuilder).build();  
			try {
				int like = Integer.parseInt(CP.getDislike());// its stored as a string on the database so parse it to an int
				like++;
				CP.setDislike(Integer.toString(like)); // parse it back a string and set it
				endpoint.updateAnswers(CP).execute();  // database
			} catch (IOException e) {
				e.printStackTrace();
			}
			return (long) 0;
		}

		protected void onPostExecute(Long l) {
			pd.dismiss();
			text2.setText(CP.getDislike());  // refresh text field
			return;
		}
	} // end AsyncTask
	

}
