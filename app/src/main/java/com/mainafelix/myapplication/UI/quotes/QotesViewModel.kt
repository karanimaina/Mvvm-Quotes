package com.mainafelix.myapplication.UI.quotes

import QuoteRepository
import androidx.lifecycle.ViewModel
import com.mainafelix.myapplication.data.Quote

// QuoteRepository dependency will again be passed in the
// constructor using dependency injection
class QuotesViewModel(private val quoteRepository: QuoteRepository)
    : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}

