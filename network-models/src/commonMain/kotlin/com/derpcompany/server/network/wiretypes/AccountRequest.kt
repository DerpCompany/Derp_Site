package com.derpcompany.server.network.wiretypes

/**
 * Author: garci
 * Version: 1.0
 * Date: 6/22/2022 15:46
 *
 * Data we expect from the site user in the body of the request
 */

data class AccountRequest (
    val username: String,
    val email: String,
    val password: String,
)