package com.example.ajdin.navigatiodraer.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.ajdin.navigatiodraer.R;
import com.example.ajdin.navigatiodraer.models.Product;

import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by ajdin on 13.3.2018..
 */

public class SnizenoAdapter extends ArrayAdapter {

    private List<Product> movieModelList;
    private int resource;
    private LayoutInflater inflater;

    public SnizenoAdapter(Context context, int resource, List<Product> objects) {
        super(context, resource, objects);
        movieModelList = objects;
        this.resource = resource;
        inflater = (LayoutInflater) getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(resource, null);
            holder.ivMovieIcon = convertView.findViewById(R.id.ivIconSn);
            holder.tvMovie = convertView.findViewById(R.id.tvMovieSn);
            holder.tvTagline = convertView.findViewById(R.id.tvTaglineSn);
            holder.tvYear = convertView.findViewById(R.id.tvYearSn);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final ProgressBar progressBar = convertView.findViewById(R.id.progressBar);

        final ViewHolder finalHolder = holder;
        Bitmap bMap = BitmapFactory.decodeFile(movieModelList.get(position).getImageDevice());
        holder.ivMovieIcon.setImageBitmap(bMap);
        progressBar.setVisibility(View.GONE);
        holder.tvMovie.setText(movieModelList.get(position).getNaziv());
        holder.tvTagline.setText(movieModelList.get(position).getKategorija());
        holder.tvYear.setText("Cijena: " + movieModelList.get(position).getCijena() + " KM");
        return convertView;
    }

    class ViewHolder {
        private ImageView ivMovieIcon;
        private TextView tvMovie;
        private TextView tvTagline;
        private TextView tvYear;
    }

}