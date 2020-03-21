package com.safexty.hooligan;

import com.safexty.hooligan.firebase.NotificationManager;
import com.safexty.hooligan.utils.ConfigLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class User {

    public static final List<User> users = new ArrayList<>();

    private final String firstname;
    private final String lastname;
    private String dispoCode = "Vide";
    private boolean updated = false;

    public User(String firstname, String lastname, String dispoCode) {
        this.firstname = firstname;
        this.lastname = lastname;
        setDispoCode(dispoCode);
        users.add(this);
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDispoCode() {
        return dispoCode;
    }

    public void setDispoCode(String dispoCode) {
        setUpdated(true);
        if (this.dispoCode.equals(dispoCode) || !ConfigLoader.getConfig().sendNotification)
            return;
        var title = ConfigLoader.getConfig().notification.user.title
                .replaceAll("%nfirstName%", getFirstname())
                .replaceAll("%lastName%", getLastname())
                .replaceAll("%state%", getDispoCode())
                .replaceAll("%newState%", dispoCode);

        var content = ConfigLoader.getConfig().notification.user.body
                .replaceAll("%nfirstName%", getFirstname())
                .replaceAll("%lastName%", getLastname())
                .replaceAll("%state%", getDispoCode())
                .replaceAll("%newState%", dispoCode);

        NotificationManager.buildNotification(
                title,
                content
        );
        this.dispoCode = dispoCode;
    }

    public void update() {
        if (isUpdated())
            setUpdated(false);
        else
            setDispoCode("Vide");
    }

    public boolean isUpdated() {
        return updated;
    }

    public void setUpdated(boolean updated) {
        this.updated = updated;
    }

    public static Optional<User> findByName(String name, String firstName) {
        return users.stream().filter(u ->
                u.getLastname().toLowerCase().contains(name.toLowerCase()) &&
                        u.getFirstname().toLowerCase().contains(firstName.toLowerCase())
        ).findAny();
    }
}
