package com.fusemachines.flower_retrofit.view

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.fusemachines.flower_retrofit.PictureContract
import com.fusemachines.flower_retrofit.R
import com.fusemachines.flower_retrofit.adapter.PictureAdapter
import com.fusemachines.flower_retrofit.model.PictureDetail
import com.fusemachines.flower_retrofit.model.PictureModel
import com.fusemachines.flower_retrofit.presenter.PicturePresenter
import kotlinx.android.synthetic.main.activity_images.*

class ImageListActivity : AppCompatActivity(), PictureContract.PictureView {

    lateinit var presenter: PicturePresenter
    lateinit var dialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_images)
        dialog = ProgressDialog(this)
//        dialog.setMessage("Please wait")
        dialog.setTitle("Loading")
        dialog.setCancelable(false)
        dialog.isIndeterminate = true
        dialog.show()

        presenter = PicturePresenter(this, PictureModel())
        presenter.getPictures()
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onSuccessPicture(list: List<PictureDetail>) {
        if (dialog.isShowing)
            dialog.dismiss()
        recyclerView.adapter = PictureAdapter(list) { flower: PictureDetail -> flowerClicked(flower) }
    }

    override fun onErrorPictures(error: String) {
        Toast.makeText(applicationContext, error, Toast.LENGTH_LONG).show()
    }

    private fun flowerClicked(flower: PictureDetail) {
        println(flower.name)
        var i = Intent(this, PictureDetailActivity::class.java)
        i.putExtra("Flower", flower)
        startActivity(i)
    }

}
