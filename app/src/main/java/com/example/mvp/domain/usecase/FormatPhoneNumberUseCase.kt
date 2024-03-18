package com.example.mvp.domain.usecase

import com.example.mvp.data.PhoneNumberRepository
import com.example.mvp.domain.model.PhoneNumber

class FormatPhoneNumberUseCase(private val repository: PhoneNumberRepository) {
    fun execute(phoneNumber: PhoneNumber): String {
        return repository.formatPhoneNumber(phoneNumber.number)
    }
}