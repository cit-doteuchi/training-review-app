import java.util.Scanner;

public class Main {
     public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //  System.out.println("環境設定OK"); 
    
        
        ReviewManager reviewManager = new ReviewManager();
        reviewManager.ReviewItemAddDemo();
        
        

        showMenu();

        String input = sc.nextLine();
        System.out.println("入力された番号: " + input);
        

        switch (input) {
            case "1": //登録
                
                break;
            case "2": //一覧表示
                reviewManager.showReviewItems(reviewManager.reviewItems);
                break;
            case "3": //詳細表示
                
                break;
            case "4": //編集
                
                break;
            case "5": //成果サマリー表示
                
                break;
            case "0": //保存して終了
                
                break;
            default:
                break;
        } 
            
        sc.close();
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