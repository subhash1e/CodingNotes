package com.subhash1e.codingnotes;

import static androidx.core.content.ContextCompat.startActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getSupportActionBar()!=null)
        getSupportActionBar().hide();
        ImageView image = findViewById(R.id.ivBanner);
        //testing
        String url = "https://picsum.photos/900/200";
        Picasso.with(this)
                .load(url)
                .into(image);


        //get instance of view adapter
  String[] topics ={"C","C++","Python","Java","Kotlin","SQL","CN","OS","DBMS","OOPS","HR"};

        CustomAdapter mRVAdapter = new CustomAdapter(topics);
        RecyclerView rvTopics;
        rvTopics = findViewById(R.id.rvCourses);
//        rvTopics.setLayoutManager(new LinearLayoutManager(this));
        rvTopics.setLayoutManager(new GridLayoutManager(this,3));
        rvTopics.setAdapter(mRVAdapter);

    }
}


class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private String[] localDataSet;
//    private static ClickListener clickListener;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            textView = (TextView) view.findViewById(R.id.tvCourse);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public CustomAdapter(String[] dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list itemjujkk;
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_course, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),NotesListActivity.class);
                intent.putExtra("course",localDataSet[viewHolder.getAdapterPosition()]);
                startActivity(view.getContext(),intent,null);
            }
        });
        viewHolder.getTextView().setText(localDataSet[position]);
    }
   /* public void setOnItemClickListener(ClickListener clickListener) {
        PasswordAdapter.clickListener = clickListener;
    }*/
    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}

