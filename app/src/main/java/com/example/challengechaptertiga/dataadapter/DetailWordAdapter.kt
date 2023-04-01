package com.example.challengechaptertiga.dataadapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challengechaptertiga.databinding.ItemWordListBinding
    // constructor
class DetailWordAdapter(private val list: List<String>) :
    RecyclerView.Adapter<DetailWordAdapter.ViewHolder>(){
    // ViewHolder digunakan untuk merepresentasikan setiap item pada RecyclerView
    class ViewHolder (private val binding: ItemWordListBinding) :
    RecyclerView.ViewHolder(binding.root) {
        // mengikat data dari setiap item dengan layout ViewHolder.
        fun showBind(list: String){
            binding.btnClick.text = list
            binding.btnClick.setOnClickListener {
                // membuka halaman pencarian Google menggunakan URI yang dibuat
                val getUri = Uri.parse("https://www.google.com/search?q=${list}")
                val intent = Intent(Intent.ACTION_VIEW, getUri)
                itemView.context.startActivity(intent)
            }
        }

    }
    // menghubungkan data dengan ViewHolder  :  Layout tersebut di-inflate dari parent context dan diatur sebagai tampilan dari ViewHolder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemWordListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    // menghubungkan data dengan ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.showBind(list[position])
    // untuk mengembalikan jumlah item pada RecyclerView
    override fun getItemCount(): Int = list.size
}