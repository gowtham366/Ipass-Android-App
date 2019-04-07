package org.ipass.com.ipass;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/**
 * Created by Abishek on 16-Apr-18.
 */

public class ListViewFragment extends Fragment {
    private RequestQueue requestQueue;
    private String api;
    private String name;
    private String token;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_list_view,null);
        requestQueue = Volley.newRequestQueue(getActivity());
        final Bean bean =new Bean();
        Bundle bundle = getArguments();
        if (bundle!=null){
            api = bundle.getString("api");
            name = bundle.getString("name");
            token = bundle.getString("token");
        }
        Toast.makeText(getContext(), "Fetching Success!!!", Toast.LENGTH_SHORT).show();
        //Toast.makeText(getContext(), name, Toast.LENGTH_SHORT).show();
        //Toast.makeText(getContext(), token, Toast.LENGTH_SHORT).show();

        //HTTP request
        final ProgressDialog loading = ProgressDialog.show(getActivity(), "Fetching Data", "Please wait...", false, false);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConfig.urlDashboard,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //if the server response is success
                        //dismissing the progressbar
                        loading.dismiss();
                        if (response != null)
                        {
                            try {
                                JSONObject jsonObject1 = new JSONObject(response);
                                //Toast.makeText(getContext(),jsonObject.getString("status"), Toast.LENGTH_SHORT).show();
                                //Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
                                JSONObject jsonObject = jsonObject1.getJSONObject("obj");
                                String field1Name = jsonObject.getString("field1Name");
                                //Toast.makeText(getContext(), field1Name, Toast.LENGTH_SHORT).show();
                                String field2Name = jsonObject.getString("field2Name");
                                String field3Name = jsonObject.getString("field3Name");
                                String field4Name = jsonObject.getString("field4Name");
                                String field5Name = jsonObject.getString("field5Name");
                                String field6Name = jsonObject.getString("field6Name");
                                JSONArray arrfieldValues = jsonObject.getJSONArray("fieldValues");
                                ListView listView = (ListView) view.findViewById(R.id.idListView);
                                ResultItemAdapter resultItemAdapter = new ResultItemAdapter(getContext(),R.layout.list_row);
                                listView.setAdapter(resultItemAdapter);
                             for (int i=(arrfieldValues.length()-1); i>=0; i--){
                                 JSONObject obj = arrfieldValues.getJSONObject(i);
                                 String time = obj.getString("time");
//                                 Date date = new Date(Long.parseLong(time));
//                                 DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//                                 format.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
//                                 time = format.format(date);
                                 String field1Value = obj.getString("field1");
                                 //Toast.makeText(getContext(), time, Toast.LENGTH_SHORT).show();
                                 String field2Value = obj.getString("field2");
                                 String field3Value = obj.getString("field3");
                                 String field4Value = obj.getString("field4");
                                 String field5Value = obj.getString("field5");
                                 String field6Value = obj.getString("field6");

                                 ResultItems res = new ResultItems(time,field1Name,field1Value, field2Name,field2Value ,field3Name,field3Value,field4Name,field4Value,field5Name,field5Value,field6Name,field6Value);
                                 resultItemAdapter.add(res);
                             }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.dismiss();
                        Toast.makeText(getContext(), "Error!!!", Toast.LENGTH_LONG).show();
                        Toast.makeText(getContext(), bean.getName(), Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                //Adding the parameters
                //Intent intent =getIntent();
                params.put("api", api);
                params.put("token", token);
                return params;
            }
        };
        //Adding the request to the queue
        requestQueue.add(stringRequest);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
