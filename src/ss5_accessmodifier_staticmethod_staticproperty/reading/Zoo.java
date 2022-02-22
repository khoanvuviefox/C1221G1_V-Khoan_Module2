package ss5_accessmodifier_staticmethod_staticproperty.reading;

public class Zoo {
    public String coolMethod () {
        return "Wow baby";
    }
}

class Moo extends Zoo {
    public void useMyCoolMethod () {
        System.out.println("Moo says, " + this.coolMethod());
        Zoo z = new Zoo ();
        System.out.println("A Zoo says, " + z.coolMethod());
    }
}
