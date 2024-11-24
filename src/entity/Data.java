package entity;

public class Data {
    private int dia;
    private int mes;

    public Data(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d", dia, mes);
    }
}
