package com.interaktive.test.model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.interaktive.test.mytestinterrative.R;

import java.util.List;

public class ListeUssAdapter extends BaseAdapter {
    Context context;
    List<Usssd> rowItems;

    public ListeUssAdapter(Context context, List<Usssd> rowItems) {
        this.context = context;
        this.rowItems = rowItems;
    }

    private class ViewHolder {
        TextView txtTitle;
        TextView txtDesc;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.ussd_item, null);
            holder = new ViewHolder();
            holder.txtTitle = (TextView) convertView.findViewById(R.id.ussdtitle);
            holder.txtDesc = (TextView) convertView.findViewById(R.id.ussddesc);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        Usssd rowItem = (Usssd) getItem(position);
        holder.txtDesc.setText(rowItem.getUssdCode());
        holder.txtTitle.setText(rowItem.getName());
        return convertView;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }
}
