package com.miranda.laboratorio05.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.miranda.laboratorio05.R
import com.miranda.laboratorio05.databinding.FragmentBillboardBinding
import com.miranda.laboratorio05.databinding.FragmentMovieBinding

class BillboardFragment : Fragment() {
    private lateinit var btnCreateNewMovie: FloatingActionButton
    private lateinit var starWarsCv: CardView
    private lateinit var harryPotterCv: CardView

    private lateinit var binding: FragmentBillboardBinding

    private val viewModel: MovieViewModel by activityViewModels{
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBillboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnCreateNewMovie = view.findViewById(R.id.btnNavCreateNewMovie)
        starWarsCv = view.findViewById(R.id.starWarsCardView)
        harryPotterCv = view.findViewById(R.id.harryPotterCardView)


        starWarsCv.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
        }

        harryPotterCv.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
        }

        btnCreateNewMovie.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment_to_newMovieFragment)
        }

        Log.d("Movies", viewModel.getMovies().toString())
    }
}
