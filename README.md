# Android Template

Projeto base para o curso. Já vem com tudo configurado, é só abrir no
Android Studio, deixar o Gradle sincronizar e rodar.

## O que já vem pronto

- **Jetpack Compose** + **Material 3** (BOM controlando as versões)
- **Navigation Compose** já configurado (NavHost com uma tela; adicione as próximas)
- **Retrofit** + **Gson** + **OkHttp logging interceptor** — só as dependências,
  sem código ainda
- **Coroutines** e **Coil** (carregar imagens da internet) — dependências prontas
- Permissão de `INTERNET` já declarada no `AndroidManifest.xml`
- Version catalog (`gradle/libs.versions.toml`) com todas as dependências
- Paleta de cores do app de quiz em `ui/theme/Color.kt` (fundo escuro, dourado
  de destaque e as cores das casas de Hogwarts), já ligada ao `MaterialTheme`
- Imagem de exemplo em `res/drawable/image.png`

## Estrutura

```
app/src/main/java/com/example/template/
├── MainActivity.kt          # Activity única + NavHost (rotas do app)
├── screen/
│   └── HomeScreen.kt        # a única tela; comece por aqui
└── ui/theme/
    ├── Color.kt             # paleta do app de quiz + cores das casas
    ├── Theme.kt             # MaterialTheme já usando essa paleta
    └── Type.kt              # tipografia
```

## Como evoluir a partir daqui

- **Nova tela:** crie o Composable em `screen/`, adicione a rota em
  `AppRoutes` e registre no `AppNavHost` (passo a passo comentado no
  `MainActivity.kt`).
- **Chamar uma API:** as dependências do Retrofit já estão no
  `app/build.gradle.kts`. Crie um `interface ApiService` com os endpoints e
  um objeto que monta o `Retrofit` (`baseUrl`, `GsonConverterFactory`).
- **Trocar `namespace`/`applicationId`:** em `app/build.gradle.kts` e o
  pacote `com.example.template`.

## Rodar pela linha de comando

```bash
./gradlew assembleDebug        # gera o APK de debug
./gradlew installDebug         # instala no dispositivo/emulador conectado
./gradlew test                 # testes unitários
```
# curso-android-template
