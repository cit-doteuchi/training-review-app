public class Main {
     public static void main(String[] args){
    //  System.out.println("環境設定OK"); 

    ReviewManager reviewManager = new ReviewManager();
    
    reviewManager.ReviewItemAddDemo();
    reviewManager.showReviewItems(reviewManager.reviewItems);

    }
}