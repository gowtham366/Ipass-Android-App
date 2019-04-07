package org.ipass.com.ipass;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Abishek on 16-Apr-18.
 */

public class PublicListView extends Fragment {
    String response;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_list_view,null);
        Bundle bundle = getArguments();
        if (bundle!=null){
            response = bundle.getString("response");
            //Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
        }
        if (response != null)
        {
            try {
                JSONObject jsonObject1 = new JSONObject(response);
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
                for (int i=0; i<arrfieldValues.length(); i++){
                    JSONObject obj = arrfieldValues.getJSONObject(i);
                    String time = obj.getString("time");
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

        Toast.makeText(getContext(), "Fetching Success!!!", Toast.LENGTH_SHORT).show();

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
