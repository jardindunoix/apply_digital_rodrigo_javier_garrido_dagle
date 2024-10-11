package cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.data.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor() : Interceptor {

   override fun intercept(chain: Interceptor.Chain): Response {
      val request = chain
         .request()
         .newBuilder()
         .header(
            "Content-Type",
            "Application/json"
         )
         .build()
      return chain.proceed(request)
   }

}
