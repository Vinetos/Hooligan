package com.safexty.hooligan.network.objects.out;

import com.safexty.hooligan.network.objects.HooliganObject;
import flex.messaging.io.amf.ASObject;

/**
 * File <b>LoginObject</b> located on com.safexty.hooligan.network.objects.out
 * Hooligan is a part of SAFExTY Project.
 * <p>
 *   ____    _    _____ _____      _______   __       :::     ::: ::::::::::: ::::    ::: :::::::::: ::::::::::: ::::::::   ::::::::
 * / ___|  / \  |  ___| ____|_  _|_   _\ \ / /      :+:     :+:     :+:     :+:+:   :+: :+:            :+:    :+:    :+: :+:    :+:
 * \___ \ / _ \ | |_  |  _| \ \/ / | |  \ V /     +:+     +:+     +:+     :+:+:+  +:+ +:+            +:+    +:+    +:+ +:+
 *   ___) / ___ \|  _| | |___ >  <  | |   | |     +#+     +:+     +#+     +#+ +:+ +#+ +#++:++#       +#+    +#+    +:+ +#++:++#++
 * |____/_/   \_\_|   |_____/_/\_\ |_|   |_|     +#+   +#+      +#+     +#+  +#+#+# +#+            +#+    +#+    +#+        +#+
 *                                               #+#+#+#       #+#     #+#   #+#+# #+#            #+#    #+#    #+# #+#    #+#
 *                and                             ::::    ::::::::::: ::::   ::::  ::::::::::    :::    ::::::::::  ::::::::        .fr
 *
 * <p>
 * Copyright (c) 2019 SAFExTY.
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 * <p>
 *
 * @author Valentin Chassignol (Valentin), {@literal <contact@vinetos.fr>}, https://www.vinetos.fr
 * Created the 18/04/2019 13:28
 * @version 0.0.1
 * @since 0.0.1
 *
 * <p>
 * Represent the sent packet to the server to login
 */
public class LoginObject extends HooliganObject {

    private String ntlmToken = null;
    private final String user;
    private final String password;
    private String enginReleveur = null;
    private String source = null;
    private String ip = null;
    private int monNumeroCentre = 0;
    private String lesAnciensPersonnels = null;
    private String enginReleve = null;
    private String loginEmetteur = null;
    private String semaineEq = null;
    private String locale = null;
    private String matriculeEmetteur = null;
    private String tranche = null;
    private String intitule = null;

    public LoginObject(String user, String password) {
        super("com.systel.vo.services.InitialiseConnexionConsoleRequest");
        this.user = user;
        this.password = password;
    }

    public String getNtlmToken() {
        return ntlmToken;
    }

    public void setNtlmToken(String ntlmToken) {
        this.ntlmToken = ntlmToken;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getEnginReleveur() {
        return enginReleveur;
    }

    public void setEnginReleveur(String enginReleveur) {
        this.enginReleveur = enginReleveur;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getMonNumeroCentre() {
        return monNumeroCentre;
    }

    public void setMonNumeroCentre(int monNumeroCentre) {
        this.monNumeroCentre = monNumeroCentre;
    }

    public String getLesAnciensPersonnels() {
        return lesAnciensPersonnels;
    }

    public void setLesAnciensPersonnels(String lesAnciensPersonnels) {
        this.lesAnciensPersonnels = lesAnciensPersonnels;
    }

    public String getEnginReleve() {
        return enginReleve;
    }

    public void setEnginReleve(String enginReleve) {
        this.enginReleve = enginReleve;
    }

    public String getLoginEmetteur() {
        return loginEmetteur;
    }

    public void setLoginEmetteur(String loginEmetteur) {
        this.loginEmetteur = loginEmetteur;
    }

    public String getSemaineEq() {
        return semaineEq;
    }

    public void setSemaineEq(String semaineEq) {
        this.semaineEq = semaineEq;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getMatriculeEmetteur() {
        return matriculeEmetteur;
    }

    public void setMatriculeEmetteur(String matriculeEmetteur) {
        this.matriculeEmetteur = matriculeEmetteur;
    }

    public String getTranche() {
        return tranche;
    }

    public void setTranche(String tranche) {
        this.tranche = tranche;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    @Override
    public ASObject createObject() {
        ASObject aso = new ASObject() {{
            put("ntlmToken", getNtlmToken());
            put("user", getUser());
            put("password", getPassword());
            put("enginReleveur", getEnginReleveur());
            put("source", getSource());
            put("ip", getIp());
            put("monNumeroCentre", getMonNumeroCentre());
            put("lesAnciensPersonnels", getLesAnciensPersonnels());
            put("enginReleve", getEnginReleve());
            put("loginEmetteur", getLoginEmetteur());
            put("semaineEq", getSemaineEq());
            put("locale", getLocale());
            put("matriculeEmetteur", getMatriculeEmetteur());
            put("tranche", getTranche());
            put("intitule", getIntitule());
        }};
        aso.setType(getType());
        return aso;
    }
}
