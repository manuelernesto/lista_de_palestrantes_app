package io.github.manuelernesto.listofspeakers.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation
import io.github.manuelernesto.listofspeakers.R
import io.github.manuelernesto.listofspeakers.data.Palestrante
import io.github.manuelernesto.listofspeakers.data.PalestranteDB
import io.github.manuelernesto.listofspeakers.util.StandardFragment
import kotlinx.android.synthetic.main.fragment_speakers.*
import kotlinx.coroutines.launch

class SpeakersFragment : StandardFragment() {

    private var mPalestrante: Palestrante? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_speakers, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        arguments?.let {
            mPalestrante = SpeakersFragmentArgs.fromBundle(it).palestrante
            room_et_nome.setText(mPalestrante?.palestrante)
            room_et_tecnologia.setText(mPalestrante?.tecnologia)
            room_et_topico.setText(mPalestrante?.topico)
        }

        room_btn_salvar.setOnClickListener {
            val palestrante = Palestrante(
                palestrante = room_et_nome.text.toString(),
                tecnologia = room_et_tecnologia.text.toString(),
                topico = room_et_topico.text.toString()
            )

            launch {
                context?.let {
                    if (mPalestrante != null) {
                        palestrante.id = mPalestrante!!.id
                        PalestranteDB.getDatabase(it).dao().actualizar(palestrante)
                        Toast.makeText(it, "Palestrante actualizado!", Toast.LENGTH_SHORT).show()
                    } else {
                        PalestranteDB.getDatabase(it).dao().salvar(palestrante)
                        Toast.makeText(it, "Cadastro com sucesso!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        if (mPalestrante != null) {
            room_btn_apagar.visibility = View.VISIBLE
            room_btn_apagar.setOnClickListener {
                apagarPalestrante()
            }
        }

    }

    private fun apagarPalestrante() {
        AlertDialog.Builder(requireContext()).apply {
            setTitle("Deseja realmente apagar?")
            setNegativeButton("Não") { _, _ ->

            }
            setPositiveButton("Sim") { _, _ ->
                launch {
                    context.let {
                        PalestranteDB.getDatabase(it).dao().apagar(mPalestrante!!)
                        val action = SpeakersFragmentDirections.toHomeFragment()
                        Navigation.findNavController(requireView()).navigate(action)
                    }
                }
            }
        }.create().show()
    }
}
