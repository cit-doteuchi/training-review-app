public class Main {
     public static void main(String[] args){
    //  System.out.println("環境設定OK"); 
    
    /* 
    ReviewManager reviewManager = new ReviewManager();
    reviewManager.ReviewItemAddDemo();
    reviewManager.showReviewItems(reviewManager.reviewItems);
    */

    showMenu();

    }



    private static void showMenu() {
    System.out.println("=== 研修復習ログアプリ ===");
    System.out.println();
    System.out.println("1. 復習項目を登録する");
    System.out.println("2. 復習項目を一覧表示する");
    System.out.println("3. 復習項目の詳細を表示する");
    System.out.println("4. 復習項目を編集する");
    System.out.println("5. 成果サマリーを表示する");
    System.out.println("0. 保存して終了する");
    System.out.println();
    System.out.print("番号を入力してください：");
    }
}