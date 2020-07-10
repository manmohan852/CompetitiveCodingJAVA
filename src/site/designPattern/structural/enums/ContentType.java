package site.designPattern.structural.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ContentType {
    TVSHOW("TVSHOW", "TVSHOW", true), SEASON("SEASON"), EPISODE("EPISODE"), VIDEO("VIDEO", "VIDEO", true), OTHER("OTHER", "VIDEO", true), MOVIE("MOVIE", "MOVIE", true), SHORTMOVIE("SHORTMOVIE"),
    HUAWEI("HUAWEI"), LIVE("LIVE"), CATCHUP("CATCHUP"), SPORTS("SPORTS", "VIDEO", true), UNKNOWN(""), LIVETVCHANNEL("LIVETVCHANNEL", "LIVETVCHANNEL", true), PROGRAM("PROGRAM"),
    LIVETVSHOW("LIVETVSHOW", "TVSHOW", true), LIVETVMOVIE("LIVETVMOVIE", "MOVIE", true), APPS("APPS"), SONG("song"), ARTIST("artist"), ALBUM("album"), PLAYLIST("playlist"),
    PACKAGE("package"), CATEGORYCONTENT("categorycontent"), NEWS("NEWS");

    public final String name;
    public String superType; //search result category

    public boolean searchEnabled;

    ContentType(String name) {
        this.name = name;
    }

    ContentType(String name, String superType, boolean searchEnabled) {
        this.name = name;
        this.searchEnabled = searchEnabled;
        this.superType = superType;
    }

    public static ContentType getType(String type) {
        if (type == null) {
            return UNKNOWN;
        }
        for (ContentType ct : ContentType.values()) {
            if (ct.name.equalsIgnoreCase(type)) {
                return ct;
            }
        }
        return UNKNOWN;
    }

    public String getSuperType() {
        return !superType.isEmpty() ? superType : VIDEO.superType;
    }

    public static List<String> searchEnabledSuperTypes() {
        return Arrays.stream(ContentType.values()).filter(type -> type.searchEnabled).map(type -> type.superType).collect(Collectors.toList());
    }

    public static List<String> searchEnabledTypes() {
        return Arrays.stream(ContentType.values()).filter(type -> type.searchEnabled).map(type -> type.name()).collect(Collectors.toList());
    }
}
