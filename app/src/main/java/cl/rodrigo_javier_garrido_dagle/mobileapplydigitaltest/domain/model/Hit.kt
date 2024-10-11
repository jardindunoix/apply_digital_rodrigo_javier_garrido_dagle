package cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.domain.model

data class Hit(
    val tags: List<String?>?,
    val author: String?,
    val children: List<Int?>?,
    val commentText: String?,
    val createdAt: String?,
    val createdAtI: Int?,
    val numComments: Int?,
    val objectID: String?,
    val parentId: Int?,
    val points: Int?,
    val storyId: Int?,
    val storyText: String?,
    val storyTitle: String?,
    val storyUrl: String?,
    val title: String?,
    val updatedAt: String?,
    val url: String?
)