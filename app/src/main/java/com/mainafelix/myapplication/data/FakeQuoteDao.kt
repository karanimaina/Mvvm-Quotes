package com.mainafelix.myapplication.data

import androidx.lifecycle.MutableLiveData

class FakeQuoteDao {
    private val quoteList = mutableListOf<Quote>()
//TODO "create
// a variable quote that creates a mutable live data to help change the value of
//the Live data from fakeDao class  and the data in this mutable data is of type List Quote

    private val quotes = MutableLiveData<List<Quote>>()

    init {
        //Todo assign the mutable live data to the quotes List
        quotes.value=  quoteList
    }
    fun addQuote (quote :Quote){
       quoteList.add(quote)
        quotes.value = quoteList
    }
}