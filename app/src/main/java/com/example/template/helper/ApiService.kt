package com.example.template.helper

import com.example.template.model.Post
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Descreve os endpoints da API.
 *
 * Cada função é um endpoint. As anotações (`@GET`, `@POST`, `@Path`,
 * `@Query`, `@Body`, ...) dizem ao Retrofit como montar a requisição.
 * `suspend` permite chamar direto de uma coroutine, sem callback.
 */
interface ApiService {

    /** GET https://jsonplaceholder.typicode.com/posts */
    @GET("posts")
    suspend fun listPosts(): List<Post>

    /** GET https://jsonplaceholder.typicode.com/posts/{id} */
    @GET("posts/{id}")
    suspend fun getPost(
        @Path("id") id: Int
    ): Post
}
