package uz.gita.quizapp.screens

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.gita.quizapp.R
import uz.gita.quizapp.databinding.QuestionScreenBinding
import uz.gita.quizapp.model.AppDatabase


class QuestionScreen : Fragment() {
    private var _binding: QuestionScreenBinding? = null
    private val binding get() = _binding!!
    private val listVariants: ArrayList<LinearLayout> = arrayListOf()
    private var correctAnswerNumber = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = QuestionScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        AppDatabase.initDB(requireContext())
        val science = requireArguments().getString("key")
        binding.scienceQuiz.text = "$science Quiz"
        when (science) {
            "English" -> englishQuiz(science)
            "Geography" -> geographyQuiz(science)
            "Physics" -> physicsQuiz(science)
            "Computer" -> computerQuiz(science)
        }
    }


    private fun englishQuiz(science: String) {
        var count: Int = 1
        initButton()
        binding.questionNum.text = (count).toString()
        val data = AppDatabase.getEnglishDao().getEnglishRow(count)
        binding.questionText.text = data.question
        binding.variant1.text = data.variantA
        binding.variant2.text = data.variantB
        binding.variant3.text = data.variantC
        binding.variant4.text = data.variantD
        count++
        checkButtonEvent()
        binding.quitId.setOnClickListener {
            val bundle = Bundle().apply {
                putInt("key", correctAnswerNumber)
            }
            findNavController().navigate(R.id.action_questionScreen_to_resultScreen, bundle)
        }
        binding.nextId.setOnClickListener {
            var checkResult = checkEnglishQuestion(count - 1)
            if (checkResult) {
                if (count <= 10) {
                    clearCheckButtonEvent()
                    binding.questionNum.text = (count).toString()
                    val data = AppDatabase.getEnglishDao().getEnglishRow(count)
                    binding.questionText.text = data.question
                    binding.variant1.text = data.variantA
                    binding.variant2.text = data.variantB
                    binding.variant3.text = data.variantC
                    binding.variant4.text = data.variantD
                    count++
                } else {
                    val bundle = Bundle().apply {
                        putInt("key", correctAnswerNumber)
                    }
                    findNavController().navigate(R.id.action_questionScreen_to_resultScreen, bundle)
                }
            } else {
                val toast =
                    Toast.makeText(requireContext(), "Select the variant!", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }


        }
    }

    private fun checkEnglishQuestion(index: Int): Boolean {
        val data = AppDatabase.getEnglishDao().getEnglishRow(index)
        for (i in 0..3) {
            val textView = listVariants[i].getChildAt(1) as TextView
            if (listVariants[i].tag.toString() == "checked" ){
                if( textView.text.toString() == data.answer){
                    correctAnswerNumber++
                }
                return true
            }
        }
        return false
    }

    private fun checkGeographyQuestion(index: Int): Boolean {
        val data = AppDatabase.getGeographyDao().getGeographyRow(index)
        for (i in 0..3) {
            val textView = listVariants[i].getChildAt(1) as TextView
            if (listVariants[i].tag.toString() == "checked" ){
                if( textView.text.toString() == data.answer){
                    correctAnswerNumber++
                }
                return true
            }
        }
        return false
    }

    private fun checkPhysicsQuestion(index: Int): Boolean {
        val data = AppDatabase.getPhysicsDao().getPhysicsRow(index)
        for (i in 0..3) {
            val textView = listVariants[i].getChildAt(1) as TextView
            if (listVariants[i].tag.toString() == "checked" ){
                if( textView.text.toString() == data.answer){
                    correctAnswerNumber++
                }
                return true
            }
        }
        return false
    }

    private fun checkComputerQuestion(index: Int): Boolean {
        val data = AppDatabase.getComputerDao().getComputerRow(index)
        for (i in 0..3) {
            val textView = listVariants[i].getChildAt(1) as TextView
            if (listVariants[i].tag.toString() == "checked" ){
                if( textView.text.toString() == data.answer){
                    correctAnswerNumber++
                }
                return true
            }
        }
        return false
    }


    private fun checkButtonEvent() {
        for (i in 0..3) {
            listVariants[i].setOnClickListener {
                stayElement(i)
                val str = listVariants[i].tag.toString()
                if (str == "unchecked") {
                    listVariants[i].setBackgroundResource(R.drawable.btn_1_click)
                    val checkBtn = listVariants[i].getChildAt(0) as ImageView
                    checkBtn.setImageResource(R.drawable.radio_button)
                    listVariants[i].tag = "checked"
                } else {
                    listVariants[i].setBackgroundResource(R.drawable.btn_1)
                    val checkBtn = listVariants[i].getChildAt(0) as ImageView
                    checkBtn.setImageResource(R.drawable.empty_check)
                    listVariants[i].tag = "unchecked"
                }
            }


        }
    }

    private fun clearCheckButtonEvent() {
        for (i in 0..3) {
            val str: String = listVariants[i].tag.toString()
            if (str == "checked") {
                listVariants[i].setBackgroundResource(R.drawable.btn_1)
                val checkBtn = listVariants[i].getChildAt(0) as ImageView
                checkBtn.setImageResource(R.drawable.empty_check)
                listVariants[i].tag = "unchecked"
            }
        }
    }

    private fun stayElement(index: Int) {
        for (i in 0..3) {
            if (i != index) {
                listVariants[i].setBackgroundResource(R.drawable.btn_1)
                val checkBtn = listVariants[i].getChildAt(0) as ImageView
                checkBtn.setImageResource(R.drawable.empty_check)
                listVariants[i].tag = "unchecked"
            }
        }
    }

    private fun initButton() {
        listVariants.add(binding.item1)
        listVariants.add(binding.item2)
        listVariants.add(binding.item3)
        listVariants.add(binding.item4)
        for (i in 0..3) {
            listVariants[i].tag = "unchecked"
        }

    }


    private fun geographyQuiz(science: String) {
        var count: Int = 1
        correctAnswerNumber = 0
        listVariants.clear()
        initButton()
        binding.questionNum.text = (count).toString()
        val data = AppDatabase.getGeographyDao().getGeographyRow(count)
        binding.questionText.text = data.question
        binding.variant1.text = data.variantA
        binding.variant2.text = data.variantB
        binding.variant3.text = data.variantC
        binding.variant4.text = data.variantD
        count++
        checkButtonEvent()
        binding.quitId.setOnClickListener {
            val bundle = Bundle().apply {
                putInt("key", correctAnswerNumber)
            }
            findNavController().navigate(R.id.action_questionScreen_to_resultScreen, bundle)
        }
        binding.nextId.setOnClickListener {
            val checkResult = checkGeographyQuestion(count - 1)
            if (checkResult) {
                if (count <= 10) {
                    clearCheckButtonEvent()
                    binding.questionNum.text = (count).toString()
                    val data = AppDatabase.getGeographyDao().getGeographyRow(count)
                    binding.questionText.text = data.question
                    binding.variant1.text = data.variantA
                    binding.variant2.text = data.variantB
                    binding.variant3.text = data.variantC
                    binding.variant4.text = data.variantD
                    count++
                } else {
                    val bundle = Bundle().apply {
                        putInt("key", correctAnswerNumber)
                    }
                    findNavController().navigate(R.id.action_questionScreen_to_resultScreen, bundle)
                }

            } else {
                Toast.makeText(requireContext(), "Select the variant!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun physicsQuiz(science: String) {
        var count: Int = 1
        correctAnswerNumber = 0
        listVariants.clear()
        initButton()
        binding.questionNum.text = (count).toString()
        val data = AppDatabase.getPhysicsDao().getPhysicsRow(count)
        binding.questionText.text = data.question
        binding.variant1.text = data.variantA
        binding.variant2.text = data.variantB
        binding.variant3.text = data.variantC
        binding.variant4.text = data.variantD
        count++
        checkButtonEvent()
        binding.quitId.setOnClickListener {
            val bundle = Bundle().apply {
                putInt("key", correctAnswerNumber)
            }
            findNavController().navigate(R.id.action_questionScreen_to_resultScreen, bundle)
        }
        binding.nextId.setOnClickListener {
            val checkResult = checkPhysicsQuestion(count - 1)
            if (checkResult) {
                if (count <= 10) {
                    clearCheckButtonEvent()
                    binding.questionNum.text = (count).toString()
                    val data = AppDatabase.getPhysicsDao().getPhysicsRow(count)
                    binding.questionText.text = data.question
                    binding.variant1.text = data.variantA
                    binding.variant2.text = data.variantB
                    binding.variant3.text = data.variantC
                    binding.variant4.text = data.variantD
                    count++
                } else {
                    val bundle = Bundle().apply {
                        putInt("key", correctAnswerNumber)
                    }
                    findNavController().navigate(R.id.action_questionScreen_to_resultScreen, bundle)
                }
            } else {
                Toast.makeText(requireContext(), "Select the variant!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun computerQuiz(science: String) {
        var count: Int = 1
        correctAnswerNumber = 0
        listVariants.clear()
        initButton()
        binding.questionNum.text = (count).toString()
        val data = AppDatabase.getComputerDao().getComputerRow(count)
        binding.questionText.text = data.question
        binding.variant1.text = data.variantA
        binding.variant2.text = data.variantB
        binding.variant3.text = data.variantC
        binding.variant4.text = data.variantD
        count++
        checkButtonEvent()
        binding.quitId.setOnClickListener {
            val bundle = Bundle().apply {
                putInt("key", correctAnswerNumber)
            }
            findNavController().navigate(R.id.action_questionScreen_to_resultScreen, bundle)
        }
        binding.nextId.setOnClickListener {
            val checkResult = checkComputerQuestion(count - 1)
            if (checkResult) {
                if (count <= 10) {
                    clearCheckButtonEvent()
                    binding.questionNum.text = (count).toString()
                    val data = AppDatabase.getComputerDao().getComputerRow(count)
                    binding.questionText.text = data.question
                    binding.variant1.text = data.variantA
                    binding.variant2.text = data.variantB
                    binding.variant3.text = data.variantC
                    binding.variant4.text = data.variantD
                    count++
                } else {
                    val bundle = Bundle().apply {
                        putInt("key", correctAnswerNumber)
                    }
                    findNavController().navigate(R.id.action_questionScreen_to_resultScreen, bundle)
                }
            } else {
                Toast.makeText(requireContext(), "Select the variant!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}