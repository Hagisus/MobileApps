package pl.kgrzeg.database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by course on 06/11/2017.
 */

public class NoteDB extends RealmObject {

    @PrimaryKey
    private long id;
    private String title;
    private String description;
    private long idCat;

    public NoteDB() {
        this.id = MyApplication.CategoryID.incrementAndGet();
    }

    public NoteDB(String title, String description, long idCat) {
        this.id = MyApplication.CategoryID.incrementAndGet();
        this.title = title;
        this.description = description;
        this.idCat = idCat;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getIdCat() {
        return idCat;
    }

    public void setIdCat(long idCat) {
        this.idCat = idCat;
    }
}
