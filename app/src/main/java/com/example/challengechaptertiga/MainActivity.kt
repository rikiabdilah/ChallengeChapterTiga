package com.example.challengechaptertiga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.challengechaptertiga.fragment.FragmentFirst

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val homeFragment = FragmentFirst()
        val fragment = fragmentManager.findFragmentByTag(FragmentFirst::class.java.simpleName)

        if (fragment !is FragmentFirst){
            fragmentManager
                .beginTransaction().add(R.id.frameMain, homeFragment, FragmentFirst::class.java.simpleName)
                .commit() // menyelesaikan transaksi dan menampilkan fragment ke dalam container.
        }
    }
}