package org.ipass.com.ipass;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Abishek on 12-Apr-18.
 */

public class PublicChannelFragment extends Fragment {

    public EditText api;
    Button bview;
    private RequestQueue requestQueue;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_public_channel,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        requestQueue = Volley.newRequestQueue(getActivity());
        Toast.makeText(getContext(), "Enter the API Key", Toast.LENGTH_SHORT).show();
        api = (EditText) view.findViewById(R.id.idApi);
        bview = (Button) view.findViewById(R.id.idView);

        bview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String Api = api.getText().toString().trim();
                //Toast.makeText(getContext(),Api, Toast.LENGTH_SHORT).show();
                if (Api.equals("")){
                    api.setError("Enter the API Key");
                }
                else {
                    //HTTP request
                    final ProgressDialog loading = ProgressDialog.show(getActivity(), "Fetching data", "Please wait...", false, false);
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConfig.urlPublic,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    //if the server response is success
                                    //dismissing the progressbar
                                    loading.dismiss();
                                    if (response != null)
                                    {
                                        PublicListView publicListView = new PublicListView();
                                        Bundle bundle = new Bundle();
                                        bundle.putString("response",response);
                                        publicListView.setArguments(bundle);
                                        FragmentManager fragmentManager = getFragmentManager();
                                        fragmentManager.beginTransaction().replace(R.id.idScreenArea,publicListView).commit();
                                    }

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    loading.dismiss();
                                    Toast.makeText(getContext(), "Invalid API Key", Toast.LENGTH_LONG).show();
                                }
                            }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> params = new HashMap<String, String>();
                            //Adding the parameters
                            params.put("api", Api);
                            return params;
                        }
                    };
                    //Adding the request to the queue
                    requestQueue.add(stringRequest);
                }

            }
        });

    }
}
