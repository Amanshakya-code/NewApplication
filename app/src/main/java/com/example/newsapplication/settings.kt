package com.example.newsapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.newsapplication.util.Constants.Companion.COUNTRY_CODE
import kotlinx.android.synthetic.main.activity_settings.*

class settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        america.isChecked = update("america")
        india.isChecked = update("india")
        russia.isChecked = update("russia")
        france.isChecked = update("france")
        brazil.isChecked = update("brazil")
        japan.isChecked = update("japan")
        germany.isChecked = update("germany")
        canada.isChecked = update("canada")
        southKorea.isChecked = update("southkorea")


        america.setOnCheckedChangeListener{ buttonView,isChecked->
            SaveIntoSharePref("america",isChecked,"us","ameri")
        }
        india.setOnCheckedChangeListener{ buttonView,isChecked->
            SaveIntoSharePref("india",isChecked,"in","ind")
        }
        russia.setOnCheckedChangeListener{buttonView,isChecked->
            SaveIntoSharePref("russia",isChecked,"ru","rus")
        }
        france.setOnCheckedChangeListener{ buttonView,isChecked->
            SaveIntoSharePref("france",isChecked,"fr","fran")
        }
        brazil.setOnCheckedChangeListener{ buttonView,isChecked->
            SaveIntoSharePref("brazil",isChecked,"br","braz")
        }
        japan.setOnCheckedChangeListener{ buttonView,isChecked->
            SaveIntoSharePref("japan",isChecked,"jp","jap")
        }
        germany.setOnCheckedChangeListener{ buttonView,isChecked->
            SaveIntoSharePref("germany",isChecked,"de","ger")
        }
        canada.setOnCheckedChangeListener{ buttonView,isChecked->
            SaveIntoSharePref("canada",isChecked,"ca","can")
        }
        southKorea.setOnCheckedChangeListener{ buttonView,isChecked->
            SaveIntoSharePref("southkorea",isChecked,"kr","korea")
        }

    }
    private fun SaveIntoSharePref(key:String,value:Boolean,code:String,codeKey:String){
        val sharedPreferences = getSharedPreferences("mypref",Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply{
            putBoolean(key,value)
            putString(codeKey,code)
            apply()
        }
    }
    private fun update(key:String):Boolean{
        val sp = getSharedPreferences("mypref",Context.MODE_PRIVATE)
        return sp.getBoolean(key,false)
    }
}