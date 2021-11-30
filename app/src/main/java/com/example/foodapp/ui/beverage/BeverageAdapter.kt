package com.example.foodapp.ui.beverage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.foodapp.R
import com.example.foodapp.databinding.ItemBeverageBinding
import com.example.foodapp.model.Beverage

class BeverageAdapter (private val listBeverage: ArrayList<Beverage>) : RecyclerView.Adapter<BeverageAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = ItemBeverageBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_beverage,
            parent,
            false
        )
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val beverage = listBeverage[position]
        var isFav = setFav() ?: false

        Glide.with(holder.itemView.context)
            .load(beverage.image)
            .apply(RequestOptions().override(100, 100))
            .into(holder.binding.imgGambar)

        holder.binding.txtName.text = beverage.name
        holder.binding.txtDescrption.text = beverage.description
        holder.binding.btnFav.setOnClickListener {
            if(isFav){
                //update fav
                holder.binding.btnFav.setBackgroundResource(R.drawable.ic_fav_false)
            } else{
                //update fav
                holder.binding.btnFav.setBackgroundResource(R.drawable.ic_fav_true)
            }
            isFav = !isFav
        }
    }

    private fun setFav(): Boolean? {
        return false
    }

    override fun getItemCount(): Int {
        return listBeverage.size
    }
}