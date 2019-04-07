package org.ipass.com.ipass;

import android.app.ProgressDialog;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
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
 * Created by Abishek on 10-Apr-18.
 */



public class CreateAccountFragment extends Fragment  {
    public EditText firstName;
    public EditText lastName;
    public EditText email;
    public EditText password;
    public EditText mobile;
    Button join;
    private RequestQueue requestQueue;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_account,null);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        requestQueue = Volley.newRequestQueue(getActivity());
        Toast.makeText(getContext(), "Enter the details", Toast.LENGTH_SHORT).show();
        join = (Button) view.findViewById(R.id.idJoinNow);
        firstName = (EditText) view.findViewById(R.id.idFirstName);
        lastName = (EditText) view.findViewById(R.id.idLastName);
        email = (EditText) view.findViewById(R.id.idEmail);
        password = (EditText) view.findViewById(R.id.idPassword);
        mobile = (EditText) view.findViewById(R.id.idMobileNumber);
        join.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        final String firstname = firstName.getText().toString().trim();
        final String lastname = lastName.getText().toString().trim();
        final String mail = email.getText().toString().trim();
        final String pass = password.getText().toString().trim();
        final String mob = mobile.getText().toString().trim();
        if (firstname.equals("")){
            firstName.setError("Enter First Name");
        }
        if (!mail.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")){
            email.setError("Invalid Email ID");
        }
        if (pass.equals("") || pass.length()<=6){
            password.setError("Enter valid password");
        }
        if (mob.length()!=10){
            mobile.setError("Invalid Mobile Number");
        }
        if (!firstname.equals("") && mail.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+") && !pass.equals("") && pass.length()>=6 && mob.length()==10 ){
            //http req
            final ProgressDialog loading = ProgressDialog.show(getActivity(), "Creating account", "Please wait...", false, false);
            StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConfig.urlCreateAcc,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            //if the server response is success
                            //dismissing the progressbar
                            loading.dismiss();
                           // Toast.makeText(getContext(),response, Toast.LENGTH_SHORT).show();
                            if (response != null)
                            {
                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    Toast.makeText(getContext(),"Your API Key is "+jsonObject.getString("api"), Toast.LENGTH_SHORT).show();
                                    LoginFragment loginFragment = new LoginFragment();
                                    FragmentManager fragmentManager = getFragmentManager();
                                    fragmentManager.beginTransaction().replace(R.id.idScreenArea,loginFragment).commit();
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
                            Toast.makeText(getContext(), "Error occured while creating account", Toast.LENGTH_LONG).show();
                        }
                    }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String, String>();
                    //Adding the parameters
                    params.put("firstName", firstname);
                    params.put("lastName", lastname);
                    params.put("email", mail);
                    params.put("password", pass);
                    params.put("mobile", mob);
                    return params;
                }
            };
            //Adding the request to the queue
            requestQueue.add(stringRequest);
        }
        //
        }
    });

    }
}
