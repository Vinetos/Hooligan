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
public class ResearchMembersObject extends HooliganObject {

    private boolean indicateurRechercheGroupe = false;
    private boolean multiVecteurDeclenchement = false;
    private int numeroCentre = 202;
    private int critereGroupe = 0;
    private boolean indicateurInfosRecepteurs = false;
    private boolean indicateurFonctionsOccupees = false;
    private boolean indicateurGradeParCentre = false;
    private boolean indicateurdhAckBip = false;
    private boolean indicateurHeureRealisees = false;
    private boolean indicateurAnnuaireOpeTel = false;
    private boolean indicateurRechercheCompetences = false;
    private String matricule = null;
    private int critereEtatPlanning = 0;
    private boolean indicateurOrdreFOP = false;
    private String critereFonctionOccupee = null;
    private boolean indicateurRecherchePersonnels = false;
    private boolean indicateurListCentres = false;
    private boolean indicateurInfosMinimales = false;
    private boolean indicateurFonctionUtilisables = false;
    private boolean indicateurRechercheEtatPlanning = false;
    private boolean indicateurRechercheParNumeroCentre = false;
    private boolean indicateurIndisponibleDeGarde = false;
    private boolean indicateurSousetat = false;
    private boolean indicateurQualifications = false;
    private boolean indicateurEtatPlanning = false;
    private boolean indicateurRechercheFonctionsOccupees = false;
    private boolean indicateurGroupeSanguin = false;
    private String critereCompetence = null;
    private boolean indicateurPersonnelTempsTravail = false;
    private String critereListeEtatPlanning = null;
    private boolean indicateurSpecialisteEngage = false;


    public ResearchMembersObject(int numeroCentre) {
        super("com.systel.vo.services.RecherchePersonnelsRequest");
        this.numeroCentre = numeroCentre;
    }

    public boolean isIndicateurRechercheGroupe() {
        return indicateurRechercheGroupe;
    }

    public void setIndicateurRechercheGroupe(boolean indicateurRechercheGroupe) {
        this.indicateurRechercheGroupe = indicateurRechercheGroupe;
    }

    public boolean isMultiVecteurDeclenchement() {
        return multiVecteurDeclenchement;
    }

    public void setMultiVecteurDeclenchement(boolean multiVecteurDeclenchement) {
        this.multiVecteurDeclenchement = multiVecteurDeclenchement;
    }

    public int getNumeroCentre() {
        return numeroCentre;
    }

    public void setNumeroCentre(int numeroCentre) {
        this.numeroCentre = numeroCentre;
    }

    public int getCritereGroupe() {
        return critereGroupe;
    }

    public void setCritereGroupe(int critereGroupe) {
        this.critereGroupe = critereGroupe;
    }

    public boolean isIndicateurInfosRecepteurs() {
        return indicateurInfosRecepteurs;
    }

    public void setIndicateurInfosRecepteurs(boolean indicateurInfosRecepteurs) {
        this.indicateurInfosRecepteurs = indicateurInfosRecepteurs;
    }

    public boolean isIndicateurFonctionsOccupees() {
        return indicateurFonctionsOccupees;
    }

    public void setIndicateurFonctionsOccupees(boolean indicateurFonctionsOccupees) {
        this.indicateurFonctionsOccupees = indicateurFonctionsOccupees;
    }

    public boolean isIndicateurGradeParCentre() {
        return indicateurGradeParCentre;
    }

    public void setIndicateurGradeParCentre(boolean indicateurGradeParCentre) {
        this.indicateurGradeParCentre = indicateurGradeParCentre;
    }

    public boolean isIndicateurdhAckBip() {
        return indicateurdhAckBip;
    }

    public void setIndicateurdhAckBip(boolean indicateurdhAckBip) {
        this.indicateurdhAckBip = indicateurdhAckBip;
    }

    public boolean isIndicateurHeureRealisees() {
        return indicateurHeureRealisees;
    }

    public void setIndicateurHeureRealisees(boolean indicateurHeureRealisees) {
        this.indicateurHeureRealisees = indicateurHeureRealisees;
    }

