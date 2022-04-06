package uz.gita.quizapp.model.Dao

import androidx.room.Dao
import androidx.room.Query
import uz.gita.quizapp.model.Entity.Geography

@Dao
interface GeographyDao {

    @Query("select *from Geography where id = :id")
    fun getGeographyRow(id:Int) : Geography

}