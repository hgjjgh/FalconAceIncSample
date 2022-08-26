package com.letsgo.myapplicationtest.network.service.response
import com.google.gson.annotations.SerializedName


data class NewsRes(
    @SerializedName("getVector")
    val getVector: GetVector?
)

data class GetVector(
    @SerializedName("items")
    val items: List<Item>?
)

data class Item(
    @SerializedName("appearance")
    val appearance: Appearance?,
    @SerializedName("extra")
    val extra: Extra?,
    @SerializedName("items")
    val items: List<SubItem>?,
    @SerializedName("_meta")
    val meta: Mata?,
    @SerializedName("ref")
    val ref: String?,
    @SerializedName("source")
    val source: String?,
    @SerializedName("style")
    val style: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("type")
    val type: String?
)

data class Appearance(
    @SerializedName("mainTitle")
    val mainTitle: String?,
    @SerializedName("subTitle")
    val subTitle: String?,
    @SerializedName("subscript")
    val subscript: String?,
    @SerializedName("thumbnail")
    val thumbnail: String?
)

data class Extra(
    @SerializedName("created")
    val created: Long?,
    @SerializedName("description")
    val description: String?
)

data class SubItem(
    @SerializedName("appearance")
    val appearance: Appearance?,
    @SerializedName("extra")
    val extra: Extra?,
    @SerializedName("_meta")
    val meta: Mata?,
    @SerializedName("ref")
    val ref: String?,
    @SerializedName("source")
    val source: String?,
    @SerializedName("type")
    val type: String?
)

data class Mata(
    @SerializedName("category")
    val category: List<String?>?,
    @SerializedName("section")
    val section: String?
)