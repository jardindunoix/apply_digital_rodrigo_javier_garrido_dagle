package cl.rodrigo_javier_garrido_dagle.mobiledevtest.domain.mappers

import cl.rodrigo_javier_garrido_dagle.mobiledevtest.data.database.entities.HitEntity
import cl.rodrigo_javier_garrido_dagle.mobiledevtest.data.network.dto.HitDto

fun HitDto.networkToDomain() = Hit(
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

fun HitDto.networkToEntity() = HitEntity(
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

