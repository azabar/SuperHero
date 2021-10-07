package app.org.superhero.data.model

import com.google.gson.annotations.SerializedName

data class CallCharacterModel(
    @SerializedName("code") val code: Int,
    @SerializedName("status") val status: String,
    @SerializedName("data") val data: DataCharacterModel,
    @SerializedName("etag") val etag: String,
    @SerializedName("copyright") val copyright: String,
    @SerializedName("attributionText") val attributionText: String,
    @SerializedName("attributionHTML") val attributionHTML: String,
)