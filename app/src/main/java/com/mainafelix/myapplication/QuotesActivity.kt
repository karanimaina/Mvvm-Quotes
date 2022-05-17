package com.mainafelix.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mainafelix.myapplication.UI.quotes.QuotesViewModel
import com.mainafelix.myapplication.data.Quote
import com.mainafelix.myapplication.databinding.ActivityQuoteBinding
import com.mainafelix.myapplication.utility.InjectorUtils

class QuotesActivity : AppCompatActivity() {
 private  lateinit var  binding: ActivityQuoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuoteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initializeUi()
    }

    private fun initializeUi() {
        // Get the QuotesViewModelFactory with all of it's dependencies constructed
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        // Use ViewModelProviders class to create / get already created QuotesViewModel
        // for this view (activity)
        val viewModel = ViewModelProviders.of(this, factory)
            .get(QuotesViewModel::class.java)

        // Observing LiveData from the QuotesViewModel which in turn observes
        // LiveData from the repository, which observes LiveData from the DAO ☺
        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            binding.textViewQuotes.text = stringBuilder.toString()
        })

        // When button is clicked, instantiate a Quote and add it to DB through the ViewModel
       binding.buttonAddQuote.setOnClickListener {
            val quote = Quote(binding.editTextQuote.text.toString(), binding.editTextAuthor.text.toString())
            viewModel.addQuote(quote)
           binding.editTextQuote.setText("")
            binding.editTextAuthor.setText("")
        }
    }

}