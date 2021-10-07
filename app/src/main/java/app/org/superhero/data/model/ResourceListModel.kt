package app.org.superhero.data.model

import com.google.gson.annotations.SerializedName

data class ResourceListModel(
    @SerializedName("available") val available: Int,
    @SerializedName("returned") val returned: Int,
    @SerializedName("collectionURI") val collectionURI: String,
    @SerializedName("items") val items: Array<ItemModel>
)
