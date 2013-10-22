package com.kaoshidian.ksdindex.support;

import android.app.Application;
import android.support.v4.app.FragmentActivity;

public class BaseFragmentActivity extends FragmentActivity implements IBaseActivity{
	
	public String getSession() {
		Application app = getApplication();
		GlobalApp ga = (GlobalApp) app;

		String sessionId = ga.getSessionId();
		if (sessionId == null || (sessionId != null && sessionId.length() == 0)) {
			sessionId = new GetSessionTask().getSession();
		}
		ga.setSessionId(sessionId);
		return sessionId;
	}
}
