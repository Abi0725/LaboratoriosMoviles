package com.miranda.laboratorio05.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.miranda.laboratorio05.R

class BillboardFragment : Fragment() {

    private lateinit var actionNavToCreateMovie: FloatingActionButton
    private lateinit var actionNavToMovie: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_billboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind(view)

        actionNavToCreateMovie.setOnClickListener {
            view.findNavController().navigate(R.id.action_billboardFragment_to_newMovieFragment)
        }

        actionNavToMovie.setOnClickListener{
            view.findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
        }
    }

    private fun bind (view: View) {
        actionNavToMovie = view.findViewById(R.id.cardView_action_info)
        actionNavToCreateMovie = view.findViewById(R.id.action_toCreat_movie)
    }
}