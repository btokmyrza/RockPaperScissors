package kz.btokmyrza.rockpaperscissorsexam

import android.graphics.Color
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var chosenWeapon: Int? = null
    var chosenOpponentImage: Int? = null
    lateinit var ivChosenWeapon: ImageView
    lateinit var tvChooseWeapon: TextView

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvChooseWeapon = findViewById(R.id.tv_choose_weapon)

        val btnChooseWeapon = findViewById<Button>(R.id.btn_choose_weapon)
        val btnDuel = findViewById<Button>(R.id.btn_duel)
        ivChosenWeapon = findViewById(R.id.iv_chosen_weapon)

        btnChooseWeapon.setOnClickListener {
            ChooseWeaponDialogFragment().show(supportFragmentManager, null)
            it.visibility = View.INVISIBLE
            ivChosenWeapon.visibility = View.VISIBLE
            btnDuel.visibility = View.VISIBLE
        }

        val btnMore = findViewById<Button>(R.id.btn_more)
        val ivQuestionMarks = findViewById<ImageView>(R.id.iv_question_marks)

        btnDuel.setOnClickListener {
            chosenOpponentImage = listOf(R.drawable.img_rock, R.drawable.img_paper, R.drawable.img_scissors).random()
            ivQuestionMarks.setImageResource(chosenOpponentImage!!)
            ivQuestionMarks.visibility = View.VISIBLE
            it.visibility = View.GONE
            btnMore.visibility = View.VISIBLE
            determineWinner(chosenWeapon, chosenOpponentImage)
        }

        btnMore.setOnClickListener {
            ivQuestionMarks.setImageResource(R.drawable.img_question_marks)
            ivChosenWeapon.setImageResource(R.drawable.img_question_marks)
            ivChosenWeapon.visibility = View.INVISIBLE
            btnChooseWeapon.visibility = View.VISIBLE
            tvChooseWeapon.text = "Выберите оружие"
            tvChooseWeapon.setTextColor(Color.BLACK)
            it.visibility = View.GONE
            chosenOpponentImage = null
        }

    }

    fun chooseWeapon(weaponId: Int?) {
        when(weaponId) {
            R.id.ib_rock -> {
                tvChooseWeapon.text = "Вы выбрали камень!"
                chosenWeapon = R.drawable.img_rock
                ivChosenWeapon.setImageResource(chosenWeapon!!)
            }
            R.id.ib_paper -> {
                tvChooseWeapon.text = "Вы выбрали бумагу!"
                chosenWeapon = R.drawable.img_paper
                ivChosenWeapon.setImageResource(chosenWeapon!!)
            }
            R.id.ib_scissors -> {
                tvChooseWeapon.text = "Вы выбрали ножницы!"
                chosenWeapon = R.drawable.img_scissors
                ivChosenWeapon.setImageResource(chosenWeapon!!)
            }
        }
    }

    private fun determineWinner(player: Int?, opponent: Int?) {
        if (player == R.drawable.img_rock && opponent == R.drawable.img_paper) {
            tvChooseWeapon.text = "Вы проиграли!"
            tvChooseWeapon.setTextColor(Color.RED)
        }
        else if (player == R.drawable.img_rock && opponent == R.drawable.img_scissors) {
            tvChooseWeapon.text = "Вы выиграли!"
            tvChooseWeapon.setTextColor(Color.GREEN)
        }
        else if (player == R.drawable.img_paper && opponent == R.drawable.img_rock) {
            tvChooseWeapon.text = "Вы выиграли!"
            tvChooseWeapon.setTextColor(Color.GREEN)
        }
        else if (player == R.drawable.img_paper && opponent == R.drawable.img_scissors) {
            tvChooseWeapon.text = "Вы проиграли!"
            tvChooseWeapon.setTextColor(Color.RED)
        }
        else if (player == R.drawable.img_scissors && opponent == R.drawable.img_rock) {
            tvChooseWeapon.text = "Вы проиграли!"
            tvChooseWeapon.setTextColor(Color.RED)
        }
        else if (player == R.drawable.img_scissors && opponent == R.drawable.img_paper) {
            tvChooseWeapon.text = "Вы выиграли!"
            tvChooseWeapon.setTextColor(Color.GREEN)
        }
        else if (player == opponent) {
            tvChooseWeapon.text = "Ничья!"
        }
    }

}