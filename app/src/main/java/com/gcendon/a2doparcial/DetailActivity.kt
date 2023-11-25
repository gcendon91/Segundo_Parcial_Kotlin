package com.gcendon.a2doparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var tvNameDetail: TextView
    private lateinit var tvCalories: TextView
    private lateinit var tvFat: TextView
    private lateinit var tvSugar: TextView
    private lateinit var tvCarbo: TextView
    private lateinit var tvProtein: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val fruit = intent.getParcelableExtra<Fruit>("fruit")

        tvNameDetail = findViewById(R.id.tvNameDetail)
        tvCalories = findViewById(R.id.tvCalories)
        tvFat = findViewById(R.id.tvFat)
        tvSugar = findViewById(R.id.tvSugar)
        tvCarbo = findViewById(R.id.tvCarbo)
        tvProtein = findViewById(R.id.tvProtein)

        tvNameDetail.text = fruit?.name

        tvCalories.text = "Calorias: " + fruit?.nutritions?.calories.toString()
        tvFat.text = "Grasas: " + fruit?.nutritions?.fat.toString()
        tvSugar.text = "Azucares: " + fruit?.nutritions?.sugar.toString()
        tvCarbo.text = "Carbohidratos: " + fruit?.nutritions?.carbohydrates.toString()
        tvProtein.text = "Proteinas: " + fruit?.nutritions?.protein.toString()


    }
}