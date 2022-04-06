package uz.gita.quizapp.model.Dao

import androidx.room.Dao
import androidx.room.Query
import uz.gita.quizapp.model.Entity.Computer

@Dao
interface ComputerDao {

    @Query("select *from Computer where id = :id")
    fun getComputerRow(id:Int):Computer
}