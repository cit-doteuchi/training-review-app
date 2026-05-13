# 設計メモ

## クラス構成

本アプリでは、以下の4クラスを基本構成とする。

- Main
- ReviewItem
- ReviewManager
- ReviewCsvRepository

## 各クラスの役割

### Main

アプリの起動地点となるクラス。  
メニュー表示、ユーザー入力の受付、選択内容に応じた処理の呼び出しを担当する。

また、アプリ起動時にCSVからデータを読み込み、終了時にCSVへ保存する処理を呼び出す。

### ReviewItem

復習項目1件分の情報を保持するクラス。

保持する項目は以下の通り。

| 項目名 | 型 | 内容 |
|---|---|---|
| id | int | 復習項目を識別する番号 |
| date | LocalDate | 復習項目を登録した日 |
| category | String | Java、SQL、HTML/CSSなどの分類 |
| title | String | 復習項目のタイトル |
| memo | String | 復習内容のメモ |
| understanding | int | 理解度。1〜5で管理する |

### ReviewManager

複数のReviewItemをメモリ上で管理するクラス。

主な役割は以下の通り。

- 復習項目の追加
- 一覧取得
- ID検索
- 理解度更新
- 成果サマリー用の集計

### ReviewCsvRepository

ReviewItemの一覧をCSVファイルに保存・読み込みするクラス。

主な役割は以下の通り。

- CSVファイルからReviewItem一覧を読み込む
- ReviewItem一覧をCSVファイルに保存する
- CSVの1行をReviewItemに変換する
- ReviewItemをCSVの1行に変換する

## クラス同士の関係

Main は ReviewManager と ReviewCsvRepository を利用する。  
ReviewManager は ReviewItem の一覧を管理する。  
ReviewCsvRepository は ReviewItem の一覧と CSV ファイルの変換を担当する。

```text
Main
 ├─ ReviewManager
 │   └─ ReviewItem
 │
 └─ ReviewCsvRepository
     └─ data/review_items.csv


## メニュー構成

本アプリでは、以下のメニューを表示する。

```text
=== 研修復習ログアプリ ===

1. 復習項目を登録する
2. 復習項目を一覧表示する
3. 復習項目の詳細を表示する
4. 復習項目を編集する
5. 成果サマリーを表示する
0. 保存して終了する

番号を入力してください：