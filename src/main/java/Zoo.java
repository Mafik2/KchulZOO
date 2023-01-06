public class Zoo {
    private String osetrovatel;
    private int zvirata;
    private String zvire;

    public Zoo(String osetrovatel, int zvirata, String zvire) {
        this.osetrovatel = osetrovatel;
        this.zvirata = zvirata;
        this.zvire = zvire;
    }

    public String getOsetrovatel() {
        return osetrovatel;
    }

    public void setOsetrovatel(String osetrovatel) {
        this.osetrovatel = osetrovatel;
    }

    public int getZvirata() {
        return zvirata;
    }

    public void setZvirata(int zvirata) {
        this.zvirata = zvirata;
    }

    public String getZvire() {
        return zvire;
    }
}
