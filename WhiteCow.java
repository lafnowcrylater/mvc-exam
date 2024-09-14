public class WhiteCow extends Cow {
    private int year;
    private int month;
    
    public WhiteCow(int cowID, int farmID, int year, int month){
        super(cowID, farmID);
        this.year = year;
        this.month = month;
    }

    public String getDate(){
        return "m:" + month + " y:" + year; 
    }

    public int getYear(){
        return year;
    }

    public int getMonth(){
        return month;
    }

    public String toString() {
        return "WhiteCow [ID=" + getID() + ", FarmID=" + getFarmID() + ", BirthDate=" + getDate() + "]";
    }
}
