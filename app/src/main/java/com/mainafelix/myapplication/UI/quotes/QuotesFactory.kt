@file:Suppress("UNCHECKED_CAST")

package com.mainafelix.myapplication.UI.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mainafelix.myapplication.data.QuoteRepository

    // instantiates the views in the activity after orientaion changes"
    class QuotesFactory (private val quoteRepository: QuoteRepository):ViewModelProvider.NewInstanceFactory(){
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return QotesViewModel(quoteRepository) as T
        }
}