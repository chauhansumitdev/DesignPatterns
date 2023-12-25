// // Structural design patterns are concerned with how classes and objects are composed to form larger structures.
// //two interfaces which cannot understand each other -- provide someting like wrapper to help them communicate.
// The Adapter pattern involves a set of classes and interfaces:

// Target: This is the interface that the client code expects.

// Adapter: This is a class that implements the Target interface and wraps an instance of the Adaptee.

// Adaptee: This is the class that has the interface that needs to be adapted.

// Here's a simple explanation and example of the Adapter Pattern in Java:

// Adaptee
 class LegacySystem {
    public void legacyRequest() {
        System.out.println("Legacy System is processing the request");
    }
}

// Target
 interface NewSystem {
    void newRequest();
}

// Adapter
 class AdapterForLegacySystem implements NewSystem {
    private LegacySystem legacySystem;

    public AdapterForLegacySystem(LegacySystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    @Override
    public void newRequest() {
        legacySystem.legacyRequest();
    }
}

 class Client {
    public static void main(String[] args) {
        NewSystem newSystem = new AdapterForLegacySystem(new LegacySystem());
        newSystem.newRequest();
    }
}
