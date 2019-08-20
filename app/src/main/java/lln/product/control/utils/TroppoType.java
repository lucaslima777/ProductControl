package lln.product.control.utils;

public enum TroppoType {

    JELLY_1("framboesa"),
    JELLY_2("morango"),
    JELLY_3("banana"),
    JELLY_4("limao"),
    JELLY_5("manga"),
    JELLY_6("uva");

    private String jellyName;

    TroppoType(String jellyName) {
        this.jellyName = jellyName;
    }
}
