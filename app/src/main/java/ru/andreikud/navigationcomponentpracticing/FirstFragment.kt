package ru.andreikud.navigationcomponentpracticing

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions

class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btnClick).setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment("Hello!")
            findNavController().navigate(action, navOptions {
                anim {
                    enter = android.R.anim.fade_in
                    exit = android.R.anim.fade_out
                }
            })
        }
    }

}