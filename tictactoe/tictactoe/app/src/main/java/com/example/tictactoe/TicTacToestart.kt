package com.example.tictactoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tictactoe.databinding.FragmentTicTacToestartBinding

class TicTacToestart : Fragment(),View.OnClickListener {
    lateinit var binding: FragmentTicTacToestartBinding
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tic_tac_toestart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController=Navigation.findNavController(view)
        binding=FragmentTicTacToestartBinding.bind(view)
        binding.btnstr.setOnClickListener(this)
        binding.btnabt.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!){
            binding.btnstr->{navController!!.navigate(R.id.action_ticTacToestart_to_ticTacToeplay)

            }
            binding.btnabt->{navController!!.navigate(R.id.action_ticTacToestart_to_ticTacToeabout)

            }
        }

    }

}