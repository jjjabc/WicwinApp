package com.wicwin.app;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class IndexActivity extends Activity {
	private DrawerLayout mDrawerLayout;
	private Button mMenuButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_index);

		mMenuButton = (Button) findViewById(R.id.menuButton);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout1);
		mMenuButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				((TextView) findViewById(R.id.indexText)).setText("Clicked");
				if (mDrawerLayout == null) {
					return;
				}
				if (mDrawerLayout.isDrawerOpen(GravityCompat.END)) {
					mDrawerLayout.closeDrawer(GravityCompat.END);
				} else {
					mDrawerLayout.openDrawer(GravityCompat.END);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.index, menu);
		return true;
	}

}
