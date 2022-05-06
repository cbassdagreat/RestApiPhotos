package cbass.restapiphotos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cbass.restapiphotos.R
import cbass.restapiphotos.databinding.ItemLayoutBinding
import cbass.restapiphotos.model.Photos
import cbass.restapiphotos.model.PhotosItem
import com.squareup.picasso.Picasso

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.CustomViewHolder>(){
    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val binding = ItemLayoutBinding.bind(itemView)


        fun bindData(photosItem: PhotosItem)
        {
            with(binding)
            {
                Picasso.get().load(photosItem.url).resize(250,250).into(ivPhoto)
                tvName.text=photosItem.title
            }
        }
    }

    var list:List<PhotosItem> = Photos()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindData(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun getData(photos: Photos)
    {
        list = photos
        notifyDataSetChanged()
    }

}