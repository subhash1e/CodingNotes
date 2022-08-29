package com.subhash1e.codingnotes

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NotesListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_list)
        supportActionBar?.hide()
        val tvCourseHeader = findViewById<TextView>(R.id.tvCourseHeader)
        val rvList = findViewById<RecyclerView>(R.id.recyclerViewList)
        val course = intent.extras!!["course"] as String
        var ls = mutableListOf<String>()
        val xx = mutableMapOf<String,MutableList<String>>()
        xx["C"] = mutableListOf("Complete Note")
        xx["C++"] = mutableListOf("Complete Note")
        xx["Python"] = mutableListOf("Complete Note")
        xx["Java"] = mutableListOf("Complete Note")
        xx["Kotlin"] = mutableListOf("Complete Note")
        xx["SQL"] = mutableListOf("Complete Note")
        xx["OS"] = mutableListOf("Complete Note")
        xx["CN"] = mutableListOf("Complete Note")
        xx["DBMS"] = mutableListOf("Complete Note")
        xx["OOPS"] = mutableListOf("Complete Note")
        xx["HR"] = mutableListOf("How to Answer The 64 Toughest Interview Questions | OHSU")
        for(x in xx){
            if(x.key == course){
                ls = x.value
                break
            }
        }
        tvCourseHeader.text = course
        rvList.layoutManager = GridLayoutManager(this,1);
        rvList.adapter = CustomAdapter2(ls.toTypedArray(),course)

    }

}
/**
 * Initialize the dataset of the Adapter.
 *
 * @param dataSet String[] containing the data to populate views to be used
 * by RecyclerView.
 */

internal class CustomAdapter2(private val localDataSet: Array<String>, private val course: String) :
    RecyclerView.Adapter<CustomAdapter2.ViewHolder>() {
    //    private static ClickListener clickListener;
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            // Define click listener for the ViewHolder's View
            textView = view.findViewById<View>(R.id.tvFileName) as TextView
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list itemjujkk;
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_rows, viewGroup, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.itemView.setOnClickListener { view ->
            val intent = Intent(view.context, DisplayNoteActivity::class.java)
            intent.putExtra("fileName", localDataSet[viewHolder.adapterPosition])
            intent.putExtra("course", course)
            ContextCompat.startActivity(view.context, intent, null)
        }
        viewHolder.textView.text = localDataSet[position]
    }

    /* public void setOnItemClickListener(ClickListener clickListener) {
        PasswordAdapter.clickListener = clickListener;
    }*/
    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return localDataSet.size
    }
}

