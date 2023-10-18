package com.example.hangmanv2

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hangmanv2.ui.theme.HangmanV2Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listofwords = arrayOf<String>("ZEBRA", "PEARS", "APPLE", "FLOWER", "PLANE", "CARS", "SQUID", "TREE")
        val plants = arrayOf("FLOWER", "TREE")
        val animals = arrayOf("ZEBRA", "SQUID")
        val fruits = arrayOf("PEARS", "APPLE")
        val vehicle = arrayOf("PLANE", "CARS")
        val randomindex = Random.nextInt(listofwords.size)
        var wordtoguess = listofwords[randomindex]
        var death_counter = 0
        var success_count = 0
        var hint_count = 0
        val hint_button = findViewById<Button>(R.id.hint_button)
        val newgame_button = findViewById<Button>(R.id.newgame)
        val Abutton = findViewById<Button>(R.id.Abutton)
        val Bbutton = findViewById<Button>(R.id.Bbutton)
        val Cbutton = findViewById<Button>(R.id.Cbutton)
        val Dbutton = findViewById<Button>(R.id.Dbutton)
        val Ebutton = findViewById<Button>(R.id.Ebutton)
        val Fbutton = findViewById<Button>(R.id.Fbutton)
        val Gbutton = findViewById<Button>(R.id.Gbutton)
        val Hbutton = findViewById<Button>(R.id.Hbutton)
        val Ibutton = findViewById<Button>(R.id.Ibutton)
        val Jbutton = findViewById<Button>(R.id.Jbutton)
        val Kbutton = findViewById<Button>(R.id.Kbutton)
        val Lbutton = findViewById<Button>(R.id.Lbutton)
        val Mbutton = findViewById<Button>(R.id.Mbutton)
        val Nbutton = findViewById<Button>(R.id.Nbutton)
        val Obutton = findViewById<Button>(R.id.Obutton)
        val Pbutton = findViewById<Button>(R.id.Pbutton)
        val Qbutton = findViewById<Button>(R.id.Qbutton)
        val Rbutton = findViewById<Button>(R.id.Rbutton)
        val Sbutton = findViewById<Button>(R.id.Sbutton)
        val Tbutton = findViewById<Button>(R.id.Tbutton)
        val Ubutton = findViewById<Button>(R.id.Ubutton)
        val Vbutton = findViewById<Button>(R.id.Vbutton)
        val Wbutton = findViewById<Button>(R.id.Wbutton)
        val Xbutton = findViewById<Button>(R.id.Xbutton)
        val Ybutton = findViewById<Button>(R.id.Ybutton)
        val Zbutton = findViewById<Button>(R.id.Zbutton)
        var firstletter = findViewById<TextView>(R.id.letter)
        var secondletter = findViewById<TextView>(R.id.letter3)
        var thirdletter = findViewById<TextView>(R.id.letter4)
        var fourthletter = findViewById<TextView>(R.id.letter5)
        var fifthletter = findViewById<TextView>(R.id.letter6)
        var sixthletter = findViewById<TextView>(R.id.letter7)

        newgame_button.setOnClickListener {
            val mIntent = intent
            finish()
            startActivity(mIntent)
        }
        hint_button.setOnClickListener {
            if(hint_count == 0){
                if(wordtoguess in plants){
                    findViewById<TextView>(R.id.hint_text).text = "it's a plant"
                    hint_count += 1
                }
                if(wordtoguess in animals){
                    findViewById<TextView>(R.id.hint_text).text = "it's an animal"
                    hint_count += 1
                }
                if(wordtoguess in vehicle){
                    findViewById<TextView>(R.id.hint_text).text = "it's a vehicle"
                    hint_count += 1
                }
                if(wordtoguess in fruits){
                    findViewById<TextView>(R.id.hint_text).text = "it's a fruit"
                    hint_count += 1
                }
            }
            else if (hint_count == 1) {
                if (death_counter < 5) {
                    death_counter++
                    hint_count++
                    var to_remove = 0
                    for (start in 'A'..'Z') {
                        val buttonId = "${start}button"
                        val resId = resources.getIdentifier(buttonId, "id", packageName)
                        if (resId != 0) { // Check if the resource exists
                            val button = findViewById<Button>(resId)
                            if (button.isClickable){
                                to_remove += 1
                                }
                        }

                    }

                    var inside_counter = 0
                    for (start in 'A'..'Z') {
                        val buttonId = "${start}button"
                        val resId = resources.getIdentifier(buttonId, "id", packageName)
                        if (resId != 0) { // Check if the resource exists
                            val button = findViewById<Button>(resId)
                            if (button.isClickable == true && !(start.toString() in wordtoguess)){
                                if(inside_counter <= (to_remove / 2 )){
                                button.isClickable = false
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                inside_counter += 1
                                }
                                else{
                                    break
                                }
                            }
                            }

                        }
                    }
                 else {
                    Toast.makeText(this, "HINT NOT AVAILABLE", Toast.LENGTH_SHORT).show()
                }}



            else if(hint_count == 2){
                val vowels = arrayOf("A", "E", "I", "O", "U")
                if (death_counter < 5){
                    for (letter in vowels){
                    for (i in 0..wordtoguess.length - 1) {
                        if (wordtoguess[i].toString() == letter) {
                            if (i == 0) {
                                firstletter.text = letter
                                success_count += 1
                            }
                            if (i == 1) {
                                secondletter.text = letter
                                success_count += 1
                            }
                            if (i == 2) {
                                thirdletter.text = letter
                                success_count += 1
                            }
                            if (i == 3) {
                                fourthletter.text = letter
                                success_count += 1
                            }
                            if (i == 4) {
                                fifthletter.text = letter
                                success_count += 1
                            }
                            if (i == 5) {
                                sixthletter.text = letter
                                success_count += 1
                            }
                        }
                    }
                    }
                    if(success_count > 4){
                        Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) { // Check if the resource exists
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                    }
                    death_counter += 1
                    hint_count += 1
                    if(death_counter == 1){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                    }
                    if(death_counter == 2){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                    }
                    if(death_counter == 3){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                    }
                    if(death_counter == 4){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                    }
                    if(death_counter == 5){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                    }
                }
                else{
                    Toast.makeText(this, "HINT NOT AVAILABLE", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this, "NO MORE HINTS", Toast.LENGTH_SHORT).show()
            }
        }

        Abutton.setOnClickListener {
            var letter = "A"
            if (letter in wordtoguess) {
                Toast.makeText(this, "Good Guess!", Toast.LENGTH_SHORT).show()
                for (i in 0..wordtoguess.length - 1) {
                    if (wordtoguess[i].toString() == letter) {
                        if (i == 0) {
                            firstletter.text = letter
                            success_count += 1
                        }
                        if (i == 1) {
                            secondletter.text = letter
                            success_count += 1
                        }
                        if (i == 2) {
                            thirdletter.text = letter
                            success_count += 1
                        }
                        if (i == 3) {
                            fourthletter.text = letter
                            success_count += 1
                        }
                        if (i == 4) {
                            fifthletter.text = letter
                            success_count += 1
                        }
                        if (i == 5) {
                            sixthletter.text = letter
                            success_count += 1
                        }
                    }
                }
                if(success_count > 4){
                    Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                    for (start in 'A'..'Z') {
                        val buttonId = "${start}button"
                        val resId = resources.getIdentifier(buttonId, "id", packageName)
                        if (resId != 0) { // Check if the resource exists
                            val button = findViewById<Button>(resId)
                            button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                            button.isClickable = false
                        }

                    }
                }
            }
            else{
                Toast.makeText(this, "Bad Guess!", Toast.LENGTH_SHORT).show()
                death_counter += 1
                if(death_counter == 1){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                }
                if(death_counter == 2){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                }
                if(death_counter == 3){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                }
                if(death_counter == 4){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                }
                if(death_counter == 5){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                }
                if(death_counter == 6){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmandone_foreground)
                }
                if (death_counter > 5){
                    for (start in 'A'..'Z') {
                        val buttonId = "${start}button"
                        val resId = resources.getIdentifier(buttonId, "id", packageName)
                        if (resId != 0) {
                            val button = findViewById<Button>(resId)
                            button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                            button.isClickable = false
                        }

                    }
                    Toast.makeText(this, "You are dead!", Toast.LENGTH_LONG).show()
                    Toast.makeText(this, "The word was $wordtoguess!", Toast.LENGTH_LONG).show()
                }
            }
            Abutton.isClickable = false
            Abutton.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
        }
        Bbutton.setOnClickListener {
            var letter = "B"
            if (letter in wordtoguess) {
                Toast.makeText(this, "Good Guess!", Toast.LENGTH_SHORT).show()
                for (i in 0..wordtoguess.length - 1){
                    if (wordtoguess[i].toString() == letter) {
                        if (i == 0) {
                            firstletter.text = letter
                            success_count += 1
                        }
                        if (i == 1) {
                            secondletter.text = letter
                            success_count += 1
                        }
                        if (i == 2) {
                            thirdletter.text = letter
                            success_count += 1
                        }
                        if (i == 3) {
                            fourthletter.text = letter
                            success_count += 1
                        }
                        if (i == 4) {
                            fifthletter.text = letter
                            success_count += 1
                        }
                        if (i == 5) {
                            sixthletter.text = letter
                            success_count += 1
                        }
                    }
                }
                if(success_count > 4){
                    Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                    for (start in 'A'..'Z') {
                        val buttonId = "${start}button"
                        val resId = resources.getIdentifier(buttonId, "id", packageName)
                        if (resId != 0) {
                            val button = findViewById<Button>(resId)
                            button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                            button.isClickable = false
                        }

                    }
                }
            }
            else{
                Toast.makeText(this, "Bad Guess!", Toast.LENGTH_SHORT).show()
                death_counter += 1
                if(death_counter == 1){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                }
                if(death_counter == 2){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                }
                if(death_counter == 3){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                }
                if(death_counter == 4){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                }
                if(death_counter == 5){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                }
                if(death_counter == 6){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmandone_foreground)
                }
                if (death_counter > 5){
                    for (start in 'A'..'Z') {
                        val buttonId = "${start}button"
                        val resId = resources.getIdentifier(buttonId, "id", packageName)
                        if (resId != 0) { // Check if the resource exists
                            val button = findViewById<Button>(resId)
                            button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                            button.isClickable = false
                        }

                    }
                    Toast.makeText(this, "You are dead!", Toast.LENGTH_LONG).show()
                    Toast.makeText(this, "The word was $wordtoguess!", Toast.LENGTH_LONG).show()
                }
            }
            Bbutton.isClickable = false
            Bbutton.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
        }
        Cbutton.setOnClickListener {
            var letter = "C"
            if (letter in wordtoguess) {
                Toast.makeText(this, "Good Guess!", Toast.LENGTH_SHORT).show()
                for (i in 0..wordtoguess.length - 1) {
                    if (wordtoguess[i].toString() == letter) {
                        if (i == 0) {
                            firstletter.text = letter
                            success_count += 1
                        }
                        if (i == 1) {
                            secondletter.text = letter
                            success_count += 1
                        }
                        if (i == 2) {
                            thirdletter.text = letter
                            success_count += 1
                        }
                        if (i == 3) {
                            fourthletter.text = letter
                            success_count += 1
                        }
                        if (i == 4) {
                            fifthletter.text = letter
                            success_count += 1
                        }
                        if (i == 5) {
                            sixthletter.text = letter
                            success_count += 1
                        }
                    }
                }
                if(success_count > 4){
                    Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                    for (start in 'A'..'Z') {
                        val buttonId = "${start}button"
                        val resId = resources.getIdentifier(buttonId, "id", packageName)
                        if (resId != 0) { // Check if the resource exists
                            val button = findViewById<Button>(resId)
                            button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                            button.isClickable = false
                        }

                    }
                }
            }
            else{
                Toast.makeText(this, "Bad Guess!", Toast.LENGTH_SHORT).show()
                death_counter += 1
                if(death_counter == 1){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                }
                if(death_counter == 2){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                }
                if(death_counter == 3){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                }
                if(death_counter == 4){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                }
                if(death_counter == 5){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                }
                if(death_counter == 6){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmandone_foreground)
                }
                if (death_counter > 5){
                    for (start in 'A'..'Z') {
                        val buttonId = "${start}button"
                        val resId = resources.getIdentifier(buttonId, "id", packageName)
                        if (resId != 0) { // Check if the resource exists
                            val button = findViewById<Button>(resId)
                            button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                            button.isClickable = false
                        }

                    }
                    Toast.makeText(this, "You are dead!", Toast.LENGTH_LONG).show()
                    Toast.makeText(this, "The word was $wordtoguess!", Toast.LENGTH_LONG).show()
                }
            }
            Cbutton.isClickable = false
            Cbutton.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
        }
        Dbutton.setOnClickListener {
            var letter = "D"
            if (letter in wordtoguess) {
                Toast.makeText(this, "Good Guess!", Toast.LENGTH_SHORT).show()
                for (i in 0..wordtoguess.length - 1) {
                    if (wordtoguess[i].toString() == letter) {
                        if (i == 0) {
                            firstletter.text = letter
                            success_count += 1
                        }
                        if (i == 1) {
                            secondletter.text = letter
                            success_count += 1
                        }
                        if (i == 2) {
                            thirdletter.text = letter
                            success_count += 1
                        }
                        if (i == 3) {
                            fourthletter.text = letter
                            success_count += 1
                        }
                        if (i == 4) {
                            fifthletter.text = letter
                            success_count += 1
                        }
                        if (i == 5) {
                            sixthletter.text = letter
                            success_count += 1
                        }
                    }
                }
                if(success_count > 4){
                    Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                    for (start in 'A'..'Z') {
                        val buttonId = "${start}button"
                        val resId = resources.getIdentifier(buttonId, "id", packageName)
                        if (resId != 0) {
                            val button = findViewById<Button>(resId)
                            button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                            button.isClickable = false
                        }

                    }
                }
            }
            else{
                Toast.makeText(this, "Bad Guess!", Toast.LENGTH_SHORT).show()
                death_counter += 1
                if(death_counter == 1){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                }
                if(death_counter == 2){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                }
                if(death_counter == 3){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                }
                if(death_counter == 4){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                }
                if(death_counter == 5){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                }
                if(death_counter == 6){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmandone_foreground)
                }
                if (death_counter > 5){
                    for (start in 'A'..'Z') {
                        val buttonId = "${start}button"
                        val resId = resources.getIdentifier(buttonId, "id", packageName)
                        if (resId != 0) { // Check if the resource exists
                            val button = findViewById<Button>(resId)
                            button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                            button.isClickable = false
                        }

                    }
                    Toast.makeText(this, "You are dead!", Toast.LENGTH_LONG).show()
                    Toast.makeText(this, "The word was $wordtoguess!", Toast.LENGTH_LONG).show()
                }
            }
            Dbutton.isClickable = false
            Dbutton.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
        }
        Ebutton.setOnClickListener {
            var letter = "E"
            if (letter in wordtoguess) {
                Toast.makeText(this, "Good Guess!", Toast.LENGTH_SHORT).show()
                for (i in 0..wordtoguess.length - 1) {
                    if (wordtoguess[i].toString() == letter) {
                        if (i == 0) {
                            firstletter.text = letter
                            success_count += 1
                        }
                        if (i == 1) {
                            secondletter.text = letter
                            success_count += 1
                        }
                        if (i == 2) {
                            thirdletter.text = letter
                            success_count += 1
                        }
                        if (i == 3) {
                            fourthletter.text = letter
                            success_count += 1
                        }
                        if (i == 4) {
                            fifthletter.text = letter
                            success_count += 1
                        }
                        if (i == 5) {
                            sixthletter.text = letter
                            success_count += 1
                        }
                    }
                }
                if(success_count > 4){
                    Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                    for (start in 'A'..'Z') {
                        val buttonId = "${start}button"
                        val resId = resources.getIdentifier(buttonId, "id", packageName)
                        if (resId != 0) {
                            val button = findViewById<Button>(resId)
                            button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                            button.isClickable = false
                        }

                    }
                }
            }
            else{
                Toast.makeText(this, "Bad Guess!", Toast.LENGTH_SHORT).show()
                death_counter += 1
                if(death_counter == 1){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                }
                if(death_counter == 2){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                }
                if(death_counter == 3){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                }
                if(death_counter == 4){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                }
                if(death_counter == 5){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                }
                if(death_counter == 6){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmandone_foreground)
                }
                if (death_counter > 5){
                    for (start in 'A'..'Z') {
                        val buttonId = "${start}button"
                        val resId = resources.getIdentifier(buttonId, "id", packageName)
                        if (resId != 0) { // Check if the resource exists
                            val button = findViewById<Button>(resId)
                            button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                            button.isClickable = false
                        }

                    }
                    Toast.makeText(this, "You are dead!", Toast.LENGTH_LONG).show()
                    Toast.makeText(this, "The word was $wordtoguess!", Toast.LENGTH_LONG).show()
                }
            }
            Ebutton.isClickable = false
            Ebutton.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
        }
        Fbutton.setOnClickListener {
            var letter = "F"
            if (letter in wordtoguess) {
                Toast.makeText(this, "Good Guess!", Toast.LENGTH_SHORT).show()
                for (i in 0..wordtoguess.length - 1) {
                    if (wordtoguess[i].toString() == letter) {
                        if (i == 0) {
                            firstletter.text = letter
                            success_count += 1
                        }
                        if (i == 1) {
                            secondletter.text = letter
                            success_count += 1
                        }
                        if (i == 2) {
                            thirdletter.text = letter
                            success_count += 1
                        }
                        if (i == 3) {
                            fourthletter.text = letter
                            success_count += 1
                        }
                        if (i == 4) {
                            fifthletter.text = letter
                            success_count += 1
                        }
                        if (i == 5) {
                            sixthletter.text = letter
                            success_count += 1
                        }
                    }
                }
                if(success_count > 4){
                    Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                    for (start in 'A'..'Z') {
                        val buttonId = "${start}button"
                        val resId = resources.getIdentifier(buttonId, "id", packageName)
                        if (resId != 0) {
                            val button = findViewById<Button>(resId)
                            button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                            button.isClickable = false
                        }

                    }
                }
            }
                else{
                    Toast.makeText(this, "Bad Guess!", Toast.LENGTH_SHORT).show()
                    death_counter += 1
                if(death_counter == 1){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                }
                if(death_counter == 2){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                }
                if(death_counter == 3){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                }
                if(death_counter == 4){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                }
                if(death_counter == 5){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                }
                if(death_counter == 6){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmandone_foreground)
                }
                if (death_counter > 5){
                    for (start in 'A'..'Z') {
                        val buttonId = "${start}button"
                        val resId = resources.getIdentifier(buttonId, "id", packageName)
                        if (resId != 0) { // Check if the resource exists
                            val button = findViewById<Button>(resId)
                            button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                            button.isClickable = false
                        }

                    }
                    Toast.makeText(this, "You are dead!", Toast.LENGTH_LONG).show()
                    Toast.makeText(this, "The word was $wordtoguess!", Toast.LENGTH_LONG).show()
                }
                }
            Fbutton.isClickable = false
            Fbutton.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
            }

        Gbutton.setOnClickListener {
            var letter = "G"
            if (letter in wordtoguess) {
                Toast.makeText(this, "Good Guess!", Toast.LENGTH_SHORT).show()
                for (i in 0..wordtoguess.length - 1) {
                    if (wordtoguess[i].toString() == letter) {
                        if (i == 0) {
                            firstletter.text = letter
                            success_count += 1
                        }
                        if (i == 1) {
                            secondletter.text = letter
                            success_count += 1
                        }
                        if (i == 2) {
                            thirdletter.text = letter
                            success_count += 1
                        }
                        if (i == 3) {
                            fourthletter.text = letter
                            success_count += 1
                        }
                        if (i == 4) {
                            fifthletter.text = letter
                            success_count += 1
                        }
                        if (i == 5) {
                            sixthletter.text = letter
                            success_count += 1
                        }
                    }
                }
                if(success_count > 4){
                    Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                    for (start in 'A'..'Z') {
                        val buttonId = "${start}button"
                        val resId = resources.getIdentifier(buttonId, "id", packageName)
                        if (resId != 0) {
                            val button = findViewById<Button>(resId)
                            button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                            button.isClickable = false
                        }

                    }
                }
                }
            else {
                Toast.makeText(this, "Bad Guess!", Toast.LENGTH_SHORT).show()
                death_counter += 1
                if(death_counter == 1){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                }
                if(death_counter == 2){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                }
                if(death_counter == 3){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                }
                if(death_counter == 4){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                }
                if(death_counter == 5){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                }
                if(death_counter == 6){
                    findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmandone_foreground)
                }
                if (death_counter > 5){
                    for (start in 'A'..'Z') {
                        val buttonId = "${start}button"
                        val resId = resources.getIdentifier(buttonId, "id", packageName)
                        if (resId != 0) { // Check if the resource exists
                            val button = findViewById<Button>(resId)
                            button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                            button.isClickable = false
                        }

                    }
                    Toast.makeText(this, "You are dead!", Toast.LENGTH_LONG).show()
                    Toast.makeText(this, "The word was $wordtoguess!", Toast.LENGTH_LONG).show()
                }
            }
            Gbutton.isClickable = false
            Gbutton.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
            }
            Hbutton.setOnClickListener {
                var letter = "H"
                if (letter in wordtoguess) {
                    Toast.makeText(this, "Good Guess!", Toast.LENGTH_SHORT).show()
                    for (i in 0..wordtoguess.length - 1) {
                        if (wordtoguess[i].toString() == letter) {
                            if (i == 0) {
                                firstletter.text = letter
                                success_count += 1
                            }
                            if (i == 1) {
                                secondletter.text = letter
                                success_count += 1
                            }
                            if (i == 2) {
                                thirdletter.text = letter
                                success_count += 1
                            }
                            if (i == 3) {
                                fourthletter.text = letter
                                success_count += 1
                            }
                            if (i == 4) {
                                fifthletter.text = letter
                                success_count += 1
                            }
                            if (i == 5) {
                                sixthletter.text = letter
                                success_count += 1
                            }
                        }
                    }
                    if(success_count > 4){
                        Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) {
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                    }
                }

                else {
                    Toast.makeText(this, "Bad Guess!", Toast.LENGTH_SHORT).show()
                    death_counter += 1
                    if(death_counter == 1){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                    }
                    if(death_counter == 2){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                    }
                    if(death_counter == 3){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                    }
                    if(death_counter == 4){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                    }
                    if(death_counter == 5){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                    }
                    if(death_counter == 6){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmandone_foreground)
                    }
                    if (death_counter > 5){
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) { // Check if the resource exists
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                        Toast.makeText(this, "You are dead!", Toast.LENGTH_LONG).show()
                        Toast.makeText(this, "The word was $wordtoguess!", Toast.LENGTH_LONG).show()
                    }
                }
                Hbutton.isClickable = false
                Hbutton.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
            }
            Ibutton.setOnClickListener {
                var letter = "I"
                if (letter in wordtoguess) {
                    Toast.makeText(this, "Good Guess!", Toast.LENGTH_SHORT).show()
                    for (i in 0..wordtoguess.length - 1) {
                        if (wordtoguess[i].toString() == letter) {
                            if (i == 0) {
                                firstletter.text = letter
                                success_count += 1
                            }
                            if (i == 1) {
                                secondletter.text = letter
                                success_count += 1
                            }
                            if (i == 2) {
                                thirdletter.text = letter
                                success_count += 1
                            }
                            if (i == 3) {
                                fourthletter.text = letter
                                success_count += 1
                            }
                            if (i == 4) {
                                fifthletter.text = letter
                                success_count += 1
                            }
                            if (i == 5) {
                                sixthletter.text = letter
                                success_count += 1
                            }
                        }
                    }
                    if(success_count > 4){
                        Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) {
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                    }
                }
                else {
                    Toast.makeText(this, "Bad Guess!", Toast.LENGTH_SHORT).show()
                    death_counter += 1
                    if(death_counter == 1){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                    }
                    if(death_counter == 2){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                    }
                    if(death_counter == 3){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                    }
                    if(death_counter == 4){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                    }
                    if(death_counter == 5){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                    }
                    if(death_counter == 6){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmandone_foreground)
                    }
                    if (death_counter > 5){
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) { // Check if the resource exists
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                        Toast.makeText(this, "You are dead!", Toast.LENGTH_LONG).show()
                        Toast.makeText(this, "The word was $wordtoguess!", Toast.LENGTH_LONG).show()
                    }
                }
                Ibutton.isClickable = false
                Ibutton.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
            }
            Jbutton.setOnClickListener {
                var letter = "J"
                if (letter in wordtoguess) {
                    Toast.makeText(this, "Good Guess!", Toast.LENGTH_SHORT).show()
                    for (i in 0..wordtoguess.length - 1) {
                        if (wordtoguess[i].toString() == letter) {
                            if (i == 0) {
                                firstletter.text = letter
                                success_count += 1
                            }
                            if (i == 1) {
                                secondletter.text = letter
                                success_count += 1
                            }
                            if (i == 2) {
                                thirdletter.text = letter
                                success_count += 1
                            }
                            if (i == 3) {
                                fourthletter.text = letter
                                success_count += 1
                            }
                            if (i == 4) {
                                fifthletter.text = letter
                                success_count += 1
                            }
                            if (i == 5) {
                                sixthletter.text = letter
                                success_count += 1
                            }
                        }
                    }
                    if(success_count > 4){
                        Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) {
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                    }
                } else {
                    Toast.makeText(this, "Bad Guess!", Toast.LENGTH_SHORT).show()
                    death_counter += 1
                    if(death_counter == 1){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                    }
                    if(death_counter == 2){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                    }
                    if(death_counter == 3){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                    }
                    if(death_counter == 4){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                    }
                    if(death_counter == 5){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                    }
                    if(death_counter == 6){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmandone_foreground)
                    }
                    if (death_counter > 5){
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) { // Check if the resource exists
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                        Toast.makeText(this, "You are dead!", Toast.LENGTH_LONG).show()
                        Toast.makeText(this, "The word was $wordtoguess!", Toast.LENGTH_LONG).show()
                    }
                }
                Jbutton.isClickable = false
                Jbutton.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
            }
            Kbutton.setOnClickListener {
                var letter = "K"
                if (letter in wordtoguess) {
                    Toast.makeText(this, "Good Guess!", Toast.LENGTH_SHORT).show()
                    for (i in 0..wordtoguess.length - 1) {
                        if (wordtoguess[i].toString() == letter) {
                            if (i == 0) {
                                firstletter.text = letter
                                success_count += 1
                            }
                            if (i == 1) {
                                secondletter.text = letter
                                success_count += 1
                            }
                            if (i == 2) {
                                thirdletter.text = letter
                                success_count += 1
                            }
                            if (i == 3) {
                                fourthletter.text = letter
                                success_count += 1
                            }
                            if (i == 4) {
                                fifthletter.text = letter
                                success_count += 1
                            }
                            if (i == 5) {
                                sixthletter.text = letter
                                success_count += 1
                            }
                        }
                    }
                    if(success_count > 4){
                        Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) {
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                    }
                } else {
                    Toast.makeText(this, "Bad Guess!", Toast.LENGTH_SHORT).show()
                    death_counter += 1
                    if(death_counter == 1){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                    }
                    if(death_counter == 2){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                    }
                    if(death_counter == 3){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                    }
                    if(death_counter == 4){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                    }
                    if(death_counter == 5){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                    }
                    if(death_counter == 6){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmandone_foreground)
                    }
                    if (death_counter > 5){
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) { // Check if the resource exists
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                        Toast.makeText(this, "You are dead!", Toast.LENGTH_LONG).show()
                        Toast.makeText(this, "The word was $wordtoguess!", Toast.LENGTH_LONG).show()
                    }
                }
                Kbutton.isClickable = false
                Kbutton.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
            }
            Lbutton.setOnClickListener {
                var letter = "L"
                if (letter in wordtoguess) {
                    Toast.makeText(this, "Good Guess!", Toast.LENGTH_SHORT).show()
                    for (i in 0..wordtoguess.length - 1) {
                        if (wordtoguess[i].toString() == letter) {
                            if (i == 0) {
                                firstletter.text = letter
                                success_count += 1
                            }
                            if (i == 1) {
                                secondletter.text = letter
                                success_count += 1
                            }
                            if (i == 2) {
                                thirdletter.text = letter
                                success_count += 1
                            }
                            if (i == 3) {
                                fourthletter.text = letter
                                success_count += 1
                            }
                            if (i == 4) {
                                fifthletter.text = letter
                                success_count += 1
                            }
                            if (i == 5) {
                                sixthletter.text = letter
                                success_count += 1
                            }
                        }
                    }
                    if(success_count > 4){
                        Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) {
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                    }
                } else {
                    Toast.makeText(this, "Bad Guess!", Toast.LENGTH_SHORT).show()
                    death_counter += 1
                    if(death_counter == 1){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                    }
                    if(death_counter == 2){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                    }
                    if(death_counter == 3){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                    }
                    if(death_counter == 4){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                    }
                    if(death_counter == 5){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                    }
                    if(death_counter == 6){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmandone_foreground)
                    }
                    if (death_counter > 5){
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) { // Check if the resource exists
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                        Toast.makeText(this, "You are dead!", Toast.LENGTH_LONG).show()
                        Toast.makeText(this, "The word was $wordtoguess!", Toast.LENGTH_LONG).show()
                    }
                }
                Lbutton.isClickable = false
                Lbutton.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
            }
            Mbutton.setOnClickListener {
                var letter = "M"
                if (letter in wordtoguess) {
                    Toast.makeText(this, "Good Guess!", Toast.LENGTH_SHORT).show()
                    for (i in 0..wordtoguess.length - 1) {
                        if (wordtoguess[i].toString() == letter) {
                            if (i == 0) {
                                firstletter.text = letter
                                success_count += 1
                            }
                            if (i == 1) {
                                secondletter.text = letter
                                success_count += 1
                            }
                            if (i == 2) {
                                thirdletter.text = letter
                                success_count += 1
                            }
                            if (i == 3) {
                                fourthletter.text = letter
                                success_count += 1
                            }
                            if (i == 4) {
                                fifthletter.text = letter
                                success_count += 1
                            }
                            if (i == 5) {
                                sixthletter.text = letter
                                success_count += 1
                            }
                        }
                    }
                    if(success_count > 4){
                        Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) {
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                    }
                } else {
                    Toast.makeText(this, "Bad Guess!", Toast.LENGTH_SHORT).show()
                    death_counter += 1
                    if(death_counter == 1){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                    }
                    if(death_counter == 2){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                    }
                    if(death_counter == 3){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                    }
                    if(death_counter == 4){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                    }
                    if(death_counter == 5){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                    }
                    if(death_counter == 6){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmandone_foreground)
                    }
                    if (death_counter > 5){
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) { // Check if the resource exists
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                        Toast.makeText(this, "You are dead!", Toast.LENGTH_LONG).show()
                        Toast.makeText(this, "The word was $wordtoguess!", Toast.LENGTH_LONG).show()
                    }
                }
                Mbutton.isClickable = false
                Mbutton.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
            }
            Nbutton.setOnClickListener {
                var letter = "N"
                if (letter in wordtoguess) {
                    Toast.makeText(this, "Good Guess!", Toast.LENGTH_SHORT).show()
                    for (i in 0..wordtoguess.length - 1) {
                        if (wordtoguess[i].toString() == letter) {
                            if (i == 0) {
                                firstletter.text = letter
                                success_count += 1
                            }
                            if (i == 1) {
                                secondletter.text = letter
                                success_count += 1
                            }
                            if (i == 2) {
                                thirdletter.text = letter
                                success_count += 1
                            }
                            if (i == 3) {
                                fourthletter.text = letter
                                success_count += 1
                            }
                            if (i == 4) {
                                fifthletter.text = letter
                                success_count += 1
                            }
                            if (i == 5) {
                                sixthletter.text = letter
                                success_count += 1
                            }
                        }
                    }
                    if(success_count > 4){
                        Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) {
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                    }
                } else {
                    Toast.makeText(this, "Bad Guess!", Toast.LENGTH_SHORT).show()
                    death_counter += 1
                    if(death_counter == 1){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                    }
                    if(death_counter == 2){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                    }
                    if(death_counter == 3){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                    }
                    if(death_counter == 4){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                    }
                    if(death_counter == 5){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                    }
                    if(death_counter == 6){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmandone_foreground)
                    }
                    if (death_counter > 5){
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) { // Check if the resource exists
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                        Toast.makeText(this, "You are dead!", Toast.LENGTH_LONG).show()
                        Toast.makeText(this, "The word was $wordtoguess!", Toast.LENGTH_LONG).show()
                    }
                }
                Nbutton.isClickable = false
                Nbutton.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
            }
            Obutton.setOnClickListener {
                var letter = "O"
                if (letter in wordtoguess) {
                    Toast.makeText(this, "Good Guess!", Toast.LENGTH_SHORT).show()
                    for (i in 0..wordtoguess.length - 1) {
                        if (wordtoguess[i].toString() == letter) {
                            if (i == 0) {
                                firstletter.text = letter
                                success_count += 1
                            }
                            if (i == 1) {
                                secondletter.text = letter
                                success_count += 1
                            }
                            if (i == 2) {
                                thirdletter.text = letter
                                success_count += 1
                            }
                            if (i == 3) {
                                fourthletter.text = letter
                                success_count += 1
                            }
                            if (i == 4) {
                                fifthletter.text = letter
                                success_count += 1
                            }
                            if (i == 5) {
                                sixthletter.text = letter
                                success_count += 1
                            }
                        }
                    }
                    if(success_count > 4){
                        Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) {
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                    }
                } else {
                    Toast.makeText(this, "Bad Guess!", Toast.LENGTH_SHORT).show()
                    death_counter += 1
                    if(death_counter == 1){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                    }
                    if(death_counter == 2){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                    }
                    if(death_counter == 3){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                    }
                    if(death_counter == 4){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                    }
                    if(death_counter == 5){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                    }
                    if(death_counter == 6){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmandone_foreground)
                    }
                    if (death_counter > 5){
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) { // Check if the resource exists
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                        Toast.makeText(this, "You are dead!", Toast.LENGTH_LONG).show()
                        Toast.makeText(this, "The word was $wordtoguess!", Toast.LENGTH_LONG).show()
                    }
                }
                Obutton.isClickable = false
                Obutton.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
            }
            Pbutton.setOnClickListener {
                var letter = "P"
                if (letter in wordtoguess) {
                    Toast.makeText(this, "Good Guess!", Toast.LENGTH_SHORT).show()
                    for (i in 0..wordtoguess.length - 1) {
                        if (wordtoguess[i].toString() == letter) {
                            if (i == 0) {
                                firstletter.text = letter
                                success_count += 1
                            }
                            if (i == 1) {
                                secondletter.text = letter
                                success_count += 1
                            }
                            if (i == 2) {
                                thirdletter.text = letter
                                success_count += 1
                            }
                            if (i == 3) {
                                fourthletter.text = letter
                                success_count += 1
                            }
                            if (i == 4) {
                                fifthletter.text = letter
                                success_count += 1
                            }
                            if (i == 5) {
                                sixthletter.text = letter
                                success_count += 1
                            }
                        }
                    }
                    if(success_count > 4){
                        Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) {
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                    }
                } else {
                    Toast.makeText(this, "Bad Guess!", Toast.LENGTH_SHORT).show()
                    death_counter += 1
                    if(death_counter == 1){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                    }
                    if(death_counter == 2){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                    }
                    if(death_counter == 3){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                    }
                    if(death_counter == 4){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                    }
                    if(death_counter == 5){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                    }
                    if(death_counter == 6){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmandone_foreground)
                    }
                    if (death_counter > 5){
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) { // Check if the resource exists
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                        Toast.makeText(this, "You are dead!", Toast.LENGTH_LONG).show()
                        Toast.makeText(this, "The word was $wordtoguess!", Toast.LENGTH_LONG).show()
                    }
                }
                Pbutton.isClickable = false
                Pbutton.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
            }
            Qbutton.setOnClickListener {
                var letter = "Q"
                if (letter in wordtoguess) {
                    Toast.makeText(this, "Good Guess!", Toast.LENGTH_SHORT).show()
                    for (i in 0..wordtoguess.length - 1) {
                        if (wordtoguess[i].toString() == letter) {
                            if (i == 0) {
                                firstletter.text = letter
                                success_count += 1
                            }
                            if (i == 1) {
                                secondletter.text = letter
                                success_count += 1
                            }
                            if (i == 2) {
                                thirdletter.text = letter
                                success_count += 1
                            }
                            if (i == 3) {
                                fourthletter.text = letter
                                success_count += 1
                            }
                            if (i == 4) {
                                fifthletter.text = letter
                                success_count += 1
                            }
                            if (i == 5) {
                                sixthletter.text = letter
                                success_count += 1
                            }
                        }
                    }
                    if(success_count > 4){
                        Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) {
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                    }
                } else {
                    Toast.makeText(this, "Bad Guess!", Toast.LENGTH_SHORT).show()
                    death_counter += 1
                    if(death_counter == 1){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                    }
                    if(death_counter == 2){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                    }
                    if(death_counter == 3){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                    }
                    if(death_counter == 4){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                    }
                    if(death_counter == 5){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                    }
                    if(death_counter == 6){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmandone_foreground)
                    }
                    if (death_counter > 5){
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) { // Check if the resource exists
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                        Toast.makeText(this, "You are dead!", Toast.LENGTH_LONG).show()
                        Toast.makeText(this, "The word was $wordtoguess!", Toast.LENGTH_LONG).show()
                    }
                }
                Qbutton.isClickable = false
                Qbutton.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
            }
            Rbutton.setOnClickListener {
                var letter = "R"
                if (letter in wordtoguess) {
                    Toast.makeText(this, "Good Guess!", Toast.LENGTH_SHORT).show()
                    for (i in 0..wordtoguess.length - 1) {
                        if (wordtoguess[i].toString() == letter) {
                            if (i == 0) {
                                firstletter.text = letter
                                success_count += 1
                            }
                            if (i == 1) {
                                secondletter.text = letter
                                success_count += 1
                            }
                            if (i == 2) {
                                thirdletter.text = letter
                                success_count += 1
                            }
                            if (i == 3) {
                                fourthletter.text = letter
                                success_count += 1
                            }
                            if (i == 4) {
                                fifthletter.text = letter
                                success_count += 1
                            }
                            if (i == 5) {
                                sixthletter.text = letter
                                success_count += 1
                            }
                        }
                    }
                    if(success_count > 4){
                        Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) {
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                    }
                } else {
                    Toast.makeText(this, "Bad Guess!", Toast.LENGTH_SHORT).show()
                    death_counter += 1
                    if(death_counter == 1){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                    }
                    if(death_counter == 2){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                    }
                    if(death_counter == 3){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                    }
                    if(death_counter == 4){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                    }
                    if(death_counter == 5){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                    }
                    if(death_counter == 6){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmandone_foreground)
                    }
                    if (death_counter > 5){
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) { // Check if the resource exists
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                        Toast.makeText(this, "You are dead!", Toast.LENGTH_LONG).show()
                        Toast.makeText(this, "The word was $wordtoguess!", Toast.LENGTH_LONG).show()
                    }
                }
                Rbutton.isClickable = false
                Rbutton.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
            }
            Sbutton.setOnClickListener {
                var letter = "S"
                if (letter in wordtoguess) {
                    Toast.makeText(this, "Good Guess!", Toast.LENGTH_SHORT).show()
                    for (i in 0..wordtoguess.length - 1) {
                        if (wordtoguess[i].toString() == letter) {
                            if (i == 0) {
                                firstletter.text = letter
                                success_count += 1
                            }
                            if (i == 1) {
                                secondletter.text = letter
                                success_count += 1
                            }
                            if (i == 2) {
                                thirdletter.text = letter
                                success_count += 1
                            }
                            if (i == 3) {
                                fourthletter.text = letter
                                success_count += 1
                            }
                            if (i == 4) {
                                fifthletter.text = letter
                                success_count += 1
                            }
                            if (i == 5) {
                                sixthletter.text = letter
                                success_count += 1
                            }
                        }
                    }
                    if(success_count > 4){
                        Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) {
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                    }
                } else {
                    Toast.makeText(this, "Bad Guess!", Toast.LENGTH_SHORT).show()
                    death_counter += 1
                    if(death_counter == 1){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                    }
                    if(death_counter == 2){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                    }
                    if(death_counter == 3){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                    }
                    if(death_counter == 4){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                    }
                    if(death_counter == 5){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                    }
                    if(death_counter == 6){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmandone_foreground)
                    }
                    if (death_counter > 5){
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) { // Check if the resource exists
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                        Toast.makeText(this, "You are dead!", Toast.LENGTH_LONG).show()
                        Toast.makeText(this, "The word was $wordtoguess!", Toast.LENGTH_LONG).show()
                    }
                }
                Sbutton.isClickable = false
                Sbutton.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
            }
            Tbutton.setOnClickListener {
                var letter = "T"
                if (letter in wordtoguess) {
                    Toast.makeText(this, "Good Guess!", Toast.LENGTH_SHORT).show()
                    for (i in 0..wordtoguess.length - 1) {
                        if (wordtoguess[i].toString() == letter) {
                            if (i == 0) {
                                firstletter.text = letter
                                success_count += 1
                            }
                            if (i == 1) {
                                secondletter.text = letter
                                success_count += 1
                            }
                            if (i == 2) {
                                thirdletter.text = letter
                                success_count += 1
                            }
                            if (i == 3) {
                                fourthletter.text = letter
                                success_count += 1
                            }
                            if (i == 4) {
                                fifthletter.text = letter
                                success_count += 1
                            }
                            if (i == 5) {
                                sixthletter.text = letter
                                success_count += 1
                            }
                        }
                    }
                    if(success_count > 4){
                        Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) {
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                    }
                } else {
                    Toast.makeText(this, "Bad Guess!", Toast.LENGTH_SHORT).show()
                    death_counter += 1
                    if(death_counter == 1){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                    }
                    if(death_counter == 2){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                    }
                    if(death_counter == 3){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                    }
                    if(death_counter == 4){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                    }
                    if(death_counter == 5){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                    }
                    if(death_counter == 6){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmandone_foreground)
                    }
                    if (death_counter > 5){
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) { // Check if the resource exists
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                        Toast.makeText(this, "You are dead!", Toast.LENGTH_LONG).show()
                        Toast.makeText(this, "The word was $wordtoguess!", Toast.LENGTH_LONG).show()
                    }
                }
                Tbutton.isClickable = false
                Tbutton.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
            }
            Ubutton.setOnClickListener {
                var letter = "U"
                if (letter in wordtoguess) {
                    Toast.makeText(this, "Good Guess!", Toast.LENGTH_SHORT).show()
                    for (i in 0..wordtoguess.length - 1) {
                        if (wordtoguess[i].toString() == letter) {
                            if (i == 0) {
                                firstletter.text = letter
                                success_count += 1
                            }
                            if (i == 1) {
                                secondletter.text = letter
                                success_count += 1
                            }
                            if (i == 2) {
                                thirdletter.text = letter
                                success_count += 1
                            }
                            if (i == 3) {
                                fourthletter.text = letter
                                success_count += 1
                            }
                            if (i == 4) {
                                fifthletter.text = letter
                                success_count += 1
                            }
                            if (i == 5) {
                                sixthletter.text = letter
                                success_count += 1
                            }
                        }
                    }
                    if(success_count > 4){
                        Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) {
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                    }
                } else {
                    Toast.makeText(this, "Bad Guess!", Toast.LENGTH_SHORT).show()
                    death_counter += 1
                    if(death_counter == 1){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                    }
                    if(death_counter == 2){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                    }
                    if(death_counter == 3){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                    }
                    if(death_counter == 4){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                    }
                    if(death_counter == 5){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                    }
                    if(death_counter == 6){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmandone_foreground)
                    }
                    if (death_counter > 5){
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) { // Check if the resource exists
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                        Toast.makeText(this, "You are dead!", Toast.LENGTH_LONG).show()
                        Toast.makeText(this, "The word was $wordtoguess!", Toast.LENGTH_LONG).show()
                    }
                }
                Ubutton.isClickable = false
                Ubutton.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
            }
            Vbutton.setOnClickListener {
                var letter = "V"
                if (letter in wordtoguess) {
                    Toast.makeText(this, "Good Guess!", Toast.LENGTH_SHORT).show()
                    for (i in 0..wordtoguess.length - 1) {
                        if (wordtoguess[i].toString() == letter) {
                            if (i == 0) {
                                firstletter.text = letter
                                success_count += 1
                            }
                            if (i == 1) {
                                secondletter.text = letter
                                success_count += 1
                            }
                            if (i == 2) {
                                thirdletter.text = letter
                                success_count += 1
                            }
                            if (i == 3) {
                                fourthletter.text = letter
                                success_count += 1
                            }
                            if (i == 4) {
                                fifthletter.text = letter
                                success_count += 1
                            }
                            if (i == 5) {
                                sixthletter.text = letter
                                success_count += 1
                            }
                        }
                    }
                    if(success_count > 4){
                        Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) {
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                    }
                } else {
                    Toast.makeText(this, "Bad Guess!", Toast.LENGTH_SHORT).show()
                    death_counter += 1
                    if(death_counter == 1){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                    }
                    if(death_counter == 2){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                    }
                    if(death_counter == 3){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                    }
                    if(death_counter == 4){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                    }
                    if(death_counter == 5){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                    }
                    if(death_counter == 6){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmandone_foreground)
                    }
                    if (death_counter > 5){
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) { // Check if the resource exists
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                        Toast.makeText(this, "You are dead!", Toast.LENGTH_LONG).show()
                        Toast.makeText(this, "The word was $wordtoguess!", Toast.LENGTH_LONG).show()
                    }
                }
                Vbutton.isClickable = false
                Vbutton.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
            }
            Wbutton.setOnClickListener {
                var letter = "W"
                if (letter in wordtoguess) {
                    Toast.makeText(this, "Good Guess!", Toast.LENGTH_SHORT).show()
                    for (i in 0..wordtoguess.length - 1) {
                        if (wordtoguess[i].toString() == letter) {
                            if (i == 0) {
                                firstletter.text = letter
                                success_count += 1
                            }
                            if (i == 1) {
                                secondletter.text = letter
                                success_count += 1
                            }
                            if (i == 2) {
                                thirdletter.text = letter
                                success_count += 1
                            }
                            if (i == 3) {
                                fourthletter.text = letter
                                success_count += 1
                            }
                            if (i == 4) {
                                fifthletter.text = letter
                                success_count += 1
                            }
                            if (i == 5) {
                                sixthletter.text = letter
                                success_count += 1
                            }
                        }
                    }
                    if(success_count > 4){
                        Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) {
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                    }
                } else {
                    Toast.makeText(this, "Bad Guess!", Toast.LENGTH_SHORT).show()
                    death_counter += 1
                    if(death_counter == 1){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                    }
                    if(death_counter == 2){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                    }
                    if(death_counter == 3){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                    }
                    if(death_counter == 4){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                    }
                    if(death_counter == 5){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                    }
                    if(death_counter == 6){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmandone_foreground)
                    }
                    if (death_counter > 5){
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) { // Check if the resource exists
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                        Toast.makeText(this, "You are dead!", Toast.LENGTH_LONG).show()
                        Toast.makeText(this, "The word was $wordtoguess!", Toast.LENGTH_LONG).show()
                    }
                }
                Wbutton.isClickable = false
                Wbutton.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
            }
            Xbutton.setOnClickListener {
                var letter = "X"
                if (letter in wordtoguess) {
                    Toast.makeText(this, "Good Guess!", Toast.LENGTH_SHORT).show()
                    for (i in 0..wordtoguess.length - 1) {
                        if (wordtoguess[i].toString() == letter) {
                            if (i == 0) {
                                firstletter.text = letter
                                success_count += 1
                            }
                            if (i == 1) {
                                secondletter.text = letter
                                success_count += 1
                            }
                            if (i == 2) {
                                thirdletter.text = letter
                                success_count += 1
                            }
                            if (i == 3) {
                                fourthletter.text = letter
                                success_count += 1
                            }
                            if (i == 4) {
                                fifthletter.text = letter
                                success_count += 1
                            }
                            if (i == 5) {
                                sixthletter.text = letter
                                success_count += 1
                            }
                        }
                    }
                    if(success_count > 4){
                        Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) {
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                    }
                } else {
                    Toast.makeText(this, "Bad Guess!", Toast.LENGTH_SHORT).show()
                    death_counter += 1
                    if(death_counter == 1){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                    }
                    if(death_counter == 2){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                    }
                    if(death_counter == 3){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                    }
                    if(death_counter == 4){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                    }
                    if(death_counter == 5){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                    }
                    if(death_counter == 6){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmandone_foreground)
                    }
                    if (death_counter > 5){
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) { // Check if the resource exists
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                        Toast.makeText(this, "You are dead!", Toast.LENGTH_LONG).show()
                        Toast.makeText(this, "The word was $wordtoguess!", Toast.LENGTH_LONG).show()
                    }
                }
                Xbutton.isClickable = false
                Xbutton.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
            }
            Ybutton.setOnClickListener {
                var letter = "Y"
                if (letter in wordtoguess) {
                    Toast.makeText(this, "Good Guess!", Toast.LENGTH_SHORT).show()
                    for (i in 0..wordtoguess.length - 1) {
                        if (wordtoguess[i].toString() == letter) {
                            if (i == 0) {
                                firstletter.text = letter
                                success_count += 1
                            }
                            if (i == 1) {
                                secondletter.text = letter
                                success_count += 1
                            }
                            if (i == 2) {
                                thirdletter.text = letter
                                success_count += 1
                            }
                            if (i == 3) {
                                fourthletter.text = letter
                                success_count += 1
                            }
                            if (i == 4) {
                                fifthletter.text = letter
                                success_count += 1
                            }
                            if (i == 5) {
                                sixthletter.text = letter
                                success_count += 1
                            }
                        }
                    }
                    if(success_count > 4){
                        Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) {
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                    }
                } else {
                    Toast.makeText(this, "Bad Guess!", Toast.LENGTH_SHORT).show()
                    death_counter += 1
                    if(death_counter == 1){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                    }
                    if(death_counter == 2){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                    }
                    if(death_counter == 3){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                    }
                    if(death_counter == 4){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                    }
                    if(death_counter == 5){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                    }
                    if(death_counter == 6){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmandone_foreground)
                    }
                    if (death_counter > 5){
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) { // Check if the resource exists
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                        Toast.makeText(this, "You are dead!", Toast.LENGTH_LONG).show()
                        Toast.makeText(this, "The word was $wordtoguess!", Toast.LENGTH_LONG).show()
                    }
                }
                Ybutton.isClickable = false
                Ybutton.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
            }
            Zbutton.setOnClickListener {
                var letter = "Z"
                if (letter in wordtoguess) {
                    Toast.makeText(this, "Good Guess!", Toast.LENGTH_SHORT).show()
                    for (i in 0..wordtoguess.length - 1) {
                        if (wordtoguess[i].toString() == letter) {
                            if (i == 0) {
                                firstletter.text = letter
                                success_count += 1
                            }
                            if (i == 1) {
                                secondletter.text = letter
                                success_count += 1
                            }
                            if (i == 2) {
                                thirdletter.text = letter
                                success_count += 1
                            }
                            if (i == 3) {
                                fourthletter.text = letter
                                success_count += 1
                            }
                            if (i == 4) {
                                fifthletter.text = letter
                                success_count += 1
                            }
                            if (i == 5) {
                                sixthletter.text = letter
                                success_count += 1
                            }
                        }
                    }
                    if(success_count > 4){
                        Toast.makeText(this,"YOU WON!", Toast.LENGTH_LONG).show()
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) {
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                    }
                } else {
                    Toast.makeText(this, "Bad Guess!", Toast.LENGTH_SHORT).show()
                    death_counter += 1
                    if(death_counter == 1){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman2_foreground)
                    }
                    if(death_counter == 2){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman3_foreground)
                    }
                    if(death_counter == 3){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmanface_foreground)
                    }
                    if(death_counter == 4){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman4_foreground)
                    }
                    if(death_counter == 5){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangman5_foreground)
                    }
                    if(death_counter == 6){
                        findViewById<ImageView>(R.id.hangmanpic).setImageResource(R.mipmap.hangmandone_foreground)
                    }
                    if (death_counter > 5){
                        for (start in 'A'..'Z') {
                            val buttonId = "${start}button"
                            val resId = resources.getIdentifier(buttonId, "id", packageName)
                            if (resId != 0) { // Check if the resource exists
                                val button = findViewById<Button>(resId)
                                button.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
                                button.isClickable = false
                            }

                        }
                        Toast.makeText(this, "You are dead!", Toast.LENGTH_LONG).show()
                        Toast.makeText(this, "The word was $wordtoguess!", Toast.LENGTH_LONG).show()
                    }
                }
                Zbutton.isClickable = false
                Zbutton.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
            }
        }
}

