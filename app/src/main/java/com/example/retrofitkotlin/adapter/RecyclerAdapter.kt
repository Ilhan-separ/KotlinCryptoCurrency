package com.example.retrofitkotlin.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitkotlin.R
import com.example.retrofitkotlin.databinding.RecyclerRowBinding
import com.example.retrofitkotlin.model.CryptoModel

class RecyclerAdapter(private val cryptoList: ArrayList<CryptoModel>,private val listener: Listener) : RecyclerView.Adapter<RecyclerAdapter.RowHolder>() {

    private val colors : Array<String> = arrayOf("#ebc83d","#badf55","#35b1c9","#b06dad","#e96060","#5d0296")
    interface  Listener{
        fun onItemClick(cryptoModel: CryptoModel)
    }

    class RowHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(cryptoModel: CryptoModel,colors : Array<String>,position: Int,listener: Listener){
            binding.root.setOnClickListener{
                listener.onItemClick(cryptoModel)
            }
            binding.root.setBackgroundColor(Color.parseColor(colors[position % 6]))
            binding.textViewName.text = cryptoModel.currency
            binding.textViewPrice.text = cryptoModel.price
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RowHolder(view)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(cryptoList[position],colors, position,listener)


    }

    override fun getItemCount(): Int {
       return cryptoList.size
    }

}