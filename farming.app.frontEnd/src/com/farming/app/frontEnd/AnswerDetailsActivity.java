package com.farming.app.frontEnd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.farming.app.frontEnd.answersendpoint.Answersendpoint;
import com.farming.app.frontEnd.answersendpoint.model.Answers;
import com.farming.app.frontEnd.answersendpoint.model.CollectionResponseAnswers;
import com.farming.app.frontEnd.questionsendpoint.model.Questions;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.jackson.JacksonFactory;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class AnswerDetailsActivity extends Activity { // start activity
	protected static Questions currentPlace; // gotten from AnswerActivity screen
	// Initialize variables
	TextView text;
	private ListView answerList;
	private List<Answers> answer = null;
	private ArrayList<Answers> list1 = new ArrayList<Answers>();
	private String[] from = { "author", "message" };
	private int[] to = { android.R.id.text1, android.R.id.text2 };
	private SimpleAdapter adapter = null;
	protected static String topic;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_answer_details);
		text = (TextView) findViewById(R.id.textView1); // make text equal to the textView1
		text.setText(currentPlace.getQuestion()); // set the text to the question
		new listOfAnswersAsyncRetriever(this).execute(); // run method
		answerList = (ListView) findViewById(R.id.answerList); // Initialize answerList
		answerList.setOnItemClickListener(answersListClickListener);// set an nItemClickListener to questions list
	}
	// when post button is pressed run this
	public void Post(View v) throws IOException {
		EditText mEdit; // make an edit text
		mEdit = (EditText) findViewById(R.id.editText1); // set it to edit text 1
		if ((mEdit.getText().toString().trim()).equals(""))
		{
			Toast.makeText(getBaseContext(), "Your text feild is empty", Toast.LENGTH_SHORT).show();
		}
		else
		{
			new EndpointsTask(this).execute(getApplicationContext()); // run method
		}
	}
	// when refresh button is pressed run this
	public void Refresh(View v) throws IOException {
		new listOfAnswersAsyncRetriever(this).execute();// run method
	}

	public class EndpointsTask extends AsyncTask<Context, Integer, Long> { //start AsyncTask
		Context context;
		private ProgressDialog pd;

		public EndpointsTask(Context context) { // start constructor
			this.context = context;
		}// end constructor

		protected void onPreExecute() { // start onPreExecute
			super.onPreExecute();
			pd = new ProgressDialog(context);
			pd.setMessage("Posting Answer"); // loading symbol
			pd.show();
		} // end onPreExecute 

		protected Long doInBackground(Context... contexts) { // start doInBackground
			Answersendpoint.Builder endpointBuilder = new Answersendpoint.Builder(
					AndroidHttp.newCompatibleTransport(), new JacksonFactory(),
					new HttpRequestInitializer() {
						public void initialize(HttpRequest httpRequest) {
						}
					});// connect to database
			Answersendpoint endpoint = CloudEndpointUtils.updateBuilder(
					endpointBuilder).build(); // makes a Answersendpoint and builds an instance of it 
			try {
				EditText mEdit; // make an edit text
				mEdit = (EditText) findViewById(R.id.editText1); // set it to edit text 1
				String q = mEdit.getText().toString(); // get the text from the field 
				
				//set your answer fields
				Answers ans = new Answers().setAnswer(q);
				String answerID = new Date().toString();
				String questionId = currentPlace.getId();

				ans.setId(answerID);
				ans.setQuestionId(questionId);
				ans.setFacebookId(" ");
				ans.setFacebookName("niall");
				ans.setIsDeleted("0");
				ans.setTopic(currentPlace.getTopic());
				ans.setLike("0");
				ans.setDislike("0");

				endpoint.insertAnswers(ans).execute(); // insert it to database
			} catch (IOException e) {
				e.printStackTrace(); // error check
			}
			return (long) 0; //returns nothing
		} // end doInBackground

		protected void onPostExecute(Long l) {
			pd.dismiss();
			EditText mEdit;
			mEdit = (EditText) findViewById(R.id.editText1);
			mEdit.setText(""); // clear text field
			return;
		}
	} //end AsyncTask

	private class listOfAnswersAsyncRetriever extends AsyncTask<Void, Void, CollectionResponseAnswers> { // open activity
		Context context;
		private ProgressDialog pd;

		public listOfAnswersAsyncRetriever(Context context) { // start constructor
			this.context = context;
		} // end constructor

		protected void onPreExecute() { // start onPreExecute
			super.onPreExecute();
			pd = new ProgressDialog(context);
			pd.setMessage("Getting Answers"); // loading symbol
			pd.show();
		} // end onPreExecute

		@Override
		protected CollectionResponseAnswers doInBackground(Void... params) {

			Answersendpoint.Builder endpointBuilder = new Answersendpoint.Builder(
			 		AndroidHttp.newCompatibleTransport(), new JacksonFactory(),
					new HttpRequestInitializer() {
						public void initialize(HttpRequest httpRequest) {
						}
					}); // connect to database
			Answersendpoint endpoint = CloudEndpointUtils.updateBuilder(
					endpointBuilder).build(); // makes a Answersendpoint and builds an instance of it 
			CollectionResponseAnswers result;
			try {
				result = endpoint.listAnswers().execute(); // lets result equal to everything on the database
			} catch (IOException e) {
				e.printStackTrace(); // error message
				result = null;
			}
			return result; // return result
		}

		protected void onPostExecute(CollectionResponseAnswers result) {
			pd.dismiss();

			ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>(); // ArrayList of map objects
			answer = result.getItems(); // answer equal to everything on the database 
			for (Answers q : answer) {// for loop that goes through the entire database one entry at a time
				HashMap<String, String> item = new HashMap<String, String>(); // HashMap of string objects
				if ((q.getQuestionId()).equals(currentPlace.getId())) // only want question with the right id
				{
					list1.add(q); // add them to list1
					item.put("author", q.getAnswer()); // put question on hash map
					list.add(item); // add to list
				}
				
			}
			// adapter that takes in 5 variables the activity, the ArrayList, the list, array of string, array of ints 
			adapter = new SimpleAdapter(AnswerDetailsActivity.this, list,
					android.R.layout.simple_list_item_2, from, to);
			answerList.setAdapter(adapter);// set list adapter
		}

	}//end AsyncTask

	private OnItemClickListener answersListClickListener = new OnItemClickListener() { // start answersListClickListener
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3)
		{
			// use list1 because the ID of arg3 wont match the one on the database
			Answers SP = list1.get((int)arg3);
			
		
			PeopleDetailsActivity.CP = SP; // lets CP on the PeopleDetailsActivity screen equal to SP
			Intent i = new Intent(AnswerDetailsActivity.this,
					PeopleDetailsActivity.class);// makes a new intent
			startActivity(i);// starts intent
		}
	};// end answersListClickListener

}// close activity
