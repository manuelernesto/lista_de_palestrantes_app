package io.github.manuelernesto.listofspeakers.data

import androidx.room.*

@Dao
interface PalestranteDAO {
    @Insert
    suspend fun salvar(palestrante: Palestrante)

    @Query("SELECT * FROM tb_palestrante")
    suspend fun buscarTodos(): List<Palestrante>

    @Update
    suspend fun actualizar(palestrante: Palestrante)

    @Delete
    suspend fun apagar(palestrante: Palestrante)
}