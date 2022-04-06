package uz.gita.quizapp.app

import android.app.Application
import uz.gita.quizapp.model.AppDatabase

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        AppDatabase.initDB(this)
    }
}