package com.example.solarapp.data

data class Station(
    val id: Int,
    val name: String,
    val location: String,
    val ports: Int,
    val status: String
)