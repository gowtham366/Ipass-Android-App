package org.ipass.com.ipass;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Abishek on 16-Apr-18.
 */

public class ChannelTypeFragment extends Fragment {
    private RequestQueue requestQueue;
    private String api;
    private String state;
    Button Btpublic;
    Button Btprivate;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.channel_type,null);

        Bundle bundle = getArguments();
        if (bundle!=null){
            api = bundle.getString("api");
          }

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        requestQueue = Volley.newRequestQueue(getActivity());
        ///
        Btpublic = (Button) view.findViewById(R.id.idMakePublic);
        Btprivate = (Button) view.findViewById(R.id.idMakePrivate);
        Btpublic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state = "true";

                //HTTP request
                final ProgressDialog loading = ProgressDialog.show(getActivity(), "Updating", "Please wait...", false, false);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConfig.urlMakePublic,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                //if the server response is success
                                //dismissing the progressbar
                                loading.dismiss();
                                if (response != null)
                                {
                                    Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
                                }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                loading.dismiss();
                                Toast.makeText(getContext(), "Error!!!", Toast.LENGTH_LONG).show();
                            }
                        }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params = new HashMap<String, String>();
                        //Adding the parameters
                        //Intent intent =getIntent();
                        params.put("api", api);
                        params.put("status",state);
                        return params;
                    }
                };
                //Adding the request to the queue
                requestQueue.add(stringRequest);
            }
        });

        Btprivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state = "false";
                //HTTP request
                final ProgressDialog loading = ProgressDialog.show(getActivity(), "Updating", "Please wait...", false, false);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConfig.urlMakePublic,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                //if the server response is success
                                //dismissing the progressbar
                                loading.dismiss();
                                if (response != null)
                                {
                                    Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
                                }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                loading.dismiss();
                                Toast.makeText(getContext(), "Error!!!", Toast.LENGTH_LONG).show();
                            }
                        }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params = new HashMap<String, String>();
                        //Adding the parameters
                        //Intent intent =getIntent();
                        params.put("api", api);
                        params.put("status",state);
                        return params;
                    }
                };
                //Adding the request to the queue
                requestQueue.add(stringRequest);
            }
        });

    }
}
