package com.example.bdm_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.bdm_retrofit.helper.MyRepository
import com.example.bdm_retrofit.model.MyModel
import retrofit2.Call
import retrofit2.Response
import java.lang.StringBuilder
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textMain = findViewById<TextView>(R.id.text_main)

        val myServ = MyRepository.create()
        myServ.getPosts().enqueue(object : retrofit2.Callback<List<MyModel>>{
            override fun onResponse(call: Call<List<MyModel>>, response: Response<List<MyModel>>) {
                if (response.isSuccessful){
                    val data= response.body()
                    val builder= StringBuilder()
                    data?.map {
                        builder.append(it.body)
                    }
                    textMain.setText(builder.toString())
                }
            }

            override fun onFailure(call: Call<List<MyModel>>, error: Throwable) {
                Log.e("ERROR","${error.message}")
            }
        })
    }
}
