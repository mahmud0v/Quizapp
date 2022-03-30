package uz.gita.quizapp.model

import uz.gita.quizapp.R

class SetIntroData  {
    private lateinit var listVPData : ArrayList<IntroData>


    companion object{
        val instance = SetIntroData()
    }

    fun getVPData() : ArrayList<IntroData>{
        listVPData = arrayListOf(
            IntroData(R.drawable.img1,"Qulay foydalanish","Bilimingizni qulay tarzda tekshiring"),
            IntroData(R.drawable.img2,"Fanlar majmuasidan testlar","Fanlardan bilimingizni tekshirib ko'ring"),
            IntroData(R.drawable.img3,"Natijani tekshirish","O'z bilimingizni raqamlarda tekshiring")
        )

        return listVPData
    }
}