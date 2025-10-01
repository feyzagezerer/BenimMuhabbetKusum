package com.feyzagezererkaraca.benimmuhabbetkusum.include


sealed class InformationsState<out T> {
    data class Success<T>(val data: T) : InformationsState<T>()
    data class Error(val message: String) : InformationsState<Nothing>()
    object Loading : InformationsState<Nothing>()
}