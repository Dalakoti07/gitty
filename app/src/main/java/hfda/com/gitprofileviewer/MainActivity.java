package hfda.com.gitprofileviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView tvResult;
    private Button btnSearch;
    private EditText etUser;
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private int TotalSearchResults;
    private ArrayList<users> githubUsers=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSearch=(Button) findViewById(R.id.btnSearch);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        etUser=(EditText) findViewById(R.id.etUser);

//        setting this layout manager is important otherwise things won't work
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=etUser.getText().toString();
                makeAPICall(userName);
            }
        });
    }

    void makeAPICall(String userName){
        // Instantiate the RequestQueue.
        // volley itself make a async call, making a request queue
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://api.github.com/search/users?q=";
        url=url+userName;
        githubUsers.clear();

        // Request a string response from the provided URL.
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            TotalSearchResults=response.getInt("total_count");
                            JSONArray userList=response.getJSONArray("items");
                            for(int i=0;i<userList.length();i++){
                                JSONObject temp=userList.getJSONObject(i);
                                githubUsers.add(new users(temp.getString("avatar_url"),temp.getString("login"),temp.getString("html_url"),temp.getString("score")));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        // Add the request to the RequestQueue.
        queue.add(request);
        adapter=new customAdapter(githubUsers,this);
        recyclerView.setAdapter(adapter);
    }
}