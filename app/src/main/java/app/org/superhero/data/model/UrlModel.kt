package app.org.superhero.data.model

import com.google.gson.annotations.SerializedName

data class UrlModel(
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String
)