package com.example.myapplication_helloworld_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView mTextviewResult,nTextViewResult,bTextViewResult,vTextViewResult,xTextViewResult,zTextViewResult;
    private RequestQueue mQueue;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.View_pager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        mTextviewResult = findViewById(R.id.text_view_6);
        nTextViewResult= findViewById(R.id.text_view_5);
        bTextViewResult = findViewById(R.id.text_view_4);
        vTextViewResult = findViewById(R.id.text_view_3);
        xTextViewResult = findViewById(R.id.text_view_01);
        zTextViewResult = findViewById(R.id.text_view_7);

        mQueue = Volley.newRequestQueue(this);


        String url ="https://api.covid19india.org/data.json";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("statewise");
                            Loop:       for(int i=0;i<1;i++){
                                JSONObject employee = jsonArray.getJSONObject(i);


                                String time = employee.getString("lastupdatedtime").substring(0,10);
                                String hou = employee.getString("lastupdatedtime").substring(10,19);
                             String decres = employee.getString("deaths").trim();
                          String  recov  = employee.getString("recovered").trim();
                           String act = employee.getString("active").trim();
                              String confir = employee.getString("confirmed").trim();
                              //  int samplestested = employee.getInt("totalsamplestested");
                                //       int updatetime = employee.getInt("updatetimestamp");
//                                mTextviewResult.append(String.valueOf(positivecases)+" , "+String.valueOf(samplestested)
//                                +" , "+"\n\n");
                                mTextviewResult.append(time);
                                zTextViewResult.append(hou);
                             nTextViewResult.append(decres);
                             bTextViewResult.append(recov);
                           vTextViewResult.append(act);
                           xTextViewResult.append(confir);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        mQueue.add(request);
    }
}