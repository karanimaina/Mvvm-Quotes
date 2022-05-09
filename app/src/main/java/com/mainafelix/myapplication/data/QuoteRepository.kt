package com.mainafelix.myapplication.data;
 class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao ) {
    // they are the source of data for the view model

     fun addQuote(quote: Quote){
         quoteDao.addQuote(quote)
     }
     //todo get the quotes
     fun getQoute () = quoteDao.getQuotes()
    companion object{
        // makes the right ofthis property visible to other threads
        @Volatile
        private var instance:QuoteRepository?= null
        fun getQuotes(quoteDao: FakeQuoteDao){
            // use the elvis operrator to return instance if not nuull or else synchronise the
            instance ?: synchronized(this){
                //2 threads cannot be executing at the same time
                //todo return fakedatabase instance if value is null
                instance ?:QuoteRepository(quoteDao).also {
                    //todo set the instance  to be equal to the database instance"

                }
            }
        }

    }}
