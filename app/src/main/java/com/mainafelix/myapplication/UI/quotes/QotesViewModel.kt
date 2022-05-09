package com.mainafelix.myapplication.UI.quotes

import androidx.lifecycle.ViewModel
import com.mainafelix.myapplication.data.Quote
import com.mainafelix.myapplication.data.QuoteRepository

class QotesViewModel(private val  quoteRepository: QuoteRepository):ViewModel() {
    // activities and fragment display  things on the screen and handles the user input
    // manipulation of data goes to the view model
    // the view calls functions that are only present in the view model
    // in this the data does not get reset when  an orientation occurs
    // the viewModel is only destroyed whebn the actvity is destroyed for Good
    fun getQuote() = quoteRepository.getQoute()
    fun addQuote(quote : Quote) = quoteRepository.addQuote(quote)


}
