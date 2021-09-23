public class Persoon {
    private String voornaam;
    private String naam;
    private String geslacht;

    public Persoon(){

    }

    public Persoon(String voornaam, String naam, String geslacht) {
        this.voornaam = voornaam;
        this.naam = naam;
        this.geslacht = geslacht;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }
}
