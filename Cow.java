public class Cow {
    private int cowID;
    private int farmID;
    
    public Cow(){}
    public Cow(int cowID, int farmID){
        this.cowID = cowID;
        this.farmID = farmID;
    }

    public int getID(){
        return cowID;
    }

    public int getFarmID(){
        return farmID;
    }
}
