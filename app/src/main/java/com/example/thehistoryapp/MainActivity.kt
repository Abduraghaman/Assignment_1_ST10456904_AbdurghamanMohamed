package com.example.thehistoryapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val historicFigures = mapOf(
        0..10 to "No historic figures for the age range",
        11..20 to "You are  the same age as Lady Jane Grey. An English noblewoman who briefly ruled England and Ireland from July 10 to July 19, 1553.\n" +
                "Known for her humanist education and kindness, she was sentenced to death at the tender age of seventeen.",
        21..30 to "You are  the same age as Sylvia Plath. An American poet known for her novel The Bell Jar and poetry collections like The Colossus and Ariel.\n" +
                "She wrote poetry from a young age and had a promising career.",
        31..40 to "You are the same age as Ralph Steinman. A brilliant Canadian immunologist and cell biologist at Rockefeller University.\n" +
                "He was awarded the 2011 Nobel Prize in Physiology or Medicine.",
        41..50 to "You are the same age as Alan Turing. An English mathematician and logician, Turing is considered the father of computer science and artificial intelligence. His code-breaking efforts during World War II significantly impacted the war’s duration.",
        51..60 to "You are  the same age as William Shakespeare. The renowned English playwright, poet, and actor, William Shakespeare, is celebrated as one of the greatest writers in the English language. His works, including timeless plays like 'Romeo and Juliet,' 'Hamlet,' and 'Macbeth,' continue to captivate audiences worldwide.",
        61..70 to "You are  the same age as Anthony Bourdain. A renowned American celebrity chef, author, and travel documentarian, Bourdain was known for his exploration of international culture and cuisine. His shows were immensely popular. Tragically, he died by suicide in France in June 2018.",
        71..80 to "You are same age as Kofi Annan. A Ghanaian diplomat who served as the seventh Secretary-General of the United Nations. His efforts in promoting peace, development, and human rights earned him the Nobel Peace Prize in 2001.",
        81 until Int.MAX_VALUE to "You are the same age as Michael Collins. One of the three astronauts, who worked on the ‘Apollo 11’ mission, which made the first lunar landing, one of the biggest events in the history of mankind."
    )

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val infoTextView = findViewById<TextView>(R.id.infoTextView)
        val editTextEnterAge = findViewById<EditText>(R.id.editTextEnterAge)
        val buttonGenerateHistory = findViewById<Button>(R.id.buttonGenerateHistory)
        val buttonClear = findViewById<Button>(R.id.buttonClear)

        buttonGenerateHistory.setOnClickListener {
            val ageText = editTextEnterAge.text.toString()
            if (ageText.isNotEmpty()) {
                val age = ageText.toIntOrNull()
                if (age != null) {
                    val historicFigure = findHistoricFigure(age)
                    infoTextView.text = historicFigure
                } else {
                    infoTextView.text = "Please enter a valid age"
                }
            } else {
                infoTextView.text = "Please enter age"
            }
        }

        buttonClear.setOnClickListener {
            infoTextView.text = ""
        }
    }

    private fun findHistoricFigure(age: Int): String {
        for ((ageRange, figure) in historicFigures) {
            if (age in ageRange) {
                return figure
            }
        }
        return "No historic figure found for this age"
    }
}
