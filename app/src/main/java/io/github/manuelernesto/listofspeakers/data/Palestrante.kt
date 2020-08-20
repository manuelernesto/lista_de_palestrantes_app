package io.github.manuelernesto.listofspeakers.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "tb_palestrante")
data class Palestrante(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "nome_palestrante")
    val palestrante: String,
    val tecnologia: String,
    val topico: String
):Serializable