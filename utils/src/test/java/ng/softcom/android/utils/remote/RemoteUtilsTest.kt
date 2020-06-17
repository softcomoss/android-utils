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
import ng.softcom.android.utils.remote.RemoteUtils.extractErrorMessage
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response

class RemoteUtilsTest {

    @Test
    fun extractErrorMessage_returnsCorrectMessage() {
        val connectException = ConnectException()
        assert(extractErrorMessage(connectException) == ErrorMessages.CONNECT_EXCEPTION)

        val unknownHostException = UnknownHostException()
        assert(extractErrorMessage(unknownHostException) == ErrorMessages.UNKNOWN_HOST_EXCEPTION)

        val socketTimeoutException = SocketTimeoutException()
        assert(extractErrorMessage(socketTimeoutException) == ErrorMessages.SOCKET_TIME_OUT_EXCEPTION)

        val unknownServiceException = UnknownServiceException()
        assert(extractErrorMessage(unknownServiceException) == ErrorMessages.PROTOCOL_EXCEPTION)

        val expectedMessage = "expected message"
        val unknownServiceExceptionWithMessage = UnknownServiceException(expectedMessage)
        assert(extractErrorMessage(unknownServiceExceptionWithMessage) == expectedMessage)

        val protocolException = ProtocolException()
        assert(extractErrorMessage(protocolException) == ErrorMessages.PROTOCOL_EXCEPTION)

        val exception = Exception()
        assert(extractErrorMessage(exception) == ErrorMessages.UNKNOWN_NETWORK_EXCEPTION)
    }

    @Test
    fun extractErrorMessage_runsHttpErrorCatcher() {
        val errorMessage = "forbidden"
        val httpCode = 403

        val responseError = Response.error<Nothing>(
            httpCode,
            ResponseBody.create(MediaType.parse("text/plain"), "body")
        )
        val httpException = HttpException(responseError)
        assert(extractErrorMessage(httpException) {
            if (code() == httpCode) errorMessage else ""
        } == errorMessage)
    }
}
