package com.safexty.hooligan;

import com.safexty.hooligan.firebase.NotificationManager;
import com.safexty.hooligan.utils.ConfigLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlertedTruck {

    public static List<AlertedTruck> alertedTrucks = new ArrayList<>();

    private final String name;
    private final String fonction;
    private String etat = "Vide";
    private boolean updated = false;

    public AlertedTruck(String name, String fonction, String etat) {
        this.name = name;
        this.fonction = fonction;
        setEtat(etat);
        alertedTrucks.add(this);
    }

    public String getName() {
        return name;
    }

    public String getFonction() {
        return fonction;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        setUpdated(true);
        if (this.etat.equals(etat) || !ConfigLoader.getConfig().sendNotification)
            return;
        var title = ConfigLoader.getConfig().notification.truck.title
                .replaceAll("%state%", getEtat())
                .replaceAll("%newState%", etat)
                .replaceAll("%functionName%", getFonction())
                .replaceAll("%truckName%", getName());

        var content = ConfigLoader.getConfig().notification.truck.body
                .replaceAll("%state%", getEtat())
                .replaceAll("%newState%", etat)
                .replaceAll("%functionName%", getFonction())
                .replaceAll("%truckName%", getName());

        NotificationManager.buildNotification(
                title,
                content
        );
        this.etat = etat;
    }

    public void update() {
        if (isUpdated())
            setUpdated(false);
        else
            setEtat("Vide");
    }

    public boolean isUpdated() {
        return updated;
    }

    public void setUpdated(boolean updated) {
        this.updated = updated;
    }

    public static Optional<AlertedTruck> findByName(String name) {
        return alertedTrucks.stream().filter(t -> t.getName().toLowerCase().contains(name.toLowerCase())).findAny();
    }
}
