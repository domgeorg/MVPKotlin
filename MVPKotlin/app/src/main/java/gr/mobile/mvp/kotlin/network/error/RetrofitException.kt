package gr.mobile.mvp.kotlin.network.error

import retrofit2.Response
import retrofit2.Retrofit
import java.io.IOException

/**
 * Identifies the event kind which triggered a [RetrofitException].
 */
enum class Kind {
    /**
     * An [IOException] occurred while communicating to the server.
     */
    NETWORK,
    /**
     * A non-200 HTTP status code was received from the server.
     */
    HTTP,
    /**
     * An internal error occurred while attempting to execute a request. It is best practice to
     * re-throw this exception so your application crashes.
     */
    UNEXPECTED
}

class RetrofitException(
    private val code: Int?,
    message: String?,
    private val url: String?,
    private val response: Response<*>?,
    private val kind: Kind,
    exception: Throwable?,
    private val retrofit: Retrofit?
) : RuntimeException(message, exception) {

    private var error: Error? = null

    companion object {
        fun httpError(url: String, response: Response<*>, retrofit: Retrofit): RetrofitException {
            val message = response.code().toString() + " " + response.message()
            return RetrofitException(response.code(), message, url, response, Kind.HTTP, null, retrofit)
        }

        fun networkError(exception: IOException): RetrofitException {
            return RetrofitException(0, exception.message, null, null, Kind.NETWORK, exception, null)
        }

        fun unexpectedError(exception: Throwable): RetrofitException {
            return RetrofitException(0, exception.message, null, null, Kind.UNEXPECTED, exception, null)
        }
    }

    /**
     * There Error object returned as response.
     */
    fun getErrorBody(): Error? =
        error?.let {
            try {
                getErrorBodyAs(java.lang.Error::class.java)
            } catch (e: IOException) {
                null
            }
        }

    /**
     * HTTP response body converted to specified `type`. `null` if there is no
     * response.
     *
     * @throws IOException if unable to convert the body to the specified `type`.
     */
    @Throws(IOException::class)
    fun <T> getErrorBodyAs(type: Class<T>): T? {
        if (response?.errorBody() == null) {
            return null
        }
        val converter = retrofit?.responseBodyConverter<T>(type, arrayOfNulls(0))
        return converter?.convert(response.errorBody()!!)
    }
}