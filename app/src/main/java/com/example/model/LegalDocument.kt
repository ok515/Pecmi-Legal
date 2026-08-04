package com.example.model

enum class LegalDocType(val id: String, val titleEn: String, val titleAr: String, val icon: String) {
    PRIVACY_POLICY(
        id = "privacy",
        titleEn = "Privacy Policy",
        titleAr = "سياسة الخصوصية",
        icon = "🔒"
    ),
    TERMS_OF_USE(
        id = "terms",
        titleEn = "Terms of Use",
        titleAr = "شروط الاستخدام",
        icon = "📜"
    )
}

enum class Language(val code: String, val displayName: String) {
    ENGLISH("en", "English"),
    ARABIC("ar", "العربية")
}

data class LegalSection(
    val number: String,
    val titleEn: String,
    val titleAr: String,
    val contentEn: String,
    val contentAr: String
)

data class LegalDocument(
    val type: LegalDocType,
    val lastUpdatedEn: String,
    val lastUpdatedAr: String,
    val summaryEn: String,
    val summaryAr: String,
    val sections: List<LegalSection>
)
