package com.choihona.sohibkor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.choihona.sohibkor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())
        binding.bottomNavigationMain.setOnItemSelectedListener {
            when(it.itemId){

                R.id.home_icon -> replaceFragment(Home())
                R.id.education_icon -> replaceFragment(Education())
                R.id.finance_icon -> replaceFragment(Finance())
                R.id.news_icon -> replaceFragment(News())
                R.id.chat_icon -> replaceFragment(Chat())
                else -> {

                }
            }
            true
        }

    }

    private fun replaceFragment (fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}