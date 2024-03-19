package Materi;

import java.util.Scanner;

public abstract class BangunRuang {
    protected String name;

    public BangunRuang(String name) {
        this.name = name;
    }

    public abstract void inputNilai();

    public abstract void luasPermukaan();

    public abstract void volume();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}