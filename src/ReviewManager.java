import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReviewManager {

    ArrayList<ReviewItem> reviewItems = new ArrayList<>();

    public void ReviewItemAddDemo(){

        ReviewItem item1 = new ReviewItem(
            1, 
            LocalDate.now(),
            "java", 
            "aaa", 
            "memodesu", 
            1
        );

        ReviewItem item2 = new ReviewItem(
            2, 
            LocalDate.now(),
            "SQL", 
            "bbb", 
            "メモです", 
            5
        );

        ReviewItem item3 = new ReviewItem(
            3, 
            LocalDate.now(),
            "html", 
            "あああ", 
            "メモ", 
            3
        );
        
        reviewItems.add(item1);
        reviewItems.add(item2);
        reviewItems.add(item3);

    }
    
    public void addReviewItem(String category, String title, String memo, int understanding){
        ReviewItem item = new ReviewItem(
            getNextId(),
            LocalDate.now(),
            category,
            title,
            memo,
            understanding
        );

        reviewItems.add(item);
    }


    public void showReviewItems(){
        System.out.println();
        System.out.println("=== 復習項目 ===");
        System.out.println("登録件数: " + reviewItems.size() + "件");

        for(ReviewItem item : reviewItems){
            System.out.println(item.toString());
        }


    }

    public void addItem(ReviewItem item){
        reviewItems.add(item);
    }

    public int getNextId(){
        int maxId = 0;

        for(ReviewItem item : reviewItems){
            if(item.getId() > maxId){
                maxId = item.getId();
            }
        }

        return maxId + 1;
    }

    public List<ReviewItem> getAllItems(){
        return reviewItems;
    }

}
