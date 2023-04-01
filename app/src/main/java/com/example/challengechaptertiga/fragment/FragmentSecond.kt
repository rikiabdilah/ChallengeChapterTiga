package com.example.challengechaptertiga.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challengechaptertiga.ListData
import com.example.challengechaptertiga.dataadapter.DetailWordAdapter
import com.example.challengechaptertiga.databinding.FragmentSecondBinding

class FragmentSecond : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val strain: List<String> =
            ListData.dataList.filter { it.startsWith(arguments?.getString("EXTRA_WORD")!!, true) }
        binding.apply {
            rvTwo.adapter = DetailWordAdapter(strain)
            rvTwo.layoutManager = LinearLayoutManager(requireContext())
            rvTwo.setHasFixedSize(true)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}