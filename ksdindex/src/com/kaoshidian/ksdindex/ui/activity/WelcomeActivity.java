package com.kaoshidian.ksdindex.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.example.ksdindex.R;
import com.kaoshidian.ksdindex.support.BaseActivity;

public class WelcomeActivity extends BaseActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.welcome);
		Intent intent = new Intent(this,HomeActivity.class);
		startActivity(intent);
	}
}
