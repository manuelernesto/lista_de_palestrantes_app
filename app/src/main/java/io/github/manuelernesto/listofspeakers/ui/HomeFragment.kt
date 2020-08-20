package io.github.manuelernesto.listofspeakers.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.manuelernesto.listofspeakers.R
import io.github.manuelernesto.listofspeakers.data.PalestranteDB
import io.github.manuelernesto.listofspeakers.util.StandardFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch

class HomeFragment : StandardFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rv_room.setHasFixedSize(true)
        rv_room.layoutManager = LinearLayoutManager(context)

        launch {
            context?.let {
                val palestrantes = PalestranteDB.getDatabase(it).dao().buscarTodos()
                rv_room.adapter =  PalestranteAdapter(palestrantes)
            }
        }
    }
}