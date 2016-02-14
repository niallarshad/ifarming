package com.farming.app.frontEnd;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;



public class MainActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	// next screen
	public void onClick(View v)
	{      
		Intent i = new Intent(MainActivity.this,LoginActivity.class);
		startActivity(i);

	}
}
