package com.example.myfm.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myfm.MainActivity
import com.example.myfm.R
import com.example.myfm.databinding.ItemTutorialImageBinding
import com.example.myfm.models.TutorialImage

class ImagePagerAdapter(private val context: Context, private val images: List<TutorialImage>) :
    RecyclerView.Adapter<ImagePagerAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(val binding: ItemTutorialImageBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ImageViewHolder(

        ItemTutorialImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val currentImage = images[position]
        val currentDescription = images[position].description
        val currentFileUrl = images[position].fileUrl
        val imageView = holder.binding.imageView
        Glide.with(holder.itemView)
            .load(currentImage.imageId)
            .into(imageView)
        val textView = holder.binding.textDescription
        textView.text = currentDescription

        if (!currentFileUrl.isNullOrBlank()) {
            val uploadButton = holder.binding.uploadButton
            uploadButton.visibility = View.VISIBLE
            uploadButton.setOnClickListener {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(currentFileUrl)
                )
                context.startActivity(intent)
            }
        }

        if (position == MAX_ITEMS_VIEWPAGER) {
            val intent = Intent(context, MainActivity::class.java)
            intent.setAction(FROM_TUTORIAL_EXTRAS)

            val uploadButton = holder.binding.uploadButton
            uploadButton.text = context.getString(R.string.upload_button_text)
            uploadButton.visibility = View.VISIBLE

            uploadButton.setOnClickListener {
                context.startActivity(intent)
            }
        }

    }

    override fun getItemCount(): Int {
        return images.size
    }

    companion object {
        private const val FROM_TUTORIAL_EXTRAS = "FROM_TUTORIAL_EXTRAS"
        private const val MAX_ITEMS_VIEWPAGER = 5
    }
}
