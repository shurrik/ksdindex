
package com.kaoshidian.ksdindex.support;


import android.app.Activity;

public class BaseActivity extends Activity implements IBaseActivity{

    public String getSession()
    {
        GlobalApp ga = (GlobalApp) getApplication();
        
        String sessionId = ga.getSessionId();
        if(sessionId==null||(sessionId!=null&&sessionId.length()==0))
        {
            sessionId = new GetSessionTask().getSession();
        }
        ga.setSessionId(sessionId);
        return sessionId;
    }
}
