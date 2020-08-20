package io.github.manuelernesto.listofspeakers.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import io.github.manuelernesto.listofspeakers.R
import io.github.manuelernesto.listofspeakers.data.Palestrante
import kotlinx.android.synthetic.main.palestrante_item.view.*

class PalestranteAdapter(private val palestrantes: List<Palestrante>) :
    RecyclerView.Adapter<PalestranteAdapter.PalestranteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PalestranteViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.palestrante_item, parent, false)
    )

    override fun onBindViewHolder(holder: PalestranteViewHolder, position: Int) {
        holder.view.room_item_txt_nome.text = palestrantes[position].palestrante
        holder.view.room_item_txt_tecnologia.text = palestrantes[position].tecnologia
        holder.view.room_item_txt_topico.text = palestrantes[position].topico

        holder.view.setOnClickListener {
            val action = HomeFragmentDirections.toSpeakersFragment()
            action.palestrante = palestrantes[position]
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount() = palestrantes.size

    class PalestranteViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}