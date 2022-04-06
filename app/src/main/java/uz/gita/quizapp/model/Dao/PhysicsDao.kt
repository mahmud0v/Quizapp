package uz.gita.quizapp.model.Dao

import androidx.room.Dao
import androidx.room.Query
import uz.gita.quizapp.model.Entity.Physics

@Dao
interface PhysicsDao {

    @Query("select *from Physics where id =:id")
    fun getPhysicsRow(id:Int):Physics

}