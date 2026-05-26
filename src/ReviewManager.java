import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReviewManager {

    ArrayList<ReviewItem> reviewItems = new ArrayList<>();

    
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


    public ReviewItem findById(int id){
        for(ReviewItem item : reviewItems){
            if(item.getId() == id){
                return item;
            }
        }

        return null;
    }



    public boolean updateCategory(int id, String category){
        ReviewItem item = findById(id);

        if (item == null){
            return false;
        }

        item.setCategory(category);
        return true;
    }

    public boolean updateTitle(int id, String title){
        ReviewItem item = findById(id);

        if (item == null){
            return false;
        }

        item.setTitle(title);
        return true;
    }

    public boolean updateMemo(int id, String memo){
        ReviewItem item = findById(id);

        if (item == null){
            return false;
        }

        item.setMemo(memo);
        return true;
    }

    public boolean updateUnderstanding(int id, int understanding){
        ReviewItem item = findById(id);

        if (item == null){
            return false;
        }

        item.setUnderstanding(understanding);
        return true;
    }

    
    public boolean deleteReviewItem(int id) {
    ReviewItem item = findById(id);

    if (item == null) {
        return false;
    }

    reviewItems.remove(item);
    return true;
    }


}
