package org.ipass.com.ipass;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abishek on 16-Apr-18.
 */

public class ResultItemAdapter extends ArrayAdapter{

    List list = new ArrayList();
    public ResultItemAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row;
        row = convertView;
        ResultHolder resultHolder;
        if (row == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.list_row,parent,false);
            resultHolder = new ResultHolder();
            resultHolder.time =(TextView) row.findViewById(R.id.idListTime);
            resultHolder.field1Name =(TextView) row.findViewById(R.id.idListField1Name);
            resultHolder.field2Name =(TextView) row.findViewById(R.id.idListField2Name);
            resultHolder.field3Name =(TextView) row.findViewById(R.id.idListField3Name);
            resultHolder.field4Name =(TextView) row.findViewById(R.id.idListField4Name);
            resultHolder.field5Name =(TextView) row.findViewById(R.id.idListField5Name);
            resultHolder.field6Name =(TextView) row.findViewById(R.id.idListField6Name);
            resultHolder.field1Value =(TextView) row.findViewById(R.id.idListField1Value);
            resultHolder.field2Value =(TextView) row.findViewById(R.id.idListField2Value);
            resultHolder.field3Value =(TextView) row.findViewById(R.id.idListField3Value);
            resultHolder.field4Value =(TextView) row.findViewById(R.id.idListField4Value);
            resultHolder.field5Value =(TextView) row.findViewById(R.id.idListField5Value);
            resultHolder.field6Value =(TextView) row.findViewById(R.id.idListField6Value);
            row.setTag(resultHolder);

        }
        else
        {
            resultHolder = (ResultHolder) row.getTag();
        }
        ResultItems resultItems = (ResultItems)this.getItem(position);
        resultHolder.time.setText(resultItems.getTime());
        resultHolder.field1Name.setText(resultItems.getField1Name());
        resultHolder.field2Name.setText(resultItems.getField2Name());
        resultHolder.field3Name.setText(resultItems.getField3Name());
        resultHolder.field4Name.setText(resultItems.getField4Name());
        resultHolder.field5Name.setText(resultItems.getField5Name());
        resultHolder.field6Name.setText(resultItems.getField6Name());
        resultHolder.field1Value.setText(resultItems.getField1Value());
        resultHolder.field2Value.setText(resultItems.getField2Value());
        resultHolder.field3Value.setText(resultItems.getField3Value());
        resultHolder.field4Value.setText(resultItems.getField4Value());
        resultHolder.field5Value.setText(resultItems.getField5Value());
        resultHolder.field6Value.setText(resultItems.getField6Value());

        return row;
    }

    static class ResultHolder{
        TextView time,field1Name,field2Name,field3Name,field4Name,field5Name,field6Name,field1Value,field2Value,field3Value,field4Value,field5Value,field6Value;
    }

}
