package com.external;

public class Side {
    Node[] getEnds(){
        return new Node[] { new Node(), new Node() };
    }

    protected String endDescription(){
        Node[] ends = getEnds();
        return ends[0].description + " " + ends[1].description;
    }
}
