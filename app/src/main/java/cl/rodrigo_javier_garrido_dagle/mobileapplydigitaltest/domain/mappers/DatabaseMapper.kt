package cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.domain.mappers

import cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.data.database.entities.HitEntity
import cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.domain.model.Hit

fun HitEntity.entityToDomain() = Hit(
    tags = tags,
    author = author,
    children = children,
    commentText = commentText,
    createdAt = createdAt,
    createdAtI = createdAtI,
    numComments = numComments,
    objectID = objectID,
    parentId = parentId,
    points = points,
    storyId = storyId,
    storyText = storyText,
    storyTitle = storyTitle,
    storyUrl = storyUrl,
    title = title,
    updatedAt = updatedAt,
    url = url
)