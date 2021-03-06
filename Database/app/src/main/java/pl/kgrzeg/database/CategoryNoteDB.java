package pl.kgrzeg.database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by course on 06/11/2017.
 */

public class CategoryNoteDB extends RealmObject {

    @PrimaryKey
    private long id;
    @Required
    private String title;
    private String color;


    public CategoryNoteDB() {
        this.id = MyApplication.CategoryID.incrementAndGet();
    }


    public CategoryNoteDB(String title, String color) {
        this.id = MyApplication.CategoryID.incrementAndGet();
        this.title = title;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