    public boolean isIndicateurAnnuaireOpeTel() {
        return indicateurAnnuaireOpeTel;
    }

    public void setIndicateurAnnuaireOpeTel(boolean indicateurAnnuaireOpeTel) {
        this.indicateurAnnuaireOpeTel = indicateurAnnuaireOpeTel;
    }

    public boolean isIndicateurRechercheCompetences() {
        return indicateurRechercheCompetences;
    }

    public void setIndicateurRechercheCompetences(boolean indicateurRechercheCompetences) {
        this.indicateurRechercheCompetences = indicateurRechercheCompetences;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public int getCritereEtatPlanning() {
        return critereEtatPlanning;
    }

    public void setCritereEtatPlanning(int critereEtatPlanning) {
        this.critereEtatPlanning = critereEtatPlanning;
    }

    public boolean isIndicateurOrdreFOP() {
        return indicateurOrdreFOP;
    }

    public void setIndicateurOrdreFOP(boolean indicateurOrdreFOP) {
        this.indicateurOrdreFOP = indicateurOrdreFOP;
    }

    public String getCritereFonctionOccupee() {
        return critereFonctionOccupee;
    }

    public void setCritereFonctionOccupee(String critereFonctionOccupee) {
        this.critereFonctionOccupee = critereFonctionOccupee;
    }

    public boolean isIndicateurRecherchePersonnels() {
        return indicateurRecherchePersonnels;
    }

    public void setIndicateurRecherchePersonnels(boolean indicateurRecherchePersonnels) {
        this.indicateurRecherchePersonnels = indicateurRecherchePersonnels;
    }

    public boolean isIndicateurListCentres() {
        return indicateurListCentres;
    }

    public void setIndicateurListCentres(boolean indicateurListCentres) {
        this.indicateurListCentres = indicateurListCentres;
    }

    public boolean isIndicateurInfosMinimales() {
        return indicateurInfosMinimales;
    }

    public void setIndicateurInfosMinimales(boolean indicateurInfosMinimales) {
        this.indicateurInfosMinimales = indicateurInfosMinimales;
    }

    public boolean isIndicateurFonctionUtilisables() {
        return indicateurFonctionUtilisables;
    }

    public void setIndicateurFonctionUtilisables(boolean indicateurFonctionUtilisables) {
        this.indicateurFonctionUtilisables = indicateurFonctionUtilisables;
    }

    public boolean isIndicateurRechercheEtatPlanning() {
        return indicateurRechercheEtatPlanning;
    }

    public void setIndicateurRechercheEtatPlanning(boolean indicateurRechercheEtatPlanning) {
        this.indicateurRechercheEtatPlanning = indicateurRechercheEtatPlanning;
    }

    public boolean isIndicateurRechercheParNumeroCentre() {
        return indicateurRechercheParNumeroCentre;
    }

    public void setIndicateurRechercheParNumeroCentre(boolean indicateurRechercheParNumeroCentre) {
        this.indicateurRechercheParNumeroCentre = indicateurRechercheParNumeroCentre;
    }

    public boolean isIndicateurIndisponibleDeGarde() {
        return indicateurIndisponibleDeGarde;
    }

    public void setIndicateurIndisponibleDeGarde(boolean indicateurIndisponibleDeGarde) {
        this.indicateurIndisponibleDeGarde = indicateurIndisponibleDeGarde;
    }

    public boolean isIndicateurSousetat() {
        return indicateurSousetat;
    }

    public void setIndicateurSousetat(boolean indicateurSousetat) {
        this.indicateurSousetat = indicateurSousetat;
    }

    public boolean isIndicateurQualifications() {
        return indicateurQualifications;
    }

    public void setIndicateurQualifications(boolean indicateurQualifications) {
        this.indicateurQualifications = indicateurQualifications;
    }

    public boolean isIndicateurEtatPlanning() {
        return indicateurEtatPlanning;
    }

    public void setIndicateurEtatPlanning(boolean indicateurEtatPlanning) {
        this.indicateurEtatPlanning = indicateurEtatPlanning;
    }

    public boolean isIndicateurRechercheFonctionsOccupees() {
        return indicateurRechercheFonctionsOccupees;
    }

    public void setIndicateurRechercheFonctionsOccupees(boolean indicateurRechercheFonctionsOccupees) {
        this.indicateurRechercheFonctionsOccupees = indicateurRechercheFonctionsOccupees;
    }

    public boolean isIndicateurGroupeSanguin() {
        return indicateurGroupeSanguin;
    }

    public void setIndicateurGroupeSanguin(boolean indicateurGroupeSanguin) {
        this.indicateurGroupeSanguin = indicateurGroupeSanguin;
    }

    public String getCritereCompetence() {
        return critereCompetence;
    }

    public void setCritereCompetence(String critereCompetence) {
        this.critereCompetence = critereCompetence;
    }

    public boolean isIndicateurPersonnelTempsTravail() {
        return indicateurPersonnelTempsTravail;
    }

    public void setIndicateurPersonnelTempsTravail(boolean indicateurPersonnelTempsTravail) {
        this.indicateurPersonnelTempsTravail = indicateurPersonnelTempsTravail;
    }

    public String getCritereListeEtatPlanning() {
        return critereListeEtatPlanning;
    }

    public void setCritereListeEtatPlanning(String critereListeEtatPlanning) {
        this.critereListeEtatPlanning = critereListeEtatPlanning;
    }

    public boolean isIndicateurSpecialisteEngage() {
        return indicateurSpecialisteEngage;
    }

    public void setIndicateurSpecialisteEngage(boolean indicateurSpecialisteEngage) {
        this.indicateurSpecialisteEngage = indicateurSpecialisteEngage;
    }

    @Override
    public ASObject createObject() {
        ASObject aso = new ASObject() {{
            put("indicateurRechercheGroupe", isIndicateurRechercheGroupe());
            put("multiVecteurDeclenchement", isMultiVecteurDeclenchement());
            put("numeroCentre", getNumeroCentre());
            put("critereGroupe", getCritereGroupe());
            put("indicateurInfosRecepteurs", isIndicateurInfosRecepteurs());
            put("indicateurFonctionsOccupees", isIndicateurFonctionsOccupees());
            put("indicateurGradeParCentre", isIndicateurGradeParCentre());
            put("indicateurdhAckBip", isIndicateurdhAckBip());
            put("indicateurHeureRealisees", isIndicateurHeureRealisees());
            put("indicateurAnnuaireOpeTel", isIndicateurAnnuaireOpeTel());
            put("indicateurRechercheCompetences", isIndicateurRechercheCompetences());
            put("matricule", getMatricule());
            put("critereEtatPlanning", getCritereEtatPlanning());
            put("indicateurOrdreFOP", isIndicateurOrdreFOP());
            put("critereFonctionOccupee", getCritereFonctionOccupee());
            put("indicateurRecherchePersonnels", isIndicateurRecherchePersonnels());
            put("indicateurListCentres", isIndicateurListCentres());
            put("indicateurInfosMinimales", isIndicateurInfosMinimales());
            put("indicateurFonctionUtilisables", isIndicateurFonctionUtilisables());
            put("indicateurRechercheEtatPlanning", isIndicateurRechercheEtatPlanning());
            put("indicateurRechercheParNumeroCentre", isIndicateurRechercheParNumeroCentre());
            put("indicateurIndisponibleDeGarde", isIndicateurIndisponibleDeGarde());
            put("indicateurSousetat", isIndicateurSousetat());
            put("indicateurQualifications", isIndicateurQualifications());
            put("indicateurEtatPlanning", isIndicateurEtatPlanning());
            put("indicateurRechercheFonctionsOccupees", isIndicateurRechercheFonctionsOccupees());
            put("indicateurGroupeSanguin", isIndicateurGroupeSanguin());
            put("critereCompetence", getCritereCompetence());
            put("indicateurPersonnelTempsTravail", isIndicateurPersonnelTempsTravail());
            put("critereListeEtatPlanning", getCritereListeEtatPlanning());
            put("indicateurSpecialisteEngage", isIndicateurSpecialisteEngage());
        }};
        aso.setType(getType());
        return aso;
    }
}
