package com.mysourcecodesandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    Context context;
    String headList[];
    String descriptionList[];
    int pictures[];
    LayoutInflater inflater;

    public CustomAdapter(Context applicationContext, String[] headList, String[] descriptionList, int[] pictures) {
        this.context = context;
        this.headList = headList;
        this.descriptionList = descriptionList;
        this.pictures = pictures;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return descriptionList.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_main_listview, null);
        TextView head = (TextView) convertView.findViewById(R.id.txtHeadListView);
        TextView description = (TextView) convertView.findViewById(R.id.txtMainListView);
        ImageView imgViewIcon = (ImageView) convertView.findViewById(R.id.imgViewIcon);
        head.setText(headList[position]);
        description.setText(descriptionList[position]);
        imgViewIcon.setImageResource(pictures[position]);
        return convertView;
    }
}
