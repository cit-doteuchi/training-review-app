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
                    inputEditReviewItem(sc,reviewManager);
                    break;
                case "5": //成果サマリー表示
                
                    break;
                case "6":
                    inputDeleteReviewItem(sc, reviewManager);
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
        System.out.println("6. 復習項目を削除する");
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


    private static void inputEditReviewItem(Scanner sc, ReviewManager reviewManager){
        System.out.println();
        System.out.println("=== 復習項目編集 ===");

        System.out.print("編集するIDを入力してください");
        String idInput = sc.nextLine();

        try {
        int id = Integer.parseInt(idInput);

        ReviewItem item = reviewManager.findById(id);

        if (item == null) {
            System.out.println("指定されたIDの復習項目は見つかりませんでした。");
            return;
        }

        System.out.println("編集する項目を選んでください。");
        System.out.println("1. カテゴリ");
        System.out.println("2. タイトル");
        System.out.println("3. メモ");
        System.out.println("4. 理解度");
        System.out.println("0. 戻る");
        System.out.print("番号を入力してください：");

        String choice = sc.nextLine();
        boolean updated = false;

        switch (choice) {
            case "1":
                System.out.print("新しいカテゴリを入力してください：");
                String category = sc.nextLine();
                updated = reviewManager.updateCategory(id, category);
                break;

            case "2":
                System.out.print("新しいタイトルを入力してください：");
                String title = sc.nextLine();
                updated = reviewManager.updateTitle(id, title);
                break;

            case "3":
                System.out.print("新しいメモを入力してください：");
                String memo = sc.nextLine();
                updated = reviewManager.updateMemo(id, memo);
                break;

            case "4":
                int understanding = inputUnderstanding(sc);
                updated = reviewManager.updateUnderstanding(id, understanding);
                break;

            case "0":
                System.out.println("編集をキャンセルしました。");
                return;

            default:
                System.out.println("正しい番号を入力してください。");
                return;
        }

        if (updated) {
            System.out.println("復習項目を編集しました。");
        } else {
            System.out.println("復習項目を編集できませんでした。");
        }

        } catch (NumberFormatException e) {
            System.out.println("IDは数字で入力してください。");
        }
        
    }

    

    private static void inputDeleteReviewItem(Scanner sc, ReviewManager reviewManager){
        System.out.println();
        System.out.println("=== 復習項目削除 ===");

        System.out.print("削除するIDを入力してください：");
        String idInput = sc.nextLine();

        try {
            int id = Integer.parseInt(idInput);

            ReviewItem item = reviewManager.findById(id);

            if (item == null) {
                System.out.println("指定されたIDの復習項目は見つかりませんでした。");
                return;
            }

            System.out.println("以下の項目を削除します。");
            System.out.println(item.toString());
            System.out.print("本当に削除しますか？ y/n：");

            String confirm = sc.nextLine();

            if (!confirm.equalsIgnoreCase("y")) {
                System.out.println("削除をキャンセルしました。");
                return;
            }

            boolean deleted = reviewManager.deleteReviewItem(id);

            if (deleted) {
                System.out.println("復習項目を削除しました。");
            } else {
                System.out.println("復習項目を削除できませんでした。");
            }

        } catch (NumberFormatException e) {
            System.out.println("IDは数字で入力してください。");
        }
    }


}