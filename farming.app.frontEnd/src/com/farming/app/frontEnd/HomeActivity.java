package com.farming.app.frontEnd;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.content.Intent;

public class HomeActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
	}
	// ask a question button
	public void onClick(View v)
	{      
		Intent i = new Intent(HomeActivity.this,QuestionsActivity.class);
		startActivity(i);

	}
	// policy and schemes button
	public void PandS(View v)
	{      
		AnswerActivity.buttonPicked = "Policy and Schemes"; // makes buttonPicked on next screen equal to Policy and Schemes
		Intent i = new Intent(HomeActivity.this,AnswerActivity.class);
		startActivity(i);

	}
	// animal health button
	public void animalHealth(View v)
	{      
		AnswerActivity.buttonPicked = "Animal Health"; // makes buttonPicked on next screen equal to Animal Health
		Intent i = new Intent(HomeActivity.this,AnswerActivity.class);
		startActivity(i);

	}
	// legal button
	public void legal(View v)
	{      
		AnswerActivity.buttonPicked = "Legal";  // makes buttonPicked on next screen equal to Legal
		Intent i = new Intent(HomeActivity.this,AnswerActivity.class);
		startActivity(i);

	}
	// answer a question button
	public void answer(View v)
	{   
		AnswerActivity.buttonPicked = "All"; // makes buttonPicked on next screen equal to All
		Intent i = new Intent(HomeActivity.this,AnswerActivity.class);
		startActivity(i);

	}

}
