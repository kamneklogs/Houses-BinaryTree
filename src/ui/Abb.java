package ui;

import model.*;

public class Abb {

    public static void main(String[] args) {
        Neighborhood myN = new Neighborhood();

        myN.addHouse("h", 223418);
        myN.addHouse("d", 2551768);
        myN.addHouse("a", 2181221);
        myN.addHouse("b", 999);
        myN.addHouse("i", 1121548);
        myN.addHouse("z", 334358768);
        myN.addHouse("j", 22645418);
        myN.addHouse("f", 2112);
        myN.addHouse("e", 21832);
        myN.addHouse("g", 218234);

        House s = myN.search("g");

        System.out.println(s.getArea());

        myN.remove("d");

        s = myN.search("d");
        System.out.println(s);

    }

}