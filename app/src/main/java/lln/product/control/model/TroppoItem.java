package lln.product.control.model;

import lln.product.control.utils.TroppoType;

public class TroppoItem {

    private final String title;
    private final int image;
    private final TroppoType jelly;

    public TroppoItem(String title, int image, TroppoType jelly) {
        this.title = title;
        this.image = image;
        this.jelly = jelly;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }

    public TroppoType getJelly() {
        return jelly;
    }
}
