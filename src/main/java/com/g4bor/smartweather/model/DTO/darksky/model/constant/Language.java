package com.g4bor.smartweather.model.DTO.darksky.model.constant;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Represents the supported languages for the weather forecast
 */
public enum Language {
    AR("ar", "Arabic"),
    AZ("az", "Azerbaijani"),
    BE("be", "Belarusian"),
    BG("bg", "Bulgarian"),
    BN("bn", "Bengali"),
    BS("bs", "Bosnian"),
    CA("ca", "Catalan"),
    CS("cs", "Czech"),
    DA("da", "Danish"),
    DE("de", "German"),
    EL("el", "Greek"),
    EN("en", "English (which is the default)"),
    EO("eo", "Esperanto"),
    ES("es", "Spanish"),
    ET("et", "Estonian"),
    FI("fi", "Finnish"),
    FR("fr", "French"),
    HE("he", "Hebrew"),
    HI("hi", "Hindi"),
    HR("hr", "Croatian"),
    HU("hu", "Hungarian"),
    ID("id", "Indonesian"),
    IS("is", "Icelandic"),
    IT("it", "Italian"),
    JA("ja", "Japanese"),
    KA("ka", "Georgian"),
    KN("kn", "Kannada"),
    KO("ko", "Korean"),
    KW("kw", "Cornish"),
    LV("lv", "Latvian"),
    ML("ml", "Malayam"),
    MR("mr", "Marathi"),
    NB("nb", "Norwegian Bokmål"),
    NL("nl", "Dutch"),
    NO("no", "Norwegian Bokmål"),
    PA("pa", "Punjabi"),
    PL("pl", "Polish"),
    PT("pt", "Portuguese"),
    RO("ro", "Romanian"),
    RU("ru", "Russian"),
    SK("sk", "Slovak"),
    SL("sl", "Slovenian"),
    SR("sr", "Serbian"),
    SV("sv", "Swedish"),
    TA("ta", "Tamil"),
    TE("te", "Telugu"),
    TET("tet", "Tetum"),
    TR("tr", "Turkish"),
    UK("uk", "Ukrainian"),
    UR("ur", "Urdu"),
    X_PIG_LATIN("x-pig-latin", "Igpay Atinlay"),
    ZH("zh", "simplified Chinese"),
    ZH_TW("zh-tw", "traditional Chinese");

    private static Map<String, Language> languageMap;

    private String code;
    private String name;

    Language(String code, String name) {
        this.code = code;
        this.name = name;
    }

    static {
        languageMap = Arrays.stream(values()).collect(Collectors.toMap(Language::getCode   , c -> c));
    }

    public static Language resolve(String language) {
        return languageMap.getOrDefault(language, Language.EN);
    }

    public String getCode() {
        return code;
    }
}
