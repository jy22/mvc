package com.example.mvc.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@Suppress("DEPRECATION")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class UserRequest (
    var name: String?=null,
    var age: Int?=null,
    var email: String?=null,
    var address: String?=null,

    @JsonProperty("phone_number")
    var phoneNumber:String?=null // rest-api snake case
)