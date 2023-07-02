package com.example.select_img_from_gallery_android.View.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fm : FragmentManager?, lifeCycle : Lifecycle) : FragmentStateAdapter(fm!!, lifeCycle) {
    private val fragmentList : MutableList<Fragment> = ArrayList()
    private val titleList : MutableList<String> = ArrayList()

    override fun getItemCount(): Int {
        return ITEM_SIZE
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

    fun addFragment(fragment : Fragment, title : String){
        fragmentList.add(fragment)
        titleList.add(title)
    }

    fun getPageTitle(position : Int) : CharSequence?{
        return titleList[position]
    }

    companion object{
        private const val ITEM_SIZE = 3
    }



}