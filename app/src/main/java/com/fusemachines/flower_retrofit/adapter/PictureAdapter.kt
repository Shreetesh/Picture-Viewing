package com.fusemachines.flower_retrofit.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.fusemachines.flower_retrofit.R
import com.fusemachines.flower_retrofit.model.PictureDetail
import kotlinx.android.synthetic.main.item_gallery_list.view.*

class PictureAdapter(val pictureList: List<PictureDetail>, val itemclickListener: (PictureDetail) -> Unit) : RecyclerView.Adapter<PictureAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_gallery_list, p0, false))
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(pictureList.get(p1), itemclickListener)
    }

    override fun getItemCount(): Int {
        return pictureList.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var name = view.tv_name
        var price = view.tv_price
        var image = view.iv_image
        var urlImage = "http://services.hanselandpetal.com/photos/"
        fun bind(getPicture: PictureDetail, itemclickListener: (PictureDetail) -> Unit) {
            name.text = getPicture.name
            price.text = "Price: $" + getPicture.price
            Glide.with(itemView.context).load(urlImage + getPicture.photo).into(image)

            itemView.setOnClickListener { itemclickListener(getPicture) }


        }

    }

}