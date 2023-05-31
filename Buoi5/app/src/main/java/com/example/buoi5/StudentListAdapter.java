package com.example.buoi5;

import android.content.Context;
import android.text.PrecomputedText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.List;

public class StudentListAdapter extends ArrayAdapter {
    int resource;
    List<Student> students;
    public StudentListAdapter(@NonNull Context context, int resource,@NonNull List students)
    {
        super(context, resource, students);
    }

    public View getView(int position, @Nullable View convertView, @NotNull ViewGroup parent)
    {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(this.getContext());
            v = vi.inflate(R.layout.liststudents, null, false);
            v.setLongClickable(true);
        }
        Student s =(Student) getItem(position);
        if (s != null) {
            TextView nameTextView = (TextView) v.findViewById(R.id.tvName);
            TextView dobTextView = (TextView) v.findViewById(R.id.tvDob);
            TextView idTextView = (TextView) v.findViewById(R.id.tvID);
            ImageView avtImageView = (ImageView) v.findViewById(R.id.ivAvt);

            if (nameTextView!= null)
                nameTextView.setText("Name: " + s.getName());
            if (dobTextView!= null)
                dobTextView.setText("Dob: " + s.getDob());
            if (idTextView!= null)
                idTextView.setText("ID: " + s.getId());
            if (avtImageView!= null)
                avtImageView.setImageResource(s.getImage());
        }
        return v;
    }
}
