package com.example.template.repository

import com.example.template.helper.RetrofitInstance
import com.example.template.model.Post

/**
 * Camada entre a UI e a fonte de dados (API).
 *
 * A tela / ViewModel não fala direto com o Retrofit: ela pede os dados
 * ao repositório. Assim fica fácil trocar a fonte (cache, banco local,
 * outra API) sem mexer na tela.
 */
class PostRepository(
    private val api: com.example.template.helper.ApiService = RetrofitInstance.api
) {

    suspend fun listPosts(): List<Post> = api.listPosts()

    suspend fun getPost(id: Int): Post = api.getPost(id)
}
