package co.develhope.interceptorsmiddleware2.entities;

public class Month {

    private Integer monthNumber;
    private String englishName;
    private String italianName;
    private String germanName;

    public Month(Integer monthNumber, String englishName, String italianName, String germanName) {
        this.monthNumber = monthNumber;
        this.englishName = englishName;
        this.italianName = italianName;
        this.germanName = germanName;
    }

    public Integer getMonthNumber() {
        return monthNumber;
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getItalianName() {
        return italianName;
    }

    public String getGermanName() {
        return germanName;
    }

}