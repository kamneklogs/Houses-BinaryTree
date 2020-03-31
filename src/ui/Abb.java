package ui;

import model.*;

public class Abb {

    public static void main(String[] args) {
        Neighborhood myN = new Neighborhood();

        myN.addHouse("h", 218);
        myN.addHouse("d", 21768);
        myN.addHouse("a", 218);
        myN.addHouse("b", 999);
        myN.addHouse("h", 218);
        myN.addHouse("z", 238768);
        myN.addHouse("j", 218);

        House s = myN.search("z");

        System.out.println(s.getArea());

    }

}