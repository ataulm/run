package com.ataulm.run

import android.content.Context
import android.net.Uri
import androidx.wear.phone.interactions.authentication.CodeChallenge
import androidx.wear.phone.interactions.authentication.CodeVerifier
import androidx.wear.phone.interactions.authentication.OAuthRequest
import androidx.wear.phone.interactions.authentication.OAuthResponse
import androidx.wear.phone.interactions.authentication.RemoteAuthClient
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * Uses the [RemoveAuthClient] to initiate the OAuth 2.0 flow to obtain an access token.
 *
 * [RemoteAuthClient] operates by opening the Strava auth screen on a connected mobile phone so the
 * user can sign in. It's controlled by the (OEM) companion app which all users should have anyway
 * because it's necessary to setup the watch.
 */
class ObtainStravaAccessToken @Inject constructor(
    @ApplicationContext private val context: Context
) {

    operator fun invoke(
        onAccessTokenObtained: (String) -> Unit,
        onAuthError: () -> Unit
    ) {
        val codeChallenge = CodeChallenge(CodeVerifier())
        val request = OAuthRequest.Builder(context)
            .setAuthProviderUrl(
                Uri.parse("http://www.strava.com/oauth/authorize")
                    .buildUpon()
                    .appendQueryParameter("approval_prompt", "auto")
                    .appendQueryParameter("scope", "activity:write,read")
                    .build()
            )
            .setClientId(BuildConfig.STRAVA_RUN_CLIENT_ID)
            .setCodeChallenge(codeChallenge)
            .build()

        RemoteAuthClient.create(context)
            .sendAuthorizationRequest(
                request = request,
                executor = { callback -> callback.run() },
                clientCallback = object : RemoteAuthClient.Callback() {
                    override fun onAuthorizationError(request: OAuthRequest, errorCode: Int) {
                        onAuthError()
                    }

                    override fun onAuthorizationResponse(request: OAuthRequest, response: OAuthResponse) {
                        if (response.errorCode != -1) {
                            response.responseUrl?.getQueryParameter("code")?.run {
                                onAccessTokenObtained(this)
                            }
                        } else {
                            onAuthError()
                        }
                    }
                }
            )
    }
}
