package com.csf.sample

import android.app.Application

class AppController : Application() {
    companion object {
        val restApi: RestApi by lazy {
            RestApiFactory.create()
        }
    }

}
