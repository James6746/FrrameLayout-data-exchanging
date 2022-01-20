package com.example.fragmentjaxadevpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainer

class MainActivity : AppCompatActivity(), AFragment.AListener, BFragment.BListener {
    lateinit var aFragment: AFragment
    lateinit var bFragment: BFragment

    private lateinit var mainContainer: FragmentContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        aFragment = AFragment()
        bFragment = BFragment()

        supportFragmentManager.beginTransaction().replace(R.id.frame_a_mainActivity, aFragment)
            .replace(R.id.frame_b_mainActivity, bFragment).commit()

    }

    override fun onASend(str: String) {
        bFragment.updateBFragment(str)
    }

    override fun onBSend(str: String) {
        aFragment.updateAFragment(str)
    }
}