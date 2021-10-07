package app.org.superhero.data.model

import com.google.gson.annotations.SerializedName

data class ImageModel(
    @SerializedName("path") val path: String,
    @SerializedName("extension") val extension: String
)
