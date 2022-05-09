package com.mainafelix.myapplication.utility

import com.mainafelix.myapplication.UI.quotes.QotesViewModel
import com.mainafelix.myapplication.UI.quotes.QuotesFactory
import com.mainafelix.myapplication.data.FakeDatabase
import com.mainafelix.myapplication.data.QuoteRepository

object InjectorUtils {
    // is a singleton doesn't require a constructior
    fun provideQuotesViewModelFactory():QuotesFactory{
        val  quoteRepository1 = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesFactory(quoteRepository1)

    }
}