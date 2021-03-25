package com.robosh.basestartapplication.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

class MovieSchedulerWorkManager(
    context: Context,
    workerParameters: WorkerParameters
) : Worker(context, workerParameters) {

    companion object {
        const val TAG = "SampleWorker"
    }

    override fun doWork(): Result {
        val inputData: Data = inputData
        val number = inputData.getInt("number", 0)
        Log.d(TAG, "doWork: number $number")
        for(i in 0..number) {
            Log.d(TAG, "doWork: i was: $i")
            Thread.sleep(1000)
        }
        return Result.success()
    }
}