package com.mainafelix.myapplication.utility

import QuoteRepository
import com.mainafelix.myapplication.UI.quotes.QuotesViewModelFactory
import com.mainafelix.myapplication.data.FakeDatabase

// Finally a singleton which doesn't need anything passed to the constructor
object InjectorUtils {

    // This will be called from com.mainafelix.myapplication.QuotesActivity
    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        // ViewModelFactory needs a repository, which in turn needs a DAO from a database
        // The whole dependency tree is constructed right here, in one place
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}