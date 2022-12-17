package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class GovernmentAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Government> listGovernment;

    public GovernmentAdapter(Context context, int layout, List<Government> listGovernment) {
        this.context = context;
        this.layout = layout;
        this.listGovernment = listGovernment;
    }

    @Override
    public int getCount() {
        return listGovernment.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder {
        TextView txtName;
        TextView txtRole;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout, null);

            viewHolder = new ViewHolder();
            viewHolder.txtName = view.findViewById(R.id.txtName);
            viewHolder.txtRole = view.findViewById(R.id.txtRole);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Government gov = listGovernment.get(i);
        viewHolder.txtName.setText(gov.getName() + "(" + gov.getParty() + ")");
        viewHolder.txtRole.setText(gov.getNameRole());


        return view;
    }
}

