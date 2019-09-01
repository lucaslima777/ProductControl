package lln.product.control.utils;

import lln.product.control.R;

public enum TroppoType {

    JELLY_BLUE(R.drawable.ic_jam_blue),
    JELLY_GREEN(R.drawable.ic_jam_green),
    JELLY_GREY(R.drawable.ic_jam_grey),
    JELLY_ORANGE(R.drawable.ic_jam_orange),
    JELLY_PINK(R.drawable.ic_jam_pink),
    JELLY_PURPLE(R.drawable.ic_jam_purple),
    JELLY_RED(R.drawable.ic_jam_red),
    JELLY_YELLOW(R.drawable.ic_jam_yellow),
    JELLY_AMBER(R.drawable.ic_jam_amber),
    JELLY_BROWN(R.drawable.ic_jam_brown);

    private int jellyDrawable;

    TroppoType(int jellyDrawable) {
        this.jellyDrawable = jellyDrawable;
    }

    public int getJellyDrawable() {
        return jellyDrawable;
    }

    public void setJellyDrawable(int jellyDrawable) {
        this.jellyDrawable = jellyDrawable;
    }
}
