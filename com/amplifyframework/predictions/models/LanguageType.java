package com.amplifyframework.predictions.models;

import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;

/* loaded from: classes.dex */
public enum LanguageType {
    AFRIKAANS("af"),
    ALBANIAN("sq"),
    AMHARIC("am"),
    ARABIC("ar"),
    ARMENIAN("hy"),
    ASSAMESE("as"),
    AZERBAIJANI("az"),
    BASHKIR("ba"),
    BASQUE("eu"),
    BELARUSIAN("be"),
    BENGALI("bn"),
    BOSNIAN("bs"),
    BULGARIAN("bg"),
    BURMESE("my"),
    CATALAN("ca"),
    CEBUANO("ceb"),
    CENTRAL_KHMER("km"),
    CHINESE_SIMPLIFIED("zh"),
    CHINESE_TRADITIONAL("zh-TW"),
    CHUVASH("cv"),
    CROATIAN("hr"),
    CZECH("cs"),
    DANISH("da"),
    DARI("fa-AF"),
    DUTCH("nl"),
    ENGLISH("en"),
    ESPERANTO("eo"),
    ESTONIAN("et"),
    FINNISH("fi"),
    FRENCH("fr"),
    FRENCH_CANADIAN("fr-CA"),
    GALICIAN("gl"),
    GEORGIAN("ka"),
    GERMAN("de"),
    GREEK("el"),
    GUJARATI("gu"),
    HAITIAN("ht"),
    HAUSA("ha"),
    HEBREW("he"),
    HINDI("hi"),
    HUNGARIAN("hu"),
    ICELANDIC("is"),
    ILOKO("ilo"),
    INDONESIAN(ConfigurationItem.COLUMN_NAME_ID),
    IRISH("ga"),
    ITALIAN("it"),
    JAPANESE("ja"),
    JAVANESE("jv"),
    KANNADA("kn"),
    KAZAKH("kk"),
    KIRGHIZ("ky"),
    KOREAN("ko"),
    KURDISH("ku"),
    LATIN("la"),
    LATVIAN("lv"),
    LITHUANIAN("lt"),
    LUXEMBOURGISH("lb"),
    MACEDONIAN("mk"),
    MALAGASY("mg"),
    MALAY("ms"),
    MALAYALAM("ml"),
    MARATHI("mr"),
    MONGOLIAN("mn"),
    NEPALI("ne"),
    NEWARI("new"),
    NORWEGIAN("no"),
    ORIYA("or"),
    PASHTO("ps"),
    PERSIAN("fa"),
    POLISH("pl"),
    PORTUGUESE("pt"),
    PUNJABI("pa"),
    PUSHTO("ps"),
    QUECHUA("qu"),
    ROMANIAN("ro"),
    RUSSIAN("ru"),
    SANSKRIT("sa"),
    SCOTTISH_GAELIC("gd"),
    SERBIAN("sr"),
    SINDHI("sd"),
    SINHALA("si"),
    SLOVAK("sk"),
    SLOVENIAN("sl"),
    SOMALI("so"),
    SPANISH("es"),
    SUNDANESE("su"),
    SWAHILI("sw"),
    SWEDISH("sv"),
    TAGALOG("tl"),
    TAJIK("tg"),
    TAMIL("ta"),
    TATAR("tt"),
    TELUGU("te"),
    THAI("th"),
    TURKISH("tr"),
    TURKMEN("tk"),
    UIGHUR("ug"),
    UKRAINIAN("uk"),
    URDU("ur"),
    UZBEK("uz"),
    VIETNAMESE("vi"),
    WELSH("cy"),
    YIDDISH("yi"),
    YORUBA("yo"),
    UNKNOWN("unknown");

    private final String languageCode;

    LanguageType(String str) {
        this.languageCode = str;
    }

    public static LanguageType from(String str) {
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case 3148:
                if (str.equals("bn")) {
                    c = 0;
                    break;
                }
                break;
            case 3241:
                if (str.equals("en")) {
                    c = 1;
                    break;
                }
                break;
            case 3246:
                if (str.equals("es")) {
                    c = 2;
                    break;
                }
                break;
            case 3329:
                if (str.equals("hi")) {
                    c = 3;
                    break;
                }
                break;
            case 3383:
                if (str.equals("ja")) {
                    c = 4;
                    break;
                }
                break;
            case 3493:
                if (str.equals("mr")) {
                    c = 5;
                    break;
                }
                break;
            case 3569:
                if (str.equals("pa")) {
                    c = 6;
                    break;
                }
                break;
            case 3588:
                if (str.equals("pt")) {
                    c = 7;
                    break;
                }
                break;
            case 3651:
                if (str.equals("ru")) {
                    c = '\b';
                    break;
                }
                break;
            case 3886:
                if (str.equals("zh")) {
                    c = '\t';
                    break;
                }
                break;
            case 115813762:
                if (str.equals("zh-TW")) {
                    c = '\n';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return BENGALI;
            case 1:
                return ENGLISH;
            case 2:
                return SPANISH;
            case 3:
                return HINDI;
            case 4:
                return JAPANESE;
            case 5:
                return MARATHI;
            case 6:
                return PUNJABI;
            case 7:
                return PORTUGUESE;
            case '\b':
                return RUSSIAN;
            case '\t':
                return CHINESE_SIMPLIFIED;
            case '\n':
                return CHINESE_TRADITIONAL;
            default:
                for (LanguageType languageType : values()) {
                    if (languageType.getLanguageCode().equals(str)) {
                        return languageType;
                    }
                }
                return UNKNOWN;
        }
    }

    public String getLanguageCode() {
        return this.languageCode;
    }
}
