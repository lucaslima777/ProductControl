package lln.product.control.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lln.product.control.utils.TroppoType;

@Entity(tableName = "jelly")
public class JellyEntity {

    @PrimaryKey(autoGenerate = true)
    private int jellyId;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "type")
    private int type;

    @ColumnInfo(name = "quantity")
    private String quantity;

    @ColumnInfo(name = "price")
    private String price;

    public int getJellyId() {
        return jellyId;
    }

    public void setJellyId(int jellyId) {
        this.jellyId = jellyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
