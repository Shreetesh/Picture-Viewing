package com.fusemachines.flower_retrofit.presenter

import com.fusemachines.flower_retrofit.PictureContract
import com.fusemachines.flower_retrofit.model.PictureDetail

class PicturePresenter(val pictureView: PictureContract.PictureView, val pictureModel: PictureContract.PictureModel) : PictureContract.PicturePresenter, PictureContract.ModelListener {
    override fun getPictures() {
        pictureModel.getPicturesFromApi(this)
    }

    override fun onSuccess(list: List<PictureDetail>) {
        pictureView.onSuccessPicture(list)
    }

    override fun onError(error: String) {
        pictureView.onErrorPictures(error)
    }

}