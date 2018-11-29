package com.fusemachines.flower_retrofit

import com.fusemachines.flower_retrofit.model.PictureDetail

interface PictureContract {
    interface PicturePresenter {
        fun getPictures()
    }

    interface PictureView {
        fun onSuccessPicture(list: List<PictureDetail>)
        fun onErrorPictures(error: String)

    }

    interface PictureModel {
        fun getPicturesFromApi(listener: ModelListener)
    }

    interface ModelListener {
        fun onSuccess(list: List<PictureDetail>)
        fun onError(error: String)
    }
}