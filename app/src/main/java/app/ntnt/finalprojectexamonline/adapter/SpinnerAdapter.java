package app.ntnt.finalprojectexamonline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.model.entites.Topic;

public class SpinnerAdapter extends ArrayAdapter<Topic> {

    private List<Topic> topics;
    private LayoutInflater inflater;

    public SpinnerAdapter(Context context, List<Topic> topics) {
        super(context, 0, topics);
        this.topics = topics;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(android.R.layout.simple_spinner_item, parent, false);
        }
        TextView tvSubjectName = view.findViewById(android.R.id.text1);
        tvSubjectName.setText(topics.get(position).getName());
        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        RecyclerView.ViewHolder viewHolder;
        if (view == null) {
            view = inflater.inflate(R.layout.spinner_item_checkbox, parent, false);
        }
        TextView tvSubjectName = view.findViewById(R.id.textview);
        tvSubjectName.setText(topics.get(position).getName());
        CheckBox checkBox = view.findViewById(R.id.checkbox);


        return view;
    }
}

