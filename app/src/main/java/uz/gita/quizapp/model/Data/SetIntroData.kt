package uz.gita.quizapp.model.Data

import uz.gita.quizapp.R

class SetIntroData {
    private lateinit var listVPData : ArrayList<IntroData>


    companion object{
        val instance = SetIntroData()
    }

    fun getVPData() : ArrayList<IntroData>{
        listVPData = arrayListOf(
            IntroData(R.drawable.img1,R.string.FirstIntroText,R.string.FirstIntroDesc),
            IntroData(R.drawable.img2,R.string.SecondIntroText,R.string.SecondIntroDesc),
            IntroData(R.drawable.img3,R.string.ThirdIntroText,R.string.ThirdIntroDesc)
        )

        return listVPData
    }
}