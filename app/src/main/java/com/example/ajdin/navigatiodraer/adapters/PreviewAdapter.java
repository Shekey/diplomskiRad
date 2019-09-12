package com.example.ajdin.navigatiodraer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ajdin.navigatiodraer.R;
import com.example.ajdin.navigatiodraer.models.PreviewModel;

import java.text.DecimalFormat;
import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by ajdin on 28.3.2018..
 */

public class PreviewAdapter extends ArrayAdapter {

    private List<PreviewModel> movieModelList;
    private int resource;
    private LayoutInflater inflater;

    public PreviewAdapter(Context context, int resource, List<PreviewModel> objects) {
        super(context, resource, objects);
        movieModelList = objects;
        this.resource = resource;
        inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(resource, null);

            holder.tvMovie = convertView.findViewById(R.id.tvMovie);
            holder.tvTagline = convertView.findViewById(R.id.tvTagline);
            holder.tvYear = convertView.findViewById(R.id.tvYear);
            holder.tvUkupno = convertView.findViewById(R.id.tvUkupno);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final ViewHolder finalHolder = holder;


        holder.tvMovie.setText(movieModelList.get(position).getNaziv());
        holder.tvTagline.setText("Cijena: " + movieModelList.get(position).getCijena() + " KM");
        holder.tvYear.setText("Količina: " + movieModelList.get(position).getKolicina());
        double ukupno = Double.valueOf(movieModelList.get(position).getCijena()) * Double.valueOf(movieModelList.get(position).getKolicina());
        DecimalFormat dec = new DecimalFormat("#0.00");
        holder.tvUkupno.setText("Ukupno: " + String.valueOf(dec.format(ukupno)) + " KM");
        return convertView;
    }


    class ViewHolder {
        private TextView tvMovie;
        private TextView tvTagline;
        private TextView tvYear;
        private TextView tvUkupno;
    }
}