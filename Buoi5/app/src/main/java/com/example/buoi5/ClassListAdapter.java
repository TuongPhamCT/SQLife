package com.example.buoi5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ClassListAdapter extends ArrayAdapter {
    int resource;
    List<Classes> classes;
    public ClassListAdapter(@NonNull Context context, int resource,@NonNull List classes)
    {
        super(context, resource, classes);
    }

    public View getView(int position, @Nullable View convertView, @NotNull ViewGroup parent)
    {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(this.getContext());
            v = vi.inflate(R.layout.listclasses, null, false);
        }
        Classes s =(Classes) getItem(position);
        int stt = position + 1;
        if (s != null) {
            TextView idTextView = (TextView) v.findViewById(R.id.classid);
            TextView nameTextView = (TextView) v.findViewById(R.id.classname);
            TextView stuTextView = (TextView) v.findViewById(R.id.classstudents);
            TextView sttTextView = (TextView) v.findViewById(R.id.sttclass);

            if (nameTextView!= null)
                nameTextView.setText(s.getNameclass());
            if (idTextView!= null)
                idTextView.setText(s.getIdclass());
            if (stuTextView!= null)
                stuTextView.setText(String.valueOf(s.getStuclass()));
            if (sttTextView != null)
                sttTextView.setText("#" + stt);
        }
        return v;
    }
}
