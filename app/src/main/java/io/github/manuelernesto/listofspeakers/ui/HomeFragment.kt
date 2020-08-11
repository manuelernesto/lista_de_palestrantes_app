package io.github.manuelernesto.listofspeakers.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import io.github.manuelernesto.listofspeakers.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false).apply {

           val btnPalestrante = findViewById<Button>(R.id.btnPalestrante)
            btnPalestrante.setOnClickListener {
                findNavController().navigate(R.id.to_speakersFragment)
            }

        }
    }
}