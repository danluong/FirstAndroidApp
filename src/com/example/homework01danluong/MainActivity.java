package com.example.homework01danluong;

import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Surface;
import android.view.View;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// Called when the user clicks the Start button
	public void greenActivity(View view) {
		//start green activity
		Intent intent = new Intent(this, DisplayGreenActivity.class);
		startActivity(intent);
	}

	//Handle Menu Item
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String content;
		String title = this.getResources().getString(R.string.dialog_title);
		AlertDialog dialog = null;
		int rotation = getWindowManager().getDefaultDisplay().getRotation();
		int rotationDeg = 0;
		
		//Convert rotation for display
		switch (item.getItemId()) {
		case R.id.action_orientation:
			content = this.getResources().getString(R.string.rotation);
			switch (rotation) {
			case Surface.ROTATION_0:
				rotationDeg = 0;
				break;
			case Surface.ROTATION_90:
				rotationDeg = 90;
				break;
			case Surface.ROTATION_180:
				rotationDeg = 180;
				break;
			case Surface.ROTATION_270:
				rotationDeg = 270;
				break;
			}
			
			//make dialog for rotation display
			dialog = new AlertDialog.Builder(this)
					.setMessage(content + " " + rotationDeg)
					.setPositiveButton(R.string.ok,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									// User clicked OK button, dismiss
								}
							}).setTitle(title).create();
			break;
		}
		if (dialog != null)
			dialog.show();
		return super.onOptionsItemSelected(item);
	}
}
