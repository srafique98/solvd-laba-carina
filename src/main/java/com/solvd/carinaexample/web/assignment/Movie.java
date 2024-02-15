package com.solvd.carinaexample.web.assignment;

public enum Movie {
    BARBIE("Barbie", "Release date: July 21, 2023", "Greta Gerwig", "https://search.yahoo.com/search?p=barbie+movie&fr=yfp-t&fr2=p%3Afp%2Cm%3Asb&ei=UTF-8&fp=1"),
    OPPENHEIMER("Oppenheimer", "Release date: July 21, 2023", "Christopher Nolan", "https://search.yahoo.com/search?p=oppenheimer+movie&fr=yfp-t&fr2=p%3Afp%2Cm%3Asb&ei=UTF-8&fp=1"),
    SOUND_OF_FREEDOM("Sound of Freedom", "Release date: July 4, 2023", "Alejandro Gómez Monteverde", "https://search.yahoo.com/search?p=sound+of+freedom+movie&fr=yfp-t&fr2=p%3Afp%2Cm%3Asb&ei=UTF-8&fp=1");

    private final String title;
    private final String releaseDate;
    private final String director;
    private final String url;

    Movie(String title, String date, String director, String url) {
        this.title = title;
        this.releaseDate = date;
        this.director = director;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public String getUrl() {
        return url;
    }
}
