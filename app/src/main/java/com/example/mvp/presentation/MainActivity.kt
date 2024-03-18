package com.example.mvp.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mvp.R
import com.example.mvp.data.PhoneNumberRepository
import com.example.mvp.domain.model.PhoneNumber
import com.example.mvp.domain.usecase.FormatPhoneNumberUseCase

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var editTextPhoneNumber: EditText
    private lateinit var buttonFormat: Button
    private lateinit var textViewResult: TextView
    private lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber)
        buttonFormat = findViewById(R.id.buttonFormat)
        textViewResult = findViewById(R.id.textViewResult)

        val repository = PhoneNumberRepository()
        val useCase = FormatPhoneNumberUseCase(repository)
        presenter = MainPresenter(this, useCase)

        buttonFormat.setOnClickListener {
            val phoneNumber = PhoneNumber(editTextPhoneNumber.text.toString())
            presenter.formatPhoneNumber(phoneNumber)
        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun displayResult(formattedNumber: String) {
        textViewResult.text = formattedNumber
    }

    override fun displayError(message: String) {
        textViewResult.text = message
    }
}