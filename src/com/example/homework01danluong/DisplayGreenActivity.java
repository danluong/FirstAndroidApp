package com.example.homework01danluong;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.ActionBarActivity;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.os.Build;

public class DisplayGreenActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_green);
		// Show the Up button in the action bar.
		setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String content;
		String title = this.getResources().getString(R.string.dialog_title);
		AlertDialog dialog = null;
		switch (item.getItemId()) {
		case R.id.action_orientation:
			content = this.getResources().getString(R.string.rotation);
			dialog = new AlertDialog.Builder(this).setMessage(content)
					.setTitle(title).create();
			break;
		}
		if (dialog != null)
			dialog.show();
		return super.onOptionsItemSelected(item);
	}
}
