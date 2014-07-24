package com.tagworld.myactionbar;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnNavigationListener {
	private ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		actionBar = getActionBar();

		// Hide the action bar title
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.GRAY));
//		actionBar.setDisplayShowTitleEnabled(false);
//		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
//
//		final String[] dropdownValues = getResources().getStringArray(
//				R.array.dropdown);
//
//		// Specify a SpinnerAdapter to populate the dropdown list.
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//				actionBar.getThemedContext(),
//				android.R.layout.simple_spinner_item, android.R.id.text1,
//				dropdownValues);
//
//		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//		// Set up the dropdown list navigation in the action bar.
//		actionBar.setListNavigationCallbacks(adapter, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.actionmenu, menu);
		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		SearchView searchView = (SearchView) menu.findItem(R.id.action_search)
				.getActionView();
		searchView.setSearchableInfo(searchManager
				.getSearchableInfo(getComponentName()));
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Take appropriate action for each action item click
		// Toast.makeText(MainActivity.this, item.getTitle(),
		// Toast.LENGTH_LONG).show();
		switch (item.getItemId()) {
		case R.id.action_search:
			// search action
			return true;
		case R.id.action_location_found:
			// location found
			Intent i = new Intent(MainActivity.this, LocationFound.class);
			startActivity(i);
			return true;
		case R.id.action_refresh:
			// refresh
			return true;
		case R.id.action_help:
			// help action
			return true;
		case R.id.action_check_updates:
			// check for updates action
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		Fragment fragment = new MyFragment();
		Bundle args = new Bundle();
		args.putInt(MyFragment.ARG_SECTION_NUMBER, itemPosition);
		fragment.setArguments(args);
		getFragmentManager().beginTransaction()
				.replace(R.id.container, fragment).commit();
		return true;
	}

	public static class MyFragment extends Fragment {

		public static final String ARG_SECTION_NUMBER = "placeholder_text";

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			TextView textView = new TextView(getActivity());
			textView.setGravity(Gravity.CENTER);
			textView.setText(getResources().getStringArray(R.array.dropdown)[getArguments().getInt(
					ARG_SECTION_NUMBER)]);
			textView.setTextColor(Color.BLACK);
			return textView;
		}
	}
}
