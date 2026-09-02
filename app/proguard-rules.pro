# Regras de ProGuard/R8 específicas do projeto.
# https://developer.android.com/studio/build/shrink-code

# Mantém as classes de modelo usadas pelo Gson (desserialização por reflexão).
-keep class com.example.template.model.** { *; }
