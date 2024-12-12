package com.countrydelight.lintruleproject.kotlin_test

import android.app.Activity
import android.content.ActivityNotFoundException
import androidx.core.app.ActivityCompat.startIntentSenderForResult
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.credentials.HintRequest
import com.google.android.gms.common.api.GoogleApiClient

class FunctionExceptionHandleTest {

    fun hello(context: Activity) {
        try {
            val mGoogleApiClient = GoogleApiClient.Builder(context)
                .addApi(Auth.CREDENTIALS_API)
                .build()
            val hintRequest = HintRequest.Builder()
                .setPhoneNumberIdentifierSupported(true)
                .build()

            val intent = Auth.CredentialsApi.getHintPickerIntent(
                mGoogleApiClient, hintRequest
            )
            startIntentSenderForResult(context, intent.intentSender, 1, null, 0, 0, 0, null)
        } catch (e: ActivityNotFoundException) {
            e.printStackTrace()
        }
    }


    // throws exception
    @Throws(ArithmeticException::class)
    fun testThrowException() {

    }

    //wrong test catch exception
    fun wrongTestExceptionAtFunctionLevel() {
        testThrowException()
    }

    //right test catch exception
    @Throws(Exception::class)
    fun rightTestExceptionAtFunctionLevelByThrowingExceptionOnly() {
        testThrowException()
    }

    //right test catch exception
    @Throws(ArithmeticException::class)
    fun rightTestExceptionAtFunctionLevelByThrowingParticularException() {
        testThrowException()
    }

    //
    fun rightTestExceptionHandleAtTryCatchLevelByCatchingExceptionOnly() {
        try {
            testThrowException()
        } catch (exception: Exception) {

        }
    }

    fun rightTestExceptionHandleAtTryCatchLevelByCatchingParticularException() {
        try {
            testThrowException()
        } catch (exception: ArithmeticException) {

        }
    }
}