package fr.zzi.androidarchitecture.feature.detailedweather.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.zzi.androidarchitecture.R

class DetailedWeatherActivity : AppCompatActivity() {

    companion object {
        fun navigate(context: Context): Intent {
            return Intent(context, DetailedWeatherActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_weather)

        initFragment()
    }

    private fun initFragment() {
        //TODO add Fragment, ViewModel and Repository call
    }

}
