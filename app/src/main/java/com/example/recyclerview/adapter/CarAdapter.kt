package com.example.recyclerview.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerview.R
import com.example.recyclerview.databinding.ItemCarBinding

class CarAdapter(private val list: List<CarModel>) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    inner class CarViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val binding =  ItemCarBinding.bind(view)
        fun bind(model: CarModel){
            Glide.with(binding.imgCar).load(model.img).into(binding.imgCar)
            binding.tvName.text = model.name
            binding.tvYear.text = model.year
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false)
        return CarViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("img", list[position].img)
            bundle.putString("name", list[position].name)
            bundle.putString("year", list[position].year)
            val navController = Navigation.findNavController(holder.itemView)
            navController.navigate(R.id.itemFragment, bundle)
        }
    }
}