package com.example.fragmentjaxadevpractice

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AlphabetIndexer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.RuntimeException

class AFragment : Fragment() {
    private lateinit var et_a_send_message: EditText
    private lateinit var tv_a_recevied_message: TextView
    private lateinit var btn_a_send: Button
    private var aListener: AListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_a, container, false)

        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        et_a_send_message = view.findViewById(R.id.et_a_send_message)
        tv_a_recevied_message = view.findViewById(R.id.tv_a_recevied_message)
        btn_a_send = view.findViewById(R.id.btn_a_send)

        btn_a_send.setOnClickListener {
            aListener?.onASend(et_a_send_message.text.toString())

        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is AListener) {
            aListener = context
        } else {
            throw RuntimeException(context.toString() + " must implement AListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        aListener = null
    }

    fun updateAFragment(str: String) {
        tv_a_recevied_message.text = str
    }


    interface AListener {
        fun onASend(str: String)
    }

}