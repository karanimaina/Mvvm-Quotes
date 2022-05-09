package com.mainafelix.myapplication.data

// TODO: generate a single ton pattern for the database and it will have a private constructor
class FakeDatabase private constructor() {

    // All the DAOs go here!
    var quoteDao = FakeQuoteDao()
        private set

    // todo generate a companion object that creates a single instance  of the class
    companion object {
        // @Volatile - Writes to this property are immediately visible to other threads
        @Volatile private var instance: FakeDatabase? = null

        fun getInstance() =

            // use the elvis operrator to return instance if not nuull or else synchronise the
            instance ?: synchronized(this){
                //2 threads cannot be executing at the same time
                //todo return fakedatabase instance if value is null
                instance ?: FakeDatabase().also {
                    //todo set the instance  to be equal to the database instance"
                    instance = it
                }
            }
        }


    }

