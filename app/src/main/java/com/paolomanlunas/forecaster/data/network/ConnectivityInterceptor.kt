package com.paolomanlunas.forecaster.data.network

import okhttp3.Interceptor

/* ConnectivityInterceptor
*  - type of Interceptor that checks if there is a network connection.
*    It will throw and cache an Exception if there's no network connection.
*    We can PREVENT app from CRASHING when it doesn't detect a network connection.
* */

interface ConnectivityInterceptor : Interceptor