import java.time.LocalDate;
import java.util.ArrayList;

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
            1, 
            LocalDate.now(),
            "SQL", 
            "bbb", 
            "メモです", 
            5
        );

        ReviewItem item3 = new ReviewItem(
            1, 
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
    
    public void showReviewItems(ArrayList<ReviewItem> reviewItems){
        System.out.println("=== 復習項目 ===");
        System.out.println("登録件数: " + reviewItems.size() + "件");

        for(ReviewItem item : reviewItems){
            System.out.println(item.toString());
        }


    }



}
