# Android Template

Projeto base para o curso. Já vem com tudo configurado — é só abrir no
Android Studio, deixar o Gradle sincronizar e rodar.

## O que já vem pronto

- **Jetpack Compose** + **Material 3** (BOM controlando as versões)
- **Navigation Compose** com duas telas de exemplo (lista → detalhe)
- **Retrofit** + **Gson** + **OkHttp logging interceptor**
- **ViewModel** + **StateFlow** + `collectAsStateWithLifecycle`
- **Coroutines**
- **Coil** para carregar imagens da internet
- Ícones estendidos do Material (`material-icons-extended`)
- Permissão de `INTERNET` já declarada no `AndroidManifest.xml`
- Version catalog (`gradle/libs.versions.toml`) com todas as dependências

## Estrutura

```
app/src/main/java/com/example/template/
├── MainActivity.kt          # Activity única + NavHost (rotas do app)
├── helper/
│   ├── ApiService.kt        # endpoints da API (anotações do Retrofit)
│   └── RetrofitInstance.kt  # instância única do Retrofit (singleton)
├── model/
│   └── Post.kt              # modelo de dados (desserializado pelo Gson)
├── repository/
│   └── PostRepository.kt    # ponte entre a UI e a API
├── screen/
│   ├── HomeScreen.kt        # lista de posts
│   ├── HomeViewModel.kt     # estado da tela de lista
│   ├── DetailScreen.kt      # detalhe de um post
│   └── DetailViewModel.kt   # estado da tela de detalhe
└── ui/theme/                # cores, tipografia e tema do app
```

## API de exemplo

[JSONPlaceholder](https://jsonplaceholder.typicode.com/) — API pública e
gratuita para testes.

- `GET /posts` → lista de posts
- `GET /posts/{id}` → um post

## Como adaptar para o seu app

1. Troque `BASE_URL` em `helper/RetrofitInstance.kt`.
2. Ajuste os endpoints em `helper/ApiService.kt`.
3. Troque o modelo em `model/Post.kt` pelos campos do seu JSON.
4. Renomeie/duplique as telas em `screen/` conforme a sua necessidade.
5. (Opcional) troque o `namespace`/`applicationId` em `app/build.gradle.kts`
   e o pacote `com.example.template`.

## Rodar pela linha de comando

```bash
./gradlew assembleDebug        # gera o APK de debug
./gradlew installDebug         # instala no dispositivo/emulador conectado
./gradlew test                 # testes unitários
```
