package com.example.demo.pojo;

import java.util.Date;

public class All_sensorData {
    private float temperature;
    private double humidity;
    private double bloodOxygen;
    private float lightLntensity;
    private double heartRate;
    private Date time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getBloodOxygen() {
        return bloodOxygen;
    }

    public void setBloodOxygen(double bloodOxygen) {
        this.bloodOxygen = bloodOxygen;
    }

    public float getLightLntensity() {
        return lightLntensity;
    }

    public void setLightLntensity(float lightLntensity) {
        this.lightLntensity = lightLntensity;
    }

    public double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(double heartRate) {
        this.heartRate = heartRate;
    }
}
