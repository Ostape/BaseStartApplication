package com.robosh.basestartapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class BrowseActivity : AppCompatActivity() {

    companion object {
        const val TAG = "TAGGERR"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browse)

        val parentJob = GlobalScope.launch(Dispatchers.Main) {
            GlobalScope.launch(Dispatchers.Main) {
                Log.d(TAG, "4 ${coroutineContext[Job]}")
                delay(4000L)
                Log.d(TAG, "5")
            }

            throw CancellationException("bla bla bla")
            withTimeout(2000L) {
                Log.d(TAG, "1 ${coroutineContext[Job]}")

                delay(3000L)
                Log.d(TAG, "after delay")
            }
            Log.d(TAG, "after timeout")


        }

        parentJob.invokeOnCompletion { cause -> Log.d(TAG, "invokeOnCompletion $cause") }
    }
}
