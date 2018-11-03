package com.utilities;

import com.external.*;

public class Vector {
    public Vector() {

    }

    public String usedFor;

    public static int pointCount;
    {
        usedFor = usage();
    }

    public int spaces = f();

    private String usage(){
        System.out.println("usage is called");
        Side side = new Side();
        return "tablearc";
    }

    private int f() {
        System.out.println("f() called");
        return 12;
    }
}
