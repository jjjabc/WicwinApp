package com.wicwin.app;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class IndexActivity extends Activity {
	private DrawerLayout mDrawerLayout;
	private Button mMenuButton;
	private ListView rMenu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_index);

		rMenu = (ListView) findViewById(R.id.rightDrawer);
		rMenu.setAdapter(new ArrayAdapter<String>(this,
				R.layout.right_drawer_menu_item, R.id.rMenuItemText, getData()));
		mMenuButton = (Button) findViewById(R.id.menuButton);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout1);
		mMenuButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
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
		rMenu.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent();
				switch (position) {
				case 0:
					intent.putExtra("cg", "pdt");
					break;
				case 1:
					intent.putExtra("cg", "edu");
					break;
				case 2:
					intent.putExtra("cg", "job");
					break;
				case 3:
					intent.putExtra("cg", "pdt");
					break;
				case 4:
					intent.putExtra("cg", "pdt");
					break;
				default:
					return;
				}
				intent.setClass(IndexActivity.this, categoryActivity.class);
				startActivity(intent);
				mDrawerLayout.closeDrawers();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.index, menu);
		return true;
	}

	private List<String> getData() {

		List<String> data = new ArrayList<String>();
		data.add("信息系统集成");
		data.add("教育咨询服务");
		data.add("招聘猎头服务");
		data.add("合作伙伴");
		data.add("联系我们");

		return data;
	}
}
