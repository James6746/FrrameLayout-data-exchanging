package com.example.fragmentjaxadevpractice

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.RuntimeException

class BFragment : Fragment() {
    private lateinit var et_b_send_message: EditText
    private lateinit var tv_b_recevied_message: TextView
    private lateinit var btn_b_send: Button
    private var bListener: BListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_b, container, false)

        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        et_b_send_message = view.findViewById(R.id.et_b_send_message)
        tv_b_recevied_message = view.findViewById(R.id.tv_b_recevied_message)
        btn_b_send = view.findViewById(R.id.btn_b_send)

        btn_b_send.setOnClickListener {
            bListener?.onBSend(et_b_send_message.text.toString())

        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BListener) {
            bListener = context
        } else {
            throw RuntimeException(context.toString() + " must implement BListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        bListener = null
    }

    fun updateBFragment(str: String) {
        tv_b_recevied_message.text = str
    }

    //public fun updateAFragment(str: String)

    interface BListener {
        fun onBSend(str: String)
    }

}