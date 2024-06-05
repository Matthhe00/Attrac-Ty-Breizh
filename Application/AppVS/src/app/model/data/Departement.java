package app.model.data;

import java.util.ArrayList;

public class Departement {
    
    private String idDep;

    private String nomDep;

    private String invesCulturel2019;

    private AeroportFileAccess aeroportFileAccess;

    private ArrayList<Aeroport> listeAeroports;

    public Departement(String idDep, String nomDep, String inves) {
        this.idDep = idDep;
        this.nomDep = nomDep;
        this.invesCulturel2019 = inves;
        this.listeAeroports = new ArrayList<Aeroport>();
        this.aeroportFileAccess = new AeroportFileAccess();
        initAeroports();
    }

    public void initAeroports(){
        this.listeAeroports = aeroportFileAccess.getAeroports(this.idDep);
    }

    public String getIdDep() {
        return this.idDep;
    }

    public void setIdDep(String idDep) {
        this.idDep = idDep;
    }

    public String getNomDep() {
        return this.nomDep;
    }

    public void setNomDep(String nomDep) {
        this.nomDep = nomDep;
    }

    public String getInvesCulturel2019() {
        return this.invesCulturel2019;
    }

    public void setInvesCulturel2019(String invesCulturel2019) {
        this.invesCulturel2019 = invesCulturel2019;
    }

    public ArrayList<Aeroport> getListeAeroports() {
        return this.listeAeroports;
    }

    public void setListeAeroports(ArrayList<Aeroport> listeAeroports) {
        this.listeAeroports = listeAeroports;
    }

    public void addAeroport(Aeroport aeroport) {
        if(aeroport != null){
            this.listeAeroports.add(aeroport);
        }
    }

    public void removeAeroport(Aeroport aeroport){
            this.listeAeroports.remove(aeroport);
    }

    public String toString() {
        return "Departement [idDep=" + idDep + ", nomDep=" + nomDep + ", invesCulturel2019=" + invesCulturel2019 + "]";
    }
}
