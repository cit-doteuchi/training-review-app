import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReviewManager {

    ArrayList<ReviewItem> reviewItems = new ArrayList<>();

    // public void reviewItemAddDemo(){

    //     ReviewItem item1 = new ReviewItem(
    //         1, 
    //         LocalDate.now(),
    //         "java", 
    //         "aaa", 
    //         "memodesu", 
    //         1
    //     );

    //     ReviewItem item2 = new ReviewItem(
    //         2, 
    //         LocalDate.now(),
    //         "SQL", 
    //         "bbb", 
    //         "メモです", 
    //         5
    //     );

    //     ReviewItem item3 = new ReviewItem(
    //         3, 
    //         LocalDate.now(),
    //         "html", 
    //         "あああ", 
    //         "メモ", 
    //         3
    //     );
        
    //     reviewItems.add(item1);
    //     reviewItems.add(item2);
    //     reviewItems.add(item3);

    // }
    
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



    public void showReviewItems(){
        System.out.println();
        System.out.println("=== 復習項目 ===");
        System.out.println("登録件数: " + reviewItems.size() + "件");

        for(ReviewItem item : reviewItems){
            System.out.println(item.toString());
        }


    }

    

    public void showReviewItemDetail(Scanner sc, ReviewManager reviewManager){
        System.out.println();
        System.out.println("=== 復習項目詳細 ===");

        System.out.print("詳細を表示するIDを入力してください：");
        String input =  sc.nextLine();

        try{
            int id = Integer.parseInt(input);
            ReviewItem item = reviewManager.findById(id);

            if(item == null){
                System.out.println("指定されたIDの復習項目は見つかりませんでした。");
                return;
            }

            System.out.println("ID: " + item.getId());
            System.out.println("日付: " + item.getDate());
            System.out.println("カテゴリ: " + item.getCategory());
            System.out.println("タイトル: " + item.getTitle());
            System.out.println("メモ: " + item.getMemo());
            System.out.println("理解度: " + item.getUnderstanding());

        } catch (NumberFormatException e){
            System.out.println("IDは数字で入力してください");
        }
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



}
