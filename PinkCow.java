public class PinkCow extends Cow{
    private String[] ownerName;
    
    public PinkCow(int cowID, int farmID, String name, String lastName){
        super(cowID, farmID);
        ownerName = new String[2];
        ownerName[0] = name;
        ownerName[1] = lastName;
    }

    public String getOwnerFullName(){
        return ownerName[0] + " " + ownerName[1];
    }

    public String getOwnerName(){
        return ownerName[0];
    }

    public String getOwnerLastName(){
        return ownerName[1];
    }

    public String toString() {
        return "PinkCow [ID=" + getID() + ", FarmID=" + getFarmID() + ", Owner=" + getOwnerFullName() + "]";
    }
}
