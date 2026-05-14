import java.time.LocalDate;

public class ReviewItem {
    private int id;
    private LocalDate date;
    private String category;
    private String title;
    private String memo;
    private int understanding;

    public ReviewItem (int id, LocalDate date, String category, String title, String memo, int understanding){
        this.id = id;
        this.date = date;
        this.category = category;
        this.title = title;
        this.memo = memo;
        this.understanding = understanding;
    }

    public int getId(){
        return id;
    }

    public LocalDate getDate(){
        return date;
    }

    public String getCategory(){
        return category;
    }

    public String getTitle(){
        return title;
    }

    public String getMemo(){
        return memo;
    }

    public int getUnderstanding(){
        return understanding;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setMemo(String memo){
        this.memo = memo;
    }

    public void setUnderstanding(int understanding){
        this.understanding = understanding;
    }

    @Override
    public String toString(){
        return "[" + id + "] " + date + "/" + category + "/" + title + "/ 理解度" + understanding; 
    }

}
