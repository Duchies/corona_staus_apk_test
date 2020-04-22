package com.example.myapplication_helloworld_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer[] images= {R.drawable.res1,R.drawable.gift,R.drawable.car };

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custum_layout,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.Image_view);
        imageView.setImageResource(images[position]);

        ViewPager viewPager = (ViewPager)container;
        viewPager .addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        ViewPager viewPager = (ViewPager)container;
       View  view=(View)object;
        viewPager.removeView(view);
    }
}
