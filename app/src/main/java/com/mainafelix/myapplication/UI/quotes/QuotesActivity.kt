package com.mainafelix.myapplication.UI.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mainafelix.myapplication.R
import com.mainafelix.myapplication.utility.InjectorUtils

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)
        initializeUi()
    }
    private fun initializeUi(){
        val  factory =InjectorUtils.provideQuotesViewModelFactory()
        val viewModel =ViewModelProviders.of(this, factory)
            .get(QotesViewModel::class.java)
    }
}