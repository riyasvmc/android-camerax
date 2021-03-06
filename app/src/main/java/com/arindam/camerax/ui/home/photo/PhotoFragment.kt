package com.arindam.camerax.ui.home.photo

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import coil.api.load
import com.arindam.camerax.R
import com.arindam.camerax.ui.base.BaseFragment
import com.arindam.camerax.util.commons.Constants.FILE.FILE_NAME_KEY
import java.io.File

/**
 * Fragment used for each individual page showing a photo inside of [GalleryFragment]
 *
 * Created by Arindam Karmakar on 9/5/19.
 */

class PhotoFragment internal constructor() : BaseFragment() {

    companion object {
        fun create(image: File) = PhotoFragment().apply {
            arguments = Bundle().apply {
                putString(FILE_NAME_KEY, image.absolutePath)
            }
        }
    }

    override fun provideLayout(): Int = 0
    override fun provideView(): View? = ImageView(context)

    override fun setupView(view: View, savedInstanceState: Bundle?) {
        val args = arguments ?: return
        val resource = args.getString(FILE_NAME_KEY)?.let { File(it) }
        (view as? ImageView)?.load(resource)
    }
}
