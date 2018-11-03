package com.external;

class Node {
    public String description;
    Node[] nextNodes() {
        return null;
    };
    Side side = new Side();
    public static Node self(){

        return new Node();
    }

    String getSideDesc(){
        return side.endDescription();
    }
}
