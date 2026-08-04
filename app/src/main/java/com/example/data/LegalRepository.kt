package com.example.data

import com.example.model.LegalDocType
import com.example.model.LegalDocument
import com.example.model.LegalSection

object LegalRepository {

    val privacyPolicy = LegalDocument(
        type = LegalDocType.PRIVACY_POLICY,
        lastUpdatedEn = "January 15, 2026",
        lastUpdatedAr = "١٥ يناير ٢٠٢٦",
        summaryEn = "Learn how Pikone protects your privacy and handles your data.",
        summaryAr = "تعرّف على كيفية حماية Pikone لخصوصيتك ومعالجة بياناتك.",
        sections = listOf(
            LegalSection(
                number = "1",
                titleEn = "Introduction & Scope",
                titleAr = "المقدمة ونطاق التطبيق",
                contentEn = "Welcome to Pikone Photo Editor (\"Pikone\", \"we\", \"us\", or \"our\"). We are committed to safeguarding the privacy and personal data of our global users. This Privacy Policy outlines how we collect, process, store, and protect your information when you access or use the Pikone mobile application, website, and related digital editing tools.",
                contentAr = "مرحبًا بك في محرّر الصور Pikone (\"Pikone\" أو \"نحن\"). نحن نلتزم بحماية خصوصية وبيانات أمان مستخدمينا عالميًا. توضح سياسة الخصوصية هذه كيفية جمع معلوماتك ومعالجتها وتخزينها وحمايتها عند استخدام تطبيق Pikone والموقع الإلكتروني وأدوات التحرير الرقمية ذات الصلة."
            ),
            LegalSection(
                number = "2",
                titleEn = "Image Processing & On-Device Security",
                titleAr = "معالجة الصور والأمان على الجهاز",
                contentEn = "Pikone prioritizes local, on-device image processing. Photos, graphics, and visual media edited within Pikone remain on your local device memory by default. When cloud-based AI editing features (such as neural style transfer or background synthesis) are engaged, visual assets are transmitted securely via encrypted TLS 1.3 channels to isolated processing nodes and purged immediately upon completion.",
                contentAr = "تولي Pikone الأولوية للمعالجة المحلية للصور على جهازك. تظل الصور والرسومات والوسائط المرئية المحررة في ذاكرة جهازك المحلية بشكل افتراضي. عند استخدام ميزات التحرير بالذكاء الاصطناعي السحابية، يتم نقل الصور بأمان عبر قنوات TLS 1.3 المشفرة إلى عقد معالجة معزولة ويتم مسحها فور انتهاء التحرير."
            ),
            LegalSection(
                number = "3",
                titleEn = "Information We Collect",
                titleAr = "المعلومات التي نجمعها",
                contentEn = "We collect limited diagnostic and non-identifying telemetry information to ensure high performance and application stability:\n• App Performance Telemetry: Crash logs, render frame rates, and latency metrics.\n• Device Specifications: OS version, GPU capabilities, and screen resolution.\n• Preference Data: Saved edit presets, UI language choice, and export default preferences.\nWe do NOT sell, lease, or trade your personal photos or biometric data to third parties.",
                contentAr = "نجمع بيانات تشخيصية محدودة وغير معرفة لشخصك لضمان أعلى مستوى من الأداء والاستقرار:\n• بيانات أداء التطبيق: سجلات الأعطال، معدل الإطارات، ومقاييس زمن الاستجابة.\n• مواصفات الجهاز: إصدار نظام التشغيل، قدرات وحدة معالجة الرسومات GPU، ودقة الشاشة.\n• بيانات التفضيلات: الإعدادات المسبقة المحفوظة، لغة الواجهة، وتفضيلات التصدير الافتراضية.\nنحن لا نبيع أو نؤجر أو نتاجر بصورك الشخصية أو بياناتك البيومترية لأي أطراف خارجية."
            ),
            LegalSection(
                number = "4",
                titleEn = "Data Retention & User Controls",
                titleAr = "الاحتفاظ بالبيانات وعناصر تحكم المستخدم",
                contentEn = "You retain full ownership and control over your visual content. Pikone provides accessible settings allowing users to clear temporary rendering caches, reset app preferences, or opt out of anonymous analytics telemetry at any time. Permanent exports are stored exclusively in your local device photo library.",
                contentAr = "تحتفظ بالملكية الكاملة والتحكم التام في محتواك البصري. يوفر تطبيق Pikone إعدادات سهلة تتيح للمستخدمين مسح الذاكرة المؤقتة، وإعادة ضبط تفضيلات التطبيق، أو إلغاء الاشتراك في التحليلات المجهولة في أي وقت. يتم حفظ التصديرات الدائمة حصريًا في مكتبة الصور المحلية بجهازك."
            ),
            LegalSection(
                number = "5",
                titleEn = "International Compliance & Contact",
                titleAr = "الامتثال الدولي ووسائل التواصل",
                contentEn = "Pikone complies with global privacy regulations including GDPR, CCPA, and regional data protection frameworks. For privacy inquiries, data requests, or policy clarifications, contact our Data Protection Office at privacy@pikone.app.",
                contentAr = "يمتثل Pikone للوائح الخصوصية العالمية بما في ذلك GDPR و CCPA وأطر حماية البيانات الإقليمية. للاستفسارات المتعلقة بالخصوصية أو طلبات البيانات، تواصل مع مكتب حماية البيانات عبر privacy@pikone.app."
            )
        )
    )

