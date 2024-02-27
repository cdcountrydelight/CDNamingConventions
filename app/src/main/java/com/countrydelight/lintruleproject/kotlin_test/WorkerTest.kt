package com.countrydelight.lintruleproject.kotlin_test

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class WrongWorkerClass(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    override fun doWork(): Result {
        TODO("Not yet implemented")
    }

}

class RightWorker(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    override fun doWork(): Result {
        TODO("Not yet implemented")
    }
}