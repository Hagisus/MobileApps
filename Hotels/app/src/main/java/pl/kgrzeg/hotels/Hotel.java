package pl.kgrzeg.hotels;

/**
 * Created by course on 03/11/2017.
 */

public class Hotel {
    private String name;
    private float rating;
    private int price;
    private int nightlyPrice;
    private String localOffer;
    private float distance;
    private String urlPhoto;

    public Hotel() {

    }

    public Hotel(String name, float rating, int price, int nightlyPrice, String localOffer, float distance, String urlPhoto) {
        this.name = name;
        this.rating = rating;
        this.price = price;
        this.nightlyPrice = nightlyPrice;
        this.localOffer = localOffer;
        this.distance = distance;
        this.urlPhoto = urlPhoto;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNightlyPrice() {
        return nightlyPrice;
    }

    public void setNightlyPrice(int nightlyPrice) {
        this.nightlyPrice = nightlyPrice;
    }

    public String getLocalOffer() {
        return localOffer;
    }

    public void setLocalOffer(String localOffer) {
        this.localOffer = localOffer;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }
}
