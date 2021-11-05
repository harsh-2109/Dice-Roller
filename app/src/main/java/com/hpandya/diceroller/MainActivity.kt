package com.hpandya.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollDice()
        val rollButton: Button = findViewById(R.id.roll_button)

        rollButton.setOnClickListener { rollDice() }

    }
    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)

        // Update the screen with the dice roll
        val diceNumberDice: ImageView = findViewById(R.id.dice_image)

        //Switch condition
        val drawableResource = when (dice.roll()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceNumberDice.setImageResource(drawableResource)
//        when(dice.roll()){
//            1 -> diceNumberDice.setImageResource(R.drawable.dice_1)
//            2 -> diceNumberDice.setImageResource(R.drawable.dice_2)
//            3 -> diceNumberDice.setImageResource(R.drawable.dice_3)
//            4 -> diceNumberDice.setImageResource(R.drawable.dice_4)
//            5 -> diceNumberDice.setImageResource(R.drawable.dice_5)
//            6 -> diceNumberDice.setImageResource(R.drawable.dice_6)
//        }

    }
}

class Dice(private val numSide: Int) {
    fun roll(): Int {
        return (1..numSide).random()
    }
}