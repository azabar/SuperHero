package app.org.superhero.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.org.superhero.data.model.CharacterModel
import app.org.superhero.R
import com.bumptech.glide.Glide

class CustomAdapter(private val onItemClicked: (position: Int) -> Unit) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private var dataSet: List<CharacterModel> = emptyList()

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View,
                     private val onItemClicked: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(view), View.OnClickListener  {
        val nameTextView: TextView
        val imageView: ImageView

        init {
            view.setOnClickListener(this)
            // Define click listener for the ViewHolder's View.
            nameTextView = view.findViewById(R.id.name_view_item)
            imageView = view.findViewById(R.id.image_view_item)
        }

        override fun onClick(v: View) {
            val position = adapterPosition
            onItemClicked(position)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.row_item, viewGroup, false)

        return ViewHolder(view, onItemClicked)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.nameTextView.text = dataSet[position].name
        var thumbnail = dataSet[position].thumbnail
        Glide.with(viewHolder.imageView.context).load(thumbnail.path + "." + thumbnail.extension).into(viewHolder.imageView)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    fun setMovieList(dataSet: List<CharacterModel>) {
        this.dataSet = dataSet
        notifyDataSetChanged()
    }

}