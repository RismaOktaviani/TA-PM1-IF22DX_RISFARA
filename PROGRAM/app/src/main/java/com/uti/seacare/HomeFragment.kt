package com.uti.seacare

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uti.seacare.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.buttonNext.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().addToBackStack(null).replace(R.id.frm_layout, BtnFragment()).commit()
        }
        return binding.root
    }

    companion object {

    }
}