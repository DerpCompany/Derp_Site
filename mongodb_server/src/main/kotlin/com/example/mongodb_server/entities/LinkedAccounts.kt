package com.example.mongodb_server.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("linkedaccounts")
data class LinkedAccounts(
    @Id
    var userId: SavedUser,
    var accounts: Map<String, String> // list of SSOIDs from Oauth2 linked accounts with their keys(names)
)