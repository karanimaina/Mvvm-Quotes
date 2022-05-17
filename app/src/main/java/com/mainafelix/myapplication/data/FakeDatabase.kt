package com.mainafelix.myapplication.data

// TODO: generate a single ton pattern for the database and it will have a private constructor
// Private primary constructor inaccessible from other classes
class FakeDatabase private constructor() {

    // All the DAOs go here!
    var quoteDao = FakeQuoteDao()
        private set

    // todo generate a companion object that creates a single instance  of the class
    companion object {
        // @Volatile - Writes to this property are immediately visible to other threads
        @Volatile private var instance: FakeDatabase? = null
        // The only way to get hold of the FakeDatabase object
        fun getInstance() =
        // Already instantiated? - return the instance
        // Otherwise instantiate in a thread-safe manner
            // use the elvis operrator to return instance if not nuull or else synchronise the
            instance ?: synchronized(this){
                //2 threads cannot be executing at the same time
                //todo return fakedatabase instance if value is null
                // If it's still not instantiated, finally create an object
                // also set the "instance" property to be the currently created one
                instance ?: FakeDatabase().also {
                    //todo set the instance  to be equal to the database instance"
                    instance = it
                }
            }
        }


    }

