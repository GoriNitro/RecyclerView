package com.example.recyclerview.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.recyclerview.R
import com.example.recyclerview.databinding.FragmentItemBinding

class ItemFragment : Fragment() {
    private val binding: FragmentItemBinding by lazy {
        FragmentItemBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val img = arguments?.getString("img")
        val name = arguments?.getString("name")
        val year = arguments?.getString("year")

        binding.tvName.text = name
        binding.tvYear.text = year
        Glide.with(binding.imgCar).load(img).into(binding.imgCar)
    }
}