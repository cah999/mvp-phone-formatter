package com.example.mvp.presentation

import com.example.mvp.domain.model.PhoneNumber
import com.example.mvp.domain.usecase.FormatPhoneNumberUseCase


class MainPresenter(
    private var view: MainContract.View?,
    private val formatPhoneNumberUseCase: FormatPhoneNumberUseCase
) : MainContract.Presenter {

    override fun formatPhoneNumber(phoneNumber: PhoneNumber) {
        val formattedNumber = formatPhoneNumberUseCase.execute(phoneNumber)
        view?.displayResult(formattedNumber)
    }

    override fun onDestroy() {
        view = null
    }
}