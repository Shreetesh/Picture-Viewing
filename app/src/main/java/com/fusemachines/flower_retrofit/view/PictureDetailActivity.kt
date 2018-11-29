package com.fusemachines.flower_retrofit.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.fusemachines.flower_retrofit.R
import com.fusemachines.flower_retrofit.model.PictureDetail
import kotlinx.android.synthetic.main.activity_image_detail.*


class PictureDetailActivity : AppCompatActivity() {
    var imageUrl = "http://services.hanselandpetal.com/photos/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_detail)
        var picture = intent.getSerializableExtra("Flower") as PictureDetail
        tv_flower_title.text = picture.name
        tv_flower_category.text = "Category: " + picture.category
        tv_flower_price.text = "Price $" + picture.price
        tv_flower_desc.text = picture.instructions
        Glide.with(applicationContext).load(imageUrl + picture.photo).into(iv_flower_image)
    }

}
