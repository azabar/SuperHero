package app.org.superhero.data.model

import com.google.gson.annotations.SerializedName

data class ItemModel(
    @SerializedName("resourceURI") val resourceURI: String,
    @SerializedName("name") val name: String
)
