// ラッキーアイテム

import java.util.*;

// ラッキーアイテムのメインクラス
public class LuckyItem {
    public static int luckyitem() {

        // ゲーム名の表示
        System.out.println("ラッキーアイテム");

        // 入力準備
        Scanner stdIn = new Scanner(System.in);

        // 色のリストを生成
        List<String> list = Arrays.asList("赤色", "青色", "黄色", "緑色", "紫色", "黒色", "白色", "桃色", "橙色", "茶色");

        // 初期値を0にする
        int retry = 0;

        // retryが1の時ループ処理をする
        // ユーザに入力してもらう
        do {
            System.out.print("明日身に付けるものは？：");
            String str = stdIn.next();

            // リストの中身を混ぜる
            Collections.shuffle(list);

            // 入力してもらった変数と混ぜたリストの一番目を表示する
            System.out.println("明日のラッキーアイテムは" + list.get(0) + "の" + str + "です。");

            // もう一度行うかどうかを確認
            do {
                System.out.print("もう一度やりますか？ (0)いいえ　(1)はい：");

                // 例外処理を行う
                try {
                    retry = stdIn.nextInt();

                } catch (InputMismatchException ex) {
                    System.out.println("0か1を入力して下さい。");
                } catch (NoSuchElementException ex) {
                    System.out.println("範囲内の数字を入力してください。");
                }

            } while (retry != 0 && retry != 1);

        } while (retry == 1);

        // retryが0の場合値を返却しメインクラスに返す
        return retry;
    }
}