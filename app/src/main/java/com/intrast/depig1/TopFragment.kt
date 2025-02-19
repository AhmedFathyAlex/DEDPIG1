package com.intrast.depig1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.intrast.depig1.databinding.FragmentTopBinding


class TopFragment : Fragment() {
    lateinit var binding: FragmentTopBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTopBinding.inflate(inflater,container,false)
        return  binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.submit.setOnClickListener {
            val name = binding.editText.text.toString()

            if (activity is MainActivity){
                (activity as MainActivity).getData(name)
            }else if(activity is SecondActivity){
                (activity as SecondActivity).getData(name)
            }else if(activity is ThirdActivity){
                val bundle = Bundle()
                bundle.putString("name",name)
                findNavController().navigate(R.id.action_topFragment2_to_bottomFragment2,bundle)
            }

            binding.editText.text.clear()
        }
    }


}