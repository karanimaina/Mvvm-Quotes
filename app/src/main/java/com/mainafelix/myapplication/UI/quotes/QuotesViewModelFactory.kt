

package com.mainafelix.myapplication.UI.quotes

import QuoteRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

// The same repository that's needed for QuotesViewModel
// is also passed to the factory
class QuotesViewModelFactory(private val quoteRepository: QuoteRepository)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRepository) as T
    }
}
