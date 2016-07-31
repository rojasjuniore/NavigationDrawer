package com.rojasjuniore.rojasjuniore;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Junior on 30/07/2016.
 */

public class RojasjunioreAdapter extends ArrayAdapter<Rojasjuniore> {
    Context mycontext;
    int myLayoutResourceId;
    Rojasjuniore mydata[] = null;

    public RojasjunioreAdapter(Context context, int layoutResourceId, Rojasjuniore[] data) {
        super(context, layoutResourceId, data);
        this.mycontext = context;
        this.myLayoutResourceId = layoutResourceId;
        this.mydata = data;
    }


    public View getView(int position, View converView, ViewGroup parenrt) {
        View row = converView;
        rojasjunioreHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = ((Activity) mycontext).getLayoutInflater();
            row = inflater.inflate(myLayoutResourceId, parenrt, false);

            holder = new rojasjunioreHolder();
            holder.textView = (TextView) row.findViewById(R.id.name);
            holder.imageView = (ImageView) row.findViewById(R.id.icon);
            row.setTag(holder);
        } else {
            holder = (rojasjunioreHolder) row.getTag();
        }

        Rojasjuniore rojasjuniore = mydata[position];
        holder.textView.setText(rojasjuniore.title);
        holder.imageView.setImageResource(rojasjuniore.Icon);

        return row;
    }

    static class rojasjunioreHolder {
        ImageView imageView;
        TextView textView;
    }

}
