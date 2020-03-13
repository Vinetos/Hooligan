package com.safexty.hooligan.network.objects.out;

import com.safexty.hooligan.network.objects.HooliganObject;
import flex.messaging.io.amf.ASObject;

/**
 * File <b>ResearchSynopticObject</b> located on com.safexty.hooligan.network.objects.out
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
 * Created the 04/11/2019 13:28
 * @version 0.0.1
 * @since 0.0.1
 *
 * <p>
 * Represent the sent packet to the server when asking for synoptic update
 */
public class ResearchSynopticObject extends HooliganObject {

    private boolean indicateurSousEtatHorsInter = true;
    private boolean indicateurCompteurSortiesEngin = false;
    private boolean indicateurEngins = true;
    private boolean indicateurRefreshArmabilite = false;
    private boolean indicateurTousLesPersonnels = false;
    private final int numeroCentre;
    private boolean indicateurMoyensEnIntervention = true;
    private boolean indicateurPersonnels = true;
    private boolean indicateurSpecialistes = false;
    private boolean indicateurStationnaire = false;
    private boolean indicateurActivites = false;
    private boolean indicateurEquipes = true;
    private boolean indicateurGestionValidite = false;


    public ResearchSynopticObject(int centerNumber) {
        super("com.systel.vo.services.RechercheSynoptiqueCentreRequest");
        this.numeroCentre = centerNumber;
    }

    public boolean isIndicateurSousEtatHorsInter() {
        return indicateurSousEtatHorsInter;
    }

    public void setIndicateurSousEtatHorsInter(boolean indicateurSousEtatHorsInter) {
        this.indicateurSousEtatHorsInter = indicateurSousEtatHorsInter;
    }

    public boolean isIndicateurCompteurSortiesEngin() {
        return indicateurCompteurSortiesEngin;
    }

    public void setIndicateurCompteurSortiesEngin(boolean indicateurCompteurSortiesEngin) {
        this.indicateurCompteurSortiesEngin = indicateurCompteurSortiesEngin;
    }

    public boolean isIndicateurEngins() {
        return indicateurEngins;
    }

    public void setIndicateurEngins(boolean indicateurEngins) {
        this.indicateurEngins = indicateurEngins;
    }

    public boolean isIndicateurRefreshArmabilite() {
        return indicateurRefreshArmabilite;
    }

    public void setIndicateurRefreshArmabilite(boolean indicateurRefreshArmabilite) {
        this.indicateurRefreshArmabilite = indicateurRefreshArmabilite;
    }

    public boolean isIndicateurTousLesPersonnels() {
        return indicateurTousLesPersonnels;
    }

    public void setIndicateurTousLesPersonnels(boolean indicateurTousLesPersonnels) {
        this.indicateurTousLesPersonnels = indicateurTousLesPersonnels;
    }

    public int getNumeroCentre() {
        return numeroCentre;
    }

    public boolean isIndicateurMoyensEnIntervention() {
        return indicateurMoyensEnIntervention;
    }

    public void setIndicateurMoyensEnIntervention(boolean indicateurMoyensEnIntervention) {
        this.indicateurMoyensEnIntervention = indicateurMoyensEnIntervention;
    }

    public boolean isIndicateurPersonnels() {
        return indicateurPersonnels;
    }

    public void setIndicateurPersonnels(boolean indicateurPersonnels) {
        this.indicateurPersonnels = indicateurPersonnels;
    }

    public boolean isIndicateurSpecialistes() {
        return indicateurSpecialistes;
    }

    public void setIndicateurSpecialistes(boolean indicateurSpecialistes) {
        this.indicateurSpecialistes = indicateurSpecialistes;
    }

    public boolean isIndicateurStationnaire() {
        return indicateurStationnaire;
    }

    public void setIndicateurStationnaire(boolean indicateurStationnaire) {
        this.indicateurStationnaire = indicateurStationnaire;
    }

    public boolean isIndicateurActivites() {
        return indicateurActivites;
    }

    public void setIndicateurActivites(boolean indicateurActivites) {
        this.indicateurActivites = indicateurActivites;
    }

    public boolean isIndicateurEquipes() {
        return indicateurEquipes;
    }

    public void setIndicateurEquipes(boolean indicateurEquipes) {
        this.indicateurEquipes = indicateurEquipes;
    }

    public boolean isIndicateurGestionValidite() {
        return indicateurGestionValidite;
    }

    public void setIndicateurGestionValidite(boolean indicateurGestionValidite) {
        this.indicateurGestionValidite = indicateurGestionValidite;
    }

    @Override
    public ASObject createObject() {
        ASObject aso = new ASObject() {{
            put("indicateurSousEtatHorsInter", isIndicateurSousEtatHorsInter());
            put("indicateurCompteurSortiesEngin", isIndicateurCompteurSortiesEngin());
            put("indicateurEngins", isIndicateurEngins());
            put("indicateurRefreshArmabilite", isIndicateurRefreshArmabilite());
            put("indicateurTousLesPersonnels", isIndicateurTousLesPersonnels());
            put("numeroCentre", getNumeroCentre());
            put("indicateurMoyensEnIntervention", isIndicateurMoyensEnIntervention());
            put("indicateurPersonnels", isIndicateurPersonnels());
            put("indicateurSpecialistes", isIndicateurSpecialistes());
            put("indicateurStationnaire", isIndicateurStationnaire());
            put("indicateurActivites", isIndicateurActivites());
            put("indicateurEquipes", isIndicateurEquipes());
            put("indicateurGestionValidite", isIndicateurGestionValidite());
        }};
        aso.setType(getType());
        return aso;
    }
}
