public class Student {
    private String id;
    private String fullname;
    private double score;
    public String getId () {
        return this.id; 
    }
    public void setId (String id) {
         this.id = id;
    }
    public String getFullname () {  
        return this.fullname; 
    }
    public void setFullname (String fullname) {  
        this.fullname = fullname;
    }
    public double getScore () {
        return this.score; 
    }
    public void setScore (double score) {
       if (score < 0 || score > 10) {
        System.out.println("Invalid score, student score must be between 0 - 10");
       }
       this.score = score ;
    }
 
    public String getRank () {
        if (this.score < 5.0 ) {
            return "fail";
        } else if (this.score <= 6.5) {
            return "Medium";
        } else if (this.score <= 7.5) {
            return "Good";
        } else if (this.score <= 9.0) {
            return "Very Good";
        } else {
            return "Excellent";
        }
    }
}
