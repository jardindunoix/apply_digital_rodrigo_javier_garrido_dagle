package cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(
    tableName = "hit",
//    primaryKeys = ["id", "created_at_id"]
)
data class HitEntity(
    @ColumnInfo(name = "id")
    var id: String = UUID.randomUUID().toString(),

    @ColumnInfo(name = "tags")
    val tags: List<String?>?,
    @ColumnInfo(name = "author")
    val author: String?,
    @ColumnInfo(name = "children")
    val children: List<Int?>?,
    @ColumnInfo(name = "comment_text")
    val commentText: String?,
    @ColumnInfo(name = "created_at")
    val createdAt: String?,

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "created_at_id")
    var createdAtI: Int = -1,

    @ColumnInfo(name = "num_comments")
    val numComments: Int?,
    @ColumnInfo(name = "object_id")
    val objectID: String?,
    @ColumnInfo(name = "parent_id")
    val parentId: Int?,
    @ColumnInfo(name = "points")
    val points: Int?,
    @ColumnInfo(name = "story_id")
    val storyId: Int?,
    @ColumnInfo(name = "story_text")
    val storyText: String?,
    @ColumnInfo(name = "story_title")
    val storyTitle: String?,
    @ColumnInfo(name = "story_url")
    val storyUrl: String?,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "updated_at")
    val updatedAt: String?,
    @ColumnInfo(name = "url")
    val url: String?,
    @ColumnInfo(name = "is_showed")
    val isShowed: Boolean = true,
)