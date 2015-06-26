package com.wicwin.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class categoryActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_category);
		Intent intent =getIntent();
		String cg=intent.getStringExtra("cg");
		((TextView)findViewById(R.id.cg_Text)).setText(cg);
	}
}
