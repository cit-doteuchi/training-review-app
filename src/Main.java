import java.util.Scanner;

public class Main {
     public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //  System.out.println("環境設定OK"); 
    
        
        ReviewManager reviewManager = new ReviewManager();
        reviewManager.addReviewItem("Java", "サンプル", "メモ" , 1);
        reviewManager.addReviewItem("html", "例", "めも" , 4);
        
        while (true) {
            showMenu();

            String input = sc.nextLine();
            System.out.println("入力された番号: " + input);
        

            switch (input) {
                case "1": //登録
                    inputReviewItem(sc, reviewManager);
                    break;
                case "2": //一覧表示
                    reviewManager.showReviewItems();
                    break;
                case "3": //詳細表示
                    reviewManager.showReviewItemDetail(sc, reviewManager);
                    break;
                case "4": //編集
                
                    break;
                case "5": //成果サマリー表示
                
                    break;
                case "0": //保存して終了
                    sc.close();
                    return;
                default:
                    System.out.println("正しい番号を入力してください");
                    break;
            } 
        }
        
            
        
    }



    private static void showMenu() {
        System.out.println();
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


    private static void inputReviewItem(Scanner sc, ReviewManager reviewManager){
        System.out.println();
        System.out.println("=== 復習項目登録 ===");

        System.out.print("カテゴリを入力してください：");
        String category = sc.nextLine();

        System.out.print("タイトルを入力してください：");
        String title = sc.nextLine();

        System.out.print("メモを入力してください：");
        String memo = sc.nextLine();

        int understanding = inputUnderstanding(sc);

        reviewManager.addReviewItem(category, title, memo, understanding);

        System.out.println("復習項目を登録しました");


    }


    private static int inputUnderstanding(Scanner sc){
        while (true){
            System.out.print("理解度を1から5で入力してください：");
            String input = sc.nextLine();

            try {
                
                int understanding = Integer.parseInt(input);

                if(understanding >= 1 && understanding <= 5){
                    return understanding;
                }


            } catch (NumberFormatException e) {
                System.out.println("数字を入力してください");
            }

        }
    }

}