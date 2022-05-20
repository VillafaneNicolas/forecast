package com.weather.forecast.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Table(name = "location" )
@Entity
public class Location {

    @Id
    @Column(name = "_id")
    @JsonProperty("_id")
    private String id;

    @Column(name = "dist")
    private float dist;

    @Column(name = "lid")
    private long lid;

    @Column(name = "fid")
    private long fid;

    @Column(name = "int_number")
    @JsonProperty("int_number")
    private int intNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "province")
    private String province;

    @Column(name = "lat")
    private double lat;

    @Column(name = "lon")
    private double lon;

    @Column(name = "zoom")
    private String zoom;

    @Column(name = "updated")
    private long updated;

    @Column(name = "forecast")
    private String forecast;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_weather",referencedColumnName = "idWeather")
    private Weather weather;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public float getDist() {
        return dist;
    }

    public void setDist(float dist) {
        this.dist = dist;
    }

    public long getLid() {
        return lid;
    }

    public void setLid(long lid) {
        this.lid = lid;
    }

    public long getFid() {
        return fid;
    }

    public void setFid(long fid) {
        this.fid = fid;
    }

    public int getIntNumber() {
        return intNumber;
    }

    public void setIntNumber(int int_number) {
        this.intNumber = int_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }



    public String getZoom() {
        return zoom;
    }

    public void setZoom(String zoom) {
        this.zoom = zoom;
    }

    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", dist=" + dist +
                ", lid=" + lid +
                ", fid=" + fid +
                ", intNumber=" + intNumber +
                ", name='" + name + '\'' +
                ", province='" + province + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", zoom='" + zoom + '\'' +
                ", updated=" + updated +
                ", forecast='" + forecast + '\'' +
                ", Weather{" +
                "id=" + id +
                ", humidity=" + weather.getHumidity() +
                ", pressure=" + weather.getPressure() +
                ", st=" + weather.getSt() +
                ", description='" + weather.getDescription() + '\'' +
                ", temp=" + weather.getTemp() +
                ", tempDesc='" + weather.getTempDesc() + '\'' +
                ", visibility=" + weather.getVisibility() +
                ", wind_speed=" + weather.getWind_speed() +
                ", wing_deg='" + weather.getWing_deg() + '\'' +
                ')'+'}';
    }
}
