package com.example.jobswaitingcancelation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val job = GlobalScope.launch(Dispatchers.Default){
            Log.d(TAG, "Starting long running calculation...")
            withTimeout(2000L) {
                for (i in 30..40) {
                    if (isActive) {
                        Log.d(TAG, "Result for i = $i : ${fib(i)}")
                    }
                }
                Log.d(TAG, "Ending long running calculation...")
            }
        }
    }

    fun fib(n: Int): Long{
        return if(n==0) 0
        else if (n==1) 1
        else fib(n-1)+fib(n-2)
    }

}