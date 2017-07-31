package com.volleyapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        requestJsonObject();
    }

    private void requestJsonObject() {

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://toscanyacademy.com/blog/mp.php";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray jsonArray = new JSONArray(response);
                    ArrayList<ItemObject> itemArrayList = new ArrayList<>();
                    for (int i =0;i<jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        ItemObject itemObject = new ItemObject();

                        itemObject.setSongTitle(jsonObject.getString("song_name"));
                        itemObject.setSongAuthor(jsonObject.getString("artist_name"));
                        itemObject.setSongYear(jsonObject.getString("song_id"));

                        itemArrayList.add(itemObject);
                        adapter = new RecyclerViewAdapter(MainActivity.this, itemArrayList);
                        recyclerView.setAdapter(adapter);

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

        queue.add(stringRequest);


    }

//    private void requestJsonObject() {
//
//        RequestQueue queue = Volley.newRequestQueue(this);
//        String url ="http://toscanyacademy.com/blog/mp.php";
//
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Log.d(TAG, "Response " + response);
//
//                GsonBuilder builder = new GsonBuilder();
//                Gson mGson = builder.create();
//
//                List<ItemObject> posts = new ArrayList<ItemObject>();
//                posts = Arrays.asList(mGson.fromJson(response,ItemObject[].class));
//                adapter = new RecyclerViewAdapter(MainActivity.this, posts);
//                recyclerView.setAdapter(adapter);
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//                Log.d(TAG, "Error " + error.getMessage());
//            }
//        });
//        queue.add(stringRequest);
//    }
}
