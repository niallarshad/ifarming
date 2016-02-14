package com.farming.app.frontEnd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import com.farming.app.frontEnd.questionsendpoint.Questionsendpoint;
import com.farming.app.frontEnd.questionsendpoint.model.CollectionResponseQuestions;
import com.farming.app.frontEnd.questionsendpoint.model.Questions;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;

//List activity used for making lists across entire screen
public class AnswerActivity extends ListActivity { // open list activity
	// Initialize variables
	private ListView questionsList;
	private List<Questions> _list = null; // list of questions objects
	private ArrayList<Questions> list1 = new ArrayList<Questions>();
	private TextView tv = null; 
	private SimpleAdapter adapter = null;
	private String[] from = { "author", "message" };
	private int[] to = { android.R.id.text1, android.R.id.text2 };
	protected static String buttonPicked;

	@Override
	protected void onCreate(Bundle savedInstanceState) { // start oncreate
		super.onCreate(savedInstanceState);
		tv = new TextView(this); // sets tv to text at the top
		tv.setText(buttonPicked + " questions"); // set text at top to ""
		tv.setGravity(Gravity.CENTER);// center it
		getListView().addHeaderView(tv); // add it
		new QuestionsListAsyncTask(this).execute(); // run method
		questionsList = getListView(); // Initialize questionsList
		questionsList.setCacheColorHint(0);
		questionsList.setBackgroundColor(R.drawable.green4);
		questionsList.setOnItemClickListener(questionsListClickListener); // set an nItemClickListener to questions list
		AnswerDetailsActivity.topic = buttonPicked;
	}// end oncreate

	private class QuestionsListAsyncTask extends AsyncTask<Void, Void, CollectionResponseQuestions> { //start AsyncTask
		Context context;
		private ProgressDialog pd;

		public QuestionsListAsyncTask(Context context) { // start constructor
			this.context = context;
		} // end constructor

		protected void onPreExecute() { // start onPreExecute
			super.onPreExecute();
			pd = new ProgressDialog(context);
			pd.setMessage("Retrieving Questions..."); // loading symbol
			pd.show();
		} // end onPreExecute

		protected CollectionResponseQuestions doInBackground(Void... unused) { // start doInBackground
			CollectionResponseQuestions q = null; // make a CollectionResponseQuestions and set it to null
			try {
				Questionsendpoint.Builder builder = new Questionsendpoint.Builder(
						AndroidHttp.newCompatibleTransport(),
						new GsonFactory(), null); // connect to database
				Questionsendpoint service = builder.build(); // makes a Questionsendpoint and builds an instance of it 
				q = service.listQuestions().execute(); // lets q equal to everything on the database
			} catch (Exception e) {
				Log.d("Could not retrieve Questions", e.getMessage(), e); // error message
			}
			return q; // returns q
		} // end doInBackground

		protected void onPostExecute(CollectionResponseQuestions Questions) { // start onPostExecute
			pd.dismiss();
			// takes in q from doInBackgroundd
			ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>(); // ArrayList of map objects
			_list = Questions.getItems();// let _list equal to everything on the database
			if(buttonPicked.equals("All")) // if button picked equals all list everything
			{
				for (Questions q : _list) { // for loop that goes through the entire database one entry at a time
					if((q.getIsAnswered()).equals("0"))
					{
						HashMap<String, String> item = new HashMap<String, String>(); // HashMap of string objects
						list1.add(q); // add them to list1
						item.put("author", q.getQuestion()); // put question on hash map
						list.add(item); // add to list
					}
				}
			}
			else // else work out what button was picked and list them
			{
				for (Questions q : _list) { // for loop that goes through the entire database one entry at a time
				if((q.getIsAnswered()).equals("0"))
				{
					HashMap<String, String> item = new HashMap<String, String>(); // HashMap of string objects
					if(q.getTopic().equals(buttonPicked))// only get the right questions
					{
						list1.add(q); // add them to list1
						item.put("author", q.getQuestion()); // put question on hash map
						list.add(item); // add to list
					}
				}
				}
			}
			// adapter that takes in 5 variables the activity, the ArrayList, the list, array of string, array of ints 
			adapter = new SimpleAdapter(AnswerActivity.this, list,android.R.layout.simple_list_item_2, from, to); 
			setListAdapter(adapter); // set list adapter
			questionsList.setAdapter(adapter);
		} // end onPostExecute
	}
	private OnItemClickListener questionsListClickListener = new OnItemClickListener() { // start questionsListClickListener
	    // takes in adapter, the view, the position of the thing clicked and the id of the thing clicked
		@Override
	    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
	    	
	      Questions selectedPlace = list1.get((int)arg3); // lets selectedPlace equal to the list item that was clicked on

	      AnswerDetailsActivity.currentPlace = selectedPlace; // lets current place on screen AnswerDetailsActivity equal to selected place
	      Intent i = new Intent(AnswerActivity.this, AnswerDetailsActivity.class); // makes a new intent
	      startActivity(i); // starts intent
	      }
	  };  // end questionsListClickListener
	  
}// close list activity
