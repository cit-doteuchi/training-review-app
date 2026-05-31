import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReviewManager {

    private ArrayList<ReviewItem> reviewItems = new ArrayList<>();
    private int maxId = 0;
    
    public void addReviewItem( String category, String title, String memo, int understanding){
        int id = issueNextId();

        ReviewItem item = new ReviewItem(
            id,
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

        if (item.getId() > maxId) {
            maxId = item.getId();
        }

    }


    private int issueNextId() {
        maxId++;
        return maxId;
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

    public int getTotalCount() {
        return reviewItems.size();
    }


    public Map<String, Integer> getCategoryCounts() {
        Map<String, Integer> categoryCounts = new LinkedHashMap<>();

        for (ReviewItem item : reviewItems) {
            String category = item.getCategory();

            categoryCounts.put(
                category,
                categoryCounts.getOrDefault(category, 0) + 1
            );
        }

        return categoryCounts;
    }

    public Map<Integer, Integer> getUnderstandingCounts(){
        Map<Integer,Integer> understandingCounts = new LinkedHashMap<>();

        for(int i = 1; i <= 5 ; i++){
            understandingCounts.put(i, 0);
        }

        for(ReviewItem item : reviewItems){
            Integer understanding = item.getUnderstanding();

            understandingCounts.put(
                understanding,
                understandingCounts.get(understanding) + 1
            );

        }

        return understandingCounts;
    }


}
