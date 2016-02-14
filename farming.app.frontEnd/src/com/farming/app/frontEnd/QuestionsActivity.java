package com.farming.app.frontEnd;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.farming.app.frontEnd.questionsendpoint.Questionsendpoint;
import com.farming.app.frontEnd.questionsendpoint.model.Questions;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.jackson.JacksonFactory;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;

import android.graphics.Bitmap;

import android.util.Log;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class QuestionsActivity extends Activity {
	// Initialize variables
	ImageView ivThumbnailPhoto;
	Bitmap bitMap;
	Uri imageUri;
	static int TAKE_PICTURE = 1;
	String mCurrentPhotoPath;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);
		ivThumbnailPhoto = (ImageView) findViewById(R.id.ivThumbnailPhoto); // setting imageView
	}

	public void onClick(View v) {
		Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); // start the camera app
		File photo = new File(Environment.getExternalStorageDirectory(),"Pic.jpg"); // make a new file and store the picture that was just taken in it
		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photo)); 
		imageUri = Uri.fromFile(photo); // store the uri of the photo into a Uri
		startActivityForResult(intent, TAKE_PICTURE); 
	}
	/** this code was taken from http://stackoverflow.com/questions/9094459/java-android-getting-image-from-gallery-and-show-it-on-screen-error
	 and changed to work for me **/
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == TAKE_PICTURE && resultCode == RESULT_OK) { // if the picture has been take and result is ok, run 
			Uri selectedImage = imageUri; // selectedImage equal to imageUri
			getContentResolver().notifyChange(selectedImage, null);
			ContentResolver cr = getContentResolver();
			try {
				bitMap = android.provider.MediaStore.Images.Media.getBitmap(cr,selectedImage); // stores my image in the bitmap
				bitMap = Bitmap.createScaledBitmap(bitMap, 200, 200, true); // makes the image smaller
				ivThumbnailPhoto.setImageBitmap(bitMap); // sets the image to the imageView on the screen

				Toast.makeText(this, selectedImage.toString(),Toast.LENGTH_LONG).show(); // toast with were it is saved
			} catch (Exception e) {
				Toast.makeText(this, "Failed to load", Toast.LENGTH_SHORT).show(); // error checking
				Log.e("Camera", e.toString());
			}
		}
	}
	//post button
	public void Post(View v) throws IOException {
		EditText mEdit; // make an edit text
		mEdit = (EditText) findViewById(R.id.editText1); // set it to edit text 1
		if ((mEdit.getText().toString().trim()).equals(""))
		{
			Toast.makeText(getBaseContext(), "Your text feild is empty", Toast.LENGTH_SHORT).show();
		}
		else
		{
			new EndpointsTask(this).execute(getApplicationContext());  // run this
		}
	}

	public class EndpointsTask extends AsyncTask<Context, Integer, Long> { //start AsyncTask
		Context context;
		private ProgressDialog pd;

		public EndpointsTask(Context context) { // start constructor
			this.context = context;
		} // end constructor

		protected void onPreExecute() { // start onPreExecute
			super.onPreExecute();
			pd = new ProgressDialog(context);
			pd.setMessage("Posting Question"); // loading symbol
			pd.show();
		} // end onPreExecute 

		protected Long doInBackground(Context... contexts) { // start doInBackground

			Questionsendpoint.Builder endpointBuilder = new Questionsendpoint.Builder(
					AndroidHttp.newCompatibleTransport(), new JacksonFactory(),
					new HttpRequestInitializer() {
						public void initialize(HttpRequest httpRequest) {
						}
					}); // connect to database
			Questionsendpoint endpoint = CloudEndpointUtils.updateBuilder(
					endpointBuilder).build(); // makes a Questionsendpoint and builds an instance of it 
			try {
				EditText mEdit;
				mEdit = (EditText) findViewById(R.id.editText1);
				String q = mEdit.getText().toString(); // gets the text from editText1 and stores it as a string
				
				Spinner s;
				s = (Spinner)findViewById(R.id.spinner1);
				String i = s.getSelectedItem().toString(); // gets the Text from the spinner
		
				// set your question fields
				Questions ques = new Questions().setQuestion(q);
				String QuestionsID = new Date().toString();
				
				ques.setId(QuestionsID);
				ques.setFacebookId(" ");
				ques.setFacebookName("niall");
				ques.setIsAnswered("0");
				ques.setTopic(i);

				endpoint.insertQuestions(ques).execute();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return (long) 0;
		}

		protected void onPostExecute(Long l) {
			pd.dismiss();
			EditText mEdit;
			mEdit = (EditText) findViewById(R.id.editText1);
			mEdit.setText(""); // clear text field
			return;
		}
	}

}
