package com.kaoshidian.ksdindex.ui.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.ksdindex.R;
import com.kaoshidian.ksdindex.support.BaseFragmentActivity;
import com.kaoshidian.ksdindex.support.RequestHandler;
import com.kaoshidian.ksdindex.support.StaticVariable;
import com.kaoshidian.ksdindex.ui.adapter.TodayRecommendAdapter;

public class Fragment1 extends Fragment{
	
	
	private GridView todayrecommends;
    private List<Map> data = new ArrayList();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	TodayRecommendTask task = new TodayRecommendTask((BaseFragmentActivity)getActivity());
    	task.execute();
        return inflater.inflate(R.layout.fragment_1, container, false);
    }
    
    public class TodayRecommendTask extends AsyncTask<Object, Void, Void> {
        
        private BaseFragmentActivity activity;
        
        public TodayRecommendTask(BaseFragmentActivity activity) {
            super();
            this.activity = activity;
        }

        
        @Override
        protected Void doInBackground(Object... arg0) {
/*            users = new stringGetJson().getJson();
            return null;*/
            String url = StaticVariable.WWW_ROOT+"/android/todayrecommend";
            String res = "";
            RequestHandler handler = new RequestHandler(activity);
            try {
                res = handler.httpGet(url);
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }

            try {
                JSONArray ja = new JSONArray(res);
                for(int i=0;i<ja.length();i++)
                {
                    JSONObject obj = ja.getJSONObject(i);
                    Map<String,String> item = new HashMap(); 
                    item.put("courseCover", obj.getString("imgUrl"));
                    item.put("courseNo", obj.getString("courseNo"));
                    item.put("courseName", obj.getString("courseName"));
                    item.put("courseGrade", obj.getString("courseGrade"));
                    data.add(item);
                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
        	TodayRecommendAdapter todayRecommendAdapter = new TodayRecommendAdapter(activity, data);
        	todayrecommends = (GridView) getActivity().findViewById(R.id.todayRecommends);
        	todayrecommends.setAdapter(todayRecommendAdapter);
        }

    }    
}
