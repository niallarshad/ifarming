


package com.farming.app.frontEnd;

import android.os.Bundle;
import android.app.Activity;

import android.view.View;

import android.content.Intent;


public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}

	// move to next screen button
	public void onClick(View v) {
		Intent i = new Intent(LoginActivity.this, HomeActivity.class);
		startActivity(i);
	}

/*	private static String APP_ID = "248439938689651"; // Replace your App ID
	// here

	// Instance of Facebook Class
	private Facebook facebook;
	private AsyncFacebookRunner mAsyncRunner;
	String FILENAME = "AndroidSSO_data";
	private SharedPreferences mPrefs;
	Button btnFbLogin;
	String mUserName;
	String mUserEmail;
	String mUserId;
	String access_token;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		facebook = new Facebook(APP_ID);
		mAsyncRunner = new AsyncFacebookRunner(facebook);
		btnFbLogin = (Button) findViewById(R.id.button1);
	}

	public void login(View v) {
		loginToFacebook();
	}

	@SuppressWarnings("deprecation")
	public void loginToFacebook() {
		mPrefs = getPreferences(MODE_PRIVATE);
		access_token = mPrefs.getString("access_token", null);
		long expires = mPrefs.getLong("access_expires", 0);
		if (access_token != null) {
			facebook.setAccessToken(access_token);
		}

		if (expires != 0) {
			facebook.setAccessExpires(expires);
		}

		if (!facebook.isSessionValid()) {
			facebook.authorize(this,
					new String[] { "email", "publish_stream" },
					new DialogListener() {

						@Override
						public void onCancel() {

							// Function to handle cancel event
						}

						@Override
						public void onComplete(Bundle values) {
							// Function to handle complete event
							// Edit Preferences and update facebook acess_token
							SharedPreferences.Editor editor = mPrefs.edit();
							editor.putString("access_token",
									facebook.getAccessToken());
							editor.putLong("access_expires",
									facebook.getAccessExpires());
							editor.commit();

						}

						@Override
						public void onError(DialogError error) {
							// Function to handle error

						}

						@Override
						public void onFacebookError(FacebookError fberror) {
							// Function to handle Facebook errors

						}

					});
		} else {
			getProfileInformation();
		}

	}

	public void getProfileInformation() {

		try {

			JSONObject profile = Util.parseJson(facebook.request("me"));
			Log.e("Profile", "" + profile);

			mUserId = profile.getString("id");
			access_token = facebook.getAccessToken();
			mUserName = profile.getString("name");
			mUserEmail = profile.getString("email");

			runOnUiThread(new Runnable() {

				public void run() {

					Log.e("FaceBook_Profile", "" + mUserId + "\n"
							+ access_token + "\n" + mUserName + "\n"
							+ mUserEmail);

					Toast.makeText(getApplicationContext(),
							"Name: " + mUserName + "\nEmail: " + mUserEmail,
							Toast.LENGTH_LONG).show();

				}

			});

		} catch (FacebookError e) {

			e.printStackTrace();
		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (JSONException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
*/
}
