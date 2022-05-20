package com.weather.forecast.model;

import javax.persistence.*;

@Table(name = "weather")
@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_weather")
    private long idWeather;
    @Column(name = "id")
    private long id;
    @Column(name = "humidity")
    private int humidity;
    @Column(name = "pressure")
    private float pressure;
    @Column(name = "st")
    private float st;
    @Column(name = "description")
    private String description;
    @Column(name = "temp")
    private float temp;
    @Column(name = "temp_desc")
    private String tempDesc;
    @Column(name = "visibility")
    private int visibility;
    @Column(name = "wind_speed")
    private int wind_speed;
    @Column(name = "wing_deg")
    private String wing_deg;

    public long getId() {
        return id;
    }

    public long getIdWeather() {
        return idWeather;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getSt() {
        return st;
    }

    public void setSt(float st) {
        this.st = st;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public String getTempDesc() {
        return tempDesc;
    }

    public void setTempDesc(String tempDesc) {
        this.tempDesc = tempDesc;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public int getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(int wind_speed) {
        this.wind_speed = wind_speed;
    }

    public String getWing_deg() {
        return wing_deg;
    }

    public void setWing_deg(String wing_deg) {
        this.wing_deg = wing_deg;
    }

}
