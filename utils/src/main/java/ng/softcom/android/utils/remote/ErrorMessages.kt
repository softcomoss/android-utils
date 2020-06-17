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

/**
 * Error messages to display in event of exception with api.
 */
object ErrorMessages {
    const val CONNECT_EXCEPTION =
        "Could not connect to the server. Please check your internet connection."
    const val SOCKET_TIME_OUT_EXCEPTION =
        "Request timed out while trying to connect. Please check your connection."
    const val UNKNOWN_NETWORK_EXCEPTION =
        "An unexpected error has occurred. Please check your connection."
    const val UNKNOWN_HOST_EXCEPTION =
        "Couldn't connect to the server at the moment."
    const val FORBIDDEN_EXCEPTION =
        "You're not authorised to connect at this moment. Please contact support."
    const val PROTOCOL_EXCEPTION =
        "An error occurred while connecting to the server. Please try again."
    const val SERVER_EXCEPTION =
        "An unexpected server error has occurred. Please contact support."
}
