package com.gcendon.a2doparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter
    private var listFruits = mutableListOf<Fruit>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvFruits)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = Adapter(listFruits)
        recyclerView.adapter = adapter

        adapter.onItemClickListener = { fruit ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("fruit", fruit)
            startActivity(intent)
        }
        getFruits()
    }

    private fun getFruits() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIServices::class.java).getFruit("fruit/all")
            val response = call.body()

            runOnUiThread {
                if (call.isSuccessful) {
                    val fruits = response

                    fruits?.forEach {
                        listFruits.add(it)
                    }
                    adapter.notifyDataSetChanged()
                }
            }
        }

    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    companion object {
        const val BASE_URL = "https://fruityvice.com/api/"
    }

}
