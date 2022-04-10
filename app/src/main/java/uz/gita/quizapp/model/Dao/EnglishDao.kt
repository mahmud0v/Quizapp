package uz.gita.quizapp.model.Dao

import androidx.room.Dao
import androidx.room.Query
import uz.gita.quizapp.model.Entity.English

@Dao
interface EnglishDao {

    @Query("select * from English where id = :id")
    fun getEnglishRow(id: Int): English




}