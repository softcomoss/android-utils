/*
 * Copyright 2020 Softcom Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ng.softcom.android.utils.remote

import java.net.ConnectException
import java.net.ProtocolException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.net.UnknownServiceException
import retrofit2.HttpException

/**
 * Utility methods for handling remote functionality.
 */
object RemoteUtils {

    /**
     * Get the error message from an exception
     *
     * @param throwable the exception to fetch the error message from.
     * @param httpErrorCatcher block of code to handle retrofit [HttpException].
     *
     * @return The error message.
     */
    fun extractErrorMessage(
        throwable: Throwable,
        httpErrorCatcher: HttpException.() -> String = { "" }
    ): String {
        return when (throwable) {
            is ConnectException -> ErrorMessages.CONNECT_EXCEPTION
            is UnknownHostException -> ErrorMessages.UNKNOWN_HOST_EXCEPTION
            is SocketTimeoutException -> ErrorMessages.SOCKET_TIME_OUT_EXCEPTION
            is UnknownServiceException -> throwable.message ?: ErrorMessages.PROTOCOL_EXCEPTION
            is ProtocolException -> ErrorMessages.PROTOCOL_EXCEPTION
            is HttpException -> throwable.httpErrorCatcher()
            else -> throwable.message ?: ErrorMessages.UNKNOWN_NETWORK_EXCEPTION
        }
    }
}
