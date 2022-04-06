package uz.gita.quizapp.model.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Computer(
    @PrimaryKey
    val id:Int,
    val question:String,
    val variantA:String,
    val variantB:String,
    val variantC:String,
    val variantD:String,
    val answer:String

)