package com.example.challengechaptertiga.dataadapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.challengechaptertiga.fragment.FragmentSecond
import com.example.challengechaptertiga.R
import com.example.challengechaptertiga.databinding.ItemWordListBinding
import com.example.challengechaptertiga.databinding.ItemWordListBinding.inflate

class AdapterWord(private val list: List<Char>) :
    RecyclerView.Adapter<AdapterWord.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemWordListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(list: Char) {
            binding.btnClick.text = list.toString()

            binding.btnClick.setOnClickListener {
                // instance
                val bundle = Bundle().apply {
                    putString("EXTRA_WORD", list.toString())
                }
                // memanggil id action nav graph
                it.findNavController()
                    .navigate(R.id.action_fragmentFirst_to_fragmentSecond, bundle)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(inflate(LayoutInflater.from(parent.context), parent, false))



    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount(): Int = list.size
}

//class AdapterWord(private val list: List<Char>) :
//    RecyclerView.Adapter<AdapterWord.ViewHolder>() {
//
//    inner class ViewHolder(private val binding: ItemWordListBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//        fun bind(list: Char) {
//            binding.btnClick.text = list.toString()
//
//            binding.btnClick.setOnClickListener {
//                val appCompAct = it.context as AppCompatActivity
//                val fragmentManager = appCompAct.supportFragmentManager
//                val detailWordFragment = FragmentSecond()
//                val fragment =
//                    fragmentManager.findFragmentByTag(FragmentSecond::class.java.simpleName)
//
//                if (fragment !is FragmentSecond) {
//                    val bundle = Bundle()
//                    bundle.putString("EXTRA_WORD", list.toString())
//                    detailWordFragment.arguments = bundle
//
//                    fragmentManager
//                        .beginTransaction()
//                        .replace(
//                            R.id.frameMain,
//                            detailWordFragment,
//                            FragmentSecond::class.java.simpleName
//                        )
//                        .addToBackStack(null).commit()
//                }
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        val binding = ItemWordListBinding.inflate(inflater, parent, false)
//        return ViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
//        holder.bind(list[position])
//
//    override fun getItemCount(): Int = list.size
//}