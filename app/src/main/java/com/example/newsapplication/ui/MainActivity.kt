package com.example.newsapplication.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newsapplication.db.ArticleDatabase
import com.example.newsapplication.repository.NewsRepository
import com.example.newsapplication.R
import com.example.newsapplication.settings
import com.example.newsapplication.util.Constants.Companion.COUNTRY_CODE
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.alert_dialog.*
import kotlinx.android.synthetic.main.fragment_breaking_news.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel
    val TAG = "sharedpref"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            val sp = getSharedPreferences("mypref", Context.MODE_PRIVATE)
            val americaIschecked = sp.getBoolean("america",false)
            val indiaIschecked = sp.getBoolean("india",false)
            val russiaIschecked = sp.getBoolean("russia",false)
            val franceIschecked = sp.getBoolean("france",false)
            val brazilIschecked = sp.getBoolean("brazil",false)
            val japanIschecked = sp.getBoolean("japan",false)
            val germanyIschecked = sp.getBoolean("germany",false)
            val canadaIschecked = sp.getBoolean("canada",false)
            val southkoreaIschecked = sp.getBoolean("southkorea",false)

            val america = update("ameri")
            val india = update("ind")
            val russia = update("rus")
            val france = update("fran")
            val brazil = update("braz")
            val japan = update("jap")
            val germany = update("ger")
            val canada = update("can")
            val southkorea = update("korea")
            if(americaIschecked)
            {
                COUNTRY_CODE = america.toString()
                Log.i(TAG,"$COUNTRY_CODE")
            }else if(indiaIschecked){
                COUNTRY_CODE = india.toString()
                Log.i(TAG,"$COUNTRY_CODE")
            }else if(russiaIschecked){
                COUNTRY_CODE = russia.toString()
                Log.i(TAG,"$COUNTRY_CODE")
            }else if(franceIschecked){
                COUNTRY_CODE = france.toString()
                Log.i(TAG,"$COUNTRY_CODE")
            }else if(brazilIschecked){
                COUNTRY_CODE = brazil.toString()
                Log.i(TAG,"$COUNTRY_CODE")
            }else if(japanIschecked){
                COUNTRY_CODE = japan.toString()
                Log.i(TAG,"$COUNTRY_CODE")
            }else if(germanyIschecked){
                COUNTRY_CODE = germany.toString()
                Log.i(TAG,"$COUNTRY_CODE")
            }else if(canadaIschecked){
                COUNTRY_CODE = canada.toString()
                Log.i(TAG,"$COUNTRY_CODE")
            }else if(southkoreaIschecked){
                COUNTRY_CODE = southkorea.toString()
                Log.i(TAG,"$COUNTRY_CODE")
            }
        }
        catch (e:Exception){
            //Log.e("exception","$e")
        }
        val newsrepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application,newsrepository)
        viewModel = ViewModelProvider(this,viewModelProviderFactory).get(NewsViewModel::class.java)
        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.setting,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.settings -> {
                startActivity(Intent(this,settings::class.java))
                return true
            }
            R.id.Info ->{
                val inflater = LayoutInflater.from(this)
                val view = inflater.inflate(R.layout.alert_dialog,null)
                val alertDialog = AlertDialog.Builder(this)
                    .setView(view)
                    .setCancelable(true)
                    .setPositiveButton("Thanks for using this App"){dialogInterface,which->
                    }
                    .create()
                alertDialog.show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun update(key:String): String? {
        val sp = getSharedPreferences("mypref", Context.MODE_PRIVATE)
        return sp.getString(key,"invalid")
    }
     fun SaveIntoSharePref(key:String,value:Boolean,code:String,codeKey:String){
        val sharedPreferences = getSharedPreferences("mypref",Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply{
            putBoolean(key,value)
            putString(codeKey,code)
            apply()
        }
    }
     fun updatechip(key:String):Boolean{
        val sp = getSharedPreferences("mypref",Context.MODE_PRIVATE)
        return sp.getBoolean(key,false)
    }
    fun cleardata() {
        var prefs: SharedPreferences = getSharedPreferences("mypref",Context.MODE_PRIVATE) // here you get your prefrences by either of two methods
        val editor= prefs.edit()
        editor.clear()
        editor.commit()
    }
}
