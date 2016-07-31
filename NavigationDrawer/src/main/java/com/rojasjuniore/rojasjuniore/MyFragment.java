package com.rojasjuniore.rojasjuniore;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {

    public final static String KEY_TEXT = "key_text";
    public final static String KEY_INT = "key_int";
    private String mText;
    private int i;

    public MyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mText = getArguments().getString(KEY_TEXT);
// Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_my, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.tv_fragment);
        textView.setText(mText);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.imageViewFrament);
        i = Integer.parseInt(getArguments().getString(KEY_INT));
        switch (i) {
            case 0:
                imageView.setImageResource(R.drawable.ic_launcher);
                break;
            case 1:
                imageView.setImageResource(R.drawable.ford_mondeo);
                break;
            case 2:
                imageView.setImageResource(R.drawable.jaguar_f_type_2015);
                break;
            case 3:
                imageView.setImageResource(R.drawable.mazda_mx5_2015);
                break;
            case 4:
                imageView.setImageResource(R.drawable.mercedes_benz_amg_gt);
                break;
            case 5:
                imageView.setImageResource(R.drawable.porsche_911_gts);
                break;
            case 6:
                imageView.setImageResource(R.drawable.seat_leon_st_cupra);
                break;
            case 7:
                imageView.setImageResource(R.drawable.volvo_v60_crosscountry);
                break;
            case 8:
                imageView.setImageResource(R.drawable.volkswagen_golf_r_variant_2015);
                break;

        }

        return rootView;
    }

}
