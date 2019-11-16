package com.example.gopariapp

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_feeds.*


/**
 * A simple [Fragment] subclass.
 */
class FragmentFeeds : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fabFeeds.setOnClickListener {
            val matematikaIntent = Intent(requireActivity(), NewFeedsActivity::class.java)
            requireActivity().startActivity(matematikaIntent)
        }
    }

}// Required empty public constructor
