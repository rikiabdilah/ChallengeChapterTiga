package com.example.challengechaptertiga.fragment

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challengechaptertiga.R
import com.example.challengechaptertiga.dataadapter.AdapterWord
import com.example.challengechaptertiga.databinding.FragmentFirstBinding

class FragmentFirst : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private var isListMode = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            // membuat list char dari A sampai L
            rvHome.adapter = AdapterWord(('A').rangeTo('L').toList())
            rvHome.layoutManager = LinearLayoutManager(requireContext())
            rvHome.setHasFixedSize(true)
        }
        switchMode()
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.my_menu, menu)
                changeIcon(menu.findItem(R.id.switchMode))
            }
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.switchMode -> {
                        isListMode = !isListMode
                        switchMode()
                        changeIcon(menuItem)

                        return true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
    private fun changeIcon(menuItem: MenuItem?) {
        menuItem?.icon =
            if (isListMode)
                ContextCompat.getDrawable(this.requireContext(), R.drawable.baseline_grid_view_24)
            else ContextCompat.getDrawable(this.requireContext(), R.drawable.baseline_view_list_24)
    }
    private fun switchMode() {
        binding.rvHome.layoutManager =
            if (isListMode)
                LinearLayoutManager(requireContext())
            else
                GridLayoutManager(requireContext(), 2)
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}