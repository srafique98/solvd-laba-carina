package com.solvd.carinaexample.web.horoscope;

public enum ZodiacSign {
    ARIES("Aries","MAR 21 - APR 19","https://www.yahoo.com/lifestyle/horoscope/aries"),
    TAURUS("Taurus", "APR 20 - MAY 20","https://www.yahoo.com/lifestyle/horoscope/taurus"),
    GEMINI("Gemini","MAY 21 - JUN 20" ,"https://www.yahoo.com/lifestyle/horoscope/gemini"),
    CANCER("Cancer","JUN 21 - JUL 22" ,"https://www.yahoo.com/lifestyle/horoscope/cancer"),
    LEO("Leo", "JUL 23 - AUG 22" ,"https://www.yahoo.com/lifestyle/horoscope/leo"),
    VIRGO("Virgo","AUG 23 - SEP 22" ,"https://www.yahoo.com/lifestyle/horoscope/virgo"),
    LIBRA("Libra","SEP 23 - OCT 22" ,"https://www.yahoo.com/lifestyle/horoscope/libra"),
    SCORPIO("Scorpio", "OCT 23 - NOV 21" ,"https://www.yahoo.com/lifestyle/horoscope/scorpio"),
    SAGITTARIUS("Sagittarius","NOV 22 - DEC 21","https://www.yahoo.com/lifestyle/horoscope/sagittarius"),
    CAPRICORN("Capricorn", "DEC 22 - JAN 19","https://www.yahoo.com/lifestyle/horoscope/capricorn"),
    AQUARIUS("Aquarius","JAN 20 - FEB 18","https://www.yahoo.com/lifestyle/horoscope/aquarius"),
    PISCES("Pisces", "FEB 19 - MAR 20" ,"https://www.yahoo.com/lifestyle/horoscope/pisces");

    private final String sign;
    private final String dateRange;
    private final String url;

    ZodiacSign(String sign, String dateRange, String url) {
        this.sign = sign;
        this.dateRange = dateRange;
        this.url = url;
    }

    public String getSign() {
        return sign;
    }

    public String getUrl() {
        return url;
    }

    public String getDateRange() {
        return dateRange;
    }
}
