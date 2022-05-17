package com.mainafelix.myapplication.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuoteDao {
    // A fake database table
    private val quoteList = mutableListOf<Quote>()
//TODO "create
// a variable quote that creates a mutable live data to help change the value of
//the Live data from fakeDao class  and the data in this mutable data is of type List Quote
// MutableLiveData is from the Architecture Components Library
// LiveData can be observed for changes
private val quotes = MutableLiveData<List<Quote>>()

    init {
        //Todo assign the mutable live data to the quotes List
        // Immediately connect the now empty quoteList
        // to the MutableLiveData which can be observed
        quotes.value = quoteList
    }
    fun addQuote (quote :Quote){
       quoteList.add(quote)
        // After adding a quote to the "database",
        // update the value of MutableLiveData
        // which will notify its active observers
        quotes.value = quoteList
    }
    //todo cast the quotes to Live data

    // Casting MutableLiveData to LiveData because its value
    // shouldn't be changed from other classes
    fun getQuotes() = quotes as LiveData<List<Quote>>
}