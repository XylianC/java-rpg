package main;

import domain.DomainController;
import cui.rpgApplication;

public class Main {
    public static void main(String[] args) {
        DomainController dc = new DomainController();
        rpgApplication app = new rpgApplication(dc);
    }
}