package cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.data.network.dto

import com.google.gson.annotations.SerializedName

data class MainHitDto(
    @SerializedName("exhaustive") val exhaustive: ExhaustiveDto,
    @SerializedName("exhaustiveNbHits") val exhaustiveNbHits: Boolean,
    @SerializedName("exhaustiveTypo") val exhaustiveTypo: Boolean,
    @SerializedName("hits") val hits: List<HitDto>,
    @SerializedName("hitsPerPage") val hitsPerPage: Int,
    @SerializedName("nbHits") val nbHits: Int,
    @SerializedName("nbPages") val nbPages: Int,
    @SerializedName("page") val page: Int,
    @SerializedName("params") val params: String,
    @SerializedName("processingTimeMS") val processingTimeMS: Int,
//    @SerializedName("processingTimingsMS") val processingTimingsMS: ProcessingTimingsMSDto,
    @SerializedName("query") val query: String,
    @SerializedName("serverTimeMS") val serverTimeMS: Int
)