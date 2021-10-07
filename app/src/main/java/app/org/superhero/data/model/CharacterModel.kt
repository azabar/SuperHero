package app.org.superhero.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class CharacterModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("modified") val modified: Date,
    @SerializedName("urls") val urls: List<UrlModel>,
    @SerializedName("thumbnail") val thumbnail: ImageModel,
    @SerializedName("resourceURI") val resourceURI: String,
    @SerializedName("comics") val comics: ResourceListModel,
    @SerializedName("stories") val stories: ResourceListModel,
    @SerializedName("events") val events: ResourceListModel,
    @SerializedName("series") val series: ResourceListModel
)