package uz.gita.quizapp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.gita.quizapp.model.Dao.ComputerDao
import uz.gita.quizapp.model.Dao.EnglishDao
import uz.gita.quizapp.model.Dao.GeographyDao
import uz.gita.quizapp.model.Dao.PhysicsDao
import uz.gita.quizapp.model.Entity.Computer
import uz.gita.quizapp.model.Entity.English
import uz.gita.quizapp.model.Entity.Geography
import uz.gita.quizapp.model.Entity.Physics

@Database(
    entities = [
        Computer::class,
        English::class,
        Geography::class,
        Physics::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun englishDao(): EnglishDao

    abstract fun geographyDao():GeographyDao

    abstract fun physicsDao():PhysicsDao

    abstract fun computerDao(): ComputerDao


      companion object{
          var db : AppDatabase ? = null

          fun initDB(context: Context){
              db = Room.databaseBuilder(context,AppDatabase::class.java,"Quiz.db")
                  .allowMainThreadQueries()
                  .createFromAsset("Quiz.db")
                  .build()
          }

          fun getEnglishDao():EnglishDao{
              return db!!.englishDao()
          }

          fun getGeographyDao(): GeographyDao{
              return db!!.geographyDao()
          }

          fun getPhysicsDao():PhysicsDao{
              return db!!.physicsDao()
          }

          fun getComputerDao():ComputerDao{
              return db!!.computerDao()
          }
      }

}