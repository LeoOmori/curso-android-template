package com.example.template.model

import com.google.gson.annotations.SerializedName

/**
 * Modelo de exemplo que representa um item retornado pela API.
 *
 * A API usada como exemplo é a JSONPlaceholder:
 * https://jsonplaceholder.typicode.com/posts
 *
 * Use `@SerializedName` quando o nome do campo no JSON for diferente
 * do nome da propriedade em Kotlin.
 */
data class Post(
    @SerializedName("id") val id: Int,
    @SerializedName("userId") val userId: Int,
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String
)
