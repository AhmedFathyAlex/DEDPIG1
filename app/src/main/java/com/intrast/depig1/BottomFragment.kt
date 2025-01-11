package com.intrast.depig1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.intrast.depig1.databinding.FragmentBottomBinding


class BottomFragment : Fragment() {
    lateinit var binding: FragmentBottomBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = FragmentBottomBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = arguments?.getString("name")
        updateText(name ?: "Empty")

        binding.endButton.setOnClickListener {
            findNavController().navigate(R.id.action_bottomFragment2_to_finalFragment)
        }
    }


    fun updateText(name:String){
        binding.textView.text = name
    }


    companion object {

        fun newInstance(name: String) : BottomFragment {
            val bottomFragment = BottomFragment()
            val bundle = Bundle()
            bundle.putString("name",name)
            bottomFragment.arguments = bundle
            return bottomFragment
        }

    }
}