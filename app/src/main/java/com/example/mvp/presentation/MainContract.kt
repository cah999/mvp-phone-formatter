package com.example.mvp.presentation

import com.example.mvp.domain.model.PhoneNumber

interface MainContract {
    interface View {
        fun displayResult(formattedNumber: String)
        fun displayError(message: String)
    }

    interface Presenter {
        fun formatPhoneNumber(phoneNumber: PhoneNumber)
        fun onDestroy()
    }
}