    val termsOfUse = LegalDocument(
        type = LegalDocType.TERMS_OF_USE,
        lastUpdatedEn = "January 15, 2026",
        lastUpdatedAr = "١٥ يناير ٢٠٢٦",
        summaryEn = "Read the terms and conditions for using Pikone.",
        summaryAr = "اقرأ الشروط والأحكام الخاصة باستعمال تطبيق Pikone.",
        sections = listOf(
            LegalSection(
                number = "1",
                titleEn = "Acceptance of Terms",
                titleAr = "القبول بالشروط",
                contentEn = "By downloading, installing, or accessing Pikone Photo Editor, you agree to be bound by these Terms of Use and all applicable laws and regulations. If you do not agree with any part of these terms, you must cease using the application immediately.",
                contentAr = "بتحميل أو تثبيت أو استخدام تطبيق Pikone Photo Editor، فإنك توافق على الالتزام بشروط الاستخدام هذه وجميع القوانين واللوائح المعمول بها. إذا كنت لا توافق على أي جزء من هذه الشروط، فيجب عليك التوقف عن استخدام التطبيق فورًا."
            ),
            LegalSection(
                number = "2",
                titleEn = "Intellectual Property & Content Rights",
                titleAr = "الملكية الفكرية وحقوق المحتوى",
                contentEn = "All original graphics, filter algorithms, UI designs, trademarks, and code powering Pikone are the exclusive property of Pikone Inc. However, you maintain 100% intellectual property rights and ownership over all original photographs and digital art created or edited through our tools.",
                contentAr = "جميع الرسومات الأصلية وخوارزميات الفلاتر والتصاميم والعلامات التجارية وشفرات البرمجة في Pikone هي ملكية حصرية لشركة Pikone Inc. ومع ذلك، فإنك تحتفظ بـ 100٪ من حقوق الملكية الفكرية والملكية الكاملة لجميع الصور والأعمال الفنية الرقمية التي تنشئها أو تعدلها باستخدام أدواتنا."
            ),
            LegalSection(
                number = "3",
                titleEn = "Permitted & Acceptable Use",
                titleAr = "الاستخدام المسموح والمقبول",
                contentEn = "You agree to use Pikone solely for lawful creative purposes. You shall not:\n• Reverse engineer, decompile, or extract proprietary editing shader pipelines.\n• Process or generate unlawful, non-consensual, or malicious media content.\n• Attempt to breach or bypass security parameters of Pikone servers or APIs.",
                contentAr = "توافق على استخدام Pikone فقط لأغراض إبداعية مشروعة. لا يجوز لك:\n• الهندسة العكسية أو تفكيك أو استخراج خوارزميات التظليل والتحرير المملوكة للتطبيق.\n• معالجة أو إنشاء محتوى غير قانوني أو غير مصرح به أو ضار.\n• محاولة اختراق أو تجاوز معايير أمان خوادم أو واجهات برمجية Pikone."
            ),
            LegalSection(
                number = "4",
                titleEn = "Disclaimer of Warranties",
                titleAr = "إخلاء المسؤولية عن الضمانات",
                contentEn = "Pikone Photo Editor is provided on an 'AS IS' and 'AS AVAILABLE' basis without warranties of any kind, whether express or implied. We do not guarantee uninterrupted or error-free processing during hardware acceleration or high-resolution render exports.",
                contentAr = "يتم تقديم Pikone Photo Editor على أساس 'كما هو' و'كما هو متاح' دون أي ضمانات من أي نوع، سواء كانت صريحة أو ضمنية. نحن لا نضمن معالجة خالية من الانقطاع أو الأخطاء أثناء التسريع العتادي أو تصدير الصور عالية الدقة."
            ),
            LegalSection(
                number = "5",
                titleEn = "Governing Law & Amendments",
                titleAr = "القانون الساري والتعديلات",
                contentEn = "These terms are governed by international software licensing standards. Pikone reserves the right to update or modify these terms at any time. Continued usage of the application following published revisions constitutes acceptance of the modified Terms of Use.",
                contentAr = "تخضع هذه الشروط لمعايير ترخيص البرمجيات الدولية. يحتفظ Pikone بالحق في تحديث أو تعديل هذه الشروط في أي وقت. يعتبر استمرار استخدام التطبيق بعد نشر التعديلات قبولاً لشروط الاستخدام المعدلة."
            )
        )
    )

    fun getDocument(type: LegalDocType): LegalDocument {
        return when (type) {
            LegalDocType.PRIVACY_POLICY -> privacyPolicy
            LegalDocType.TERMS_OF_USE -> termsOfUse
        }
    }
}
