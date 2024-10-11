package cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.data.network.dto

import com.google.gson.annotations.SerializedName

data class HitDto(
//    @SerializedName(value = "_highlightResult")
//    val highlightResult: HighlightResultDto,
    @SerializedName(value = "_tags")
    val tags: List<String>?,
    @SerializedName(value = "author")
    val author: String?,
    @SerializedName(value = "children")
    val children: List<Int?>?,
    @SerializedName(value = "comment_text")
    val commentText: String?,
    @SerializedName(value = "created_at")
    val createdAt: String?,
    @SerializedName(value = "created_at_i")
    val createdAtI: Int,
    @SerializedName(value = "num_comments")
    val numComments: Int?,
    @SerializedName(value = "objectID")
    val objectID: String?,
    @SerializedName(value = "parent_id")
    val parentId: Int?,
    @SerializedName(value = "points")
    val points: Int?,
    @SerializedName(value = "story_id")
    val storyId: Int?,
    @SerializedName(value = "story_text")
    val storyText: String?,
    @SerializedName(value = "story_title")
    val storyTitle: String?,
    @SerializedName(value = "story_url")
    val storyUrl: String?,
    @SerializedName(value = "title")
    val title: String?,
    @SerializedName(value = "updated_at")
    val updatedAt: String?,
    @SerializedName(value = "url")
    val url: String?
)