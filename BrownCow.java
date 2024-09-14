public class BrownCow extends Cow{
    private int parentID;
    
    public BrownCow(int cowID, int farmID, int parentID){
        super(cowID, farmID);
        this.parentID = parentID;
    }

    public int getParentID(){
        return parentID;
    }

    public String toString() {
        return "BrownCow [ID=" + getID() + ", FarmID=" + getFarmID() + ", ParentID=" + parentID + "]";
    }
}
