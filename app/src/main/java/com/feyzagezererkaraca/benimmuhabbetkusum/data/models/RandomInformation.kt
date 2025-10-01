package com.feyzagezererkaraca.benimmuhabbetkusum.data.models

data class RandomInformation(
    val content: String,
    val author: String,
    val id: String = java.util.UUID.randomUUID().toString()
)

data class RandomInformationList(
    val informations: List<RandomInformation>
)