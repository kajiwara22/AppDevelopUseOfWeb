# アプリの開発〜Webを活用して
このページは多摩大学プロジェクトゼミナールアプリの開発〜Webを活用しての解説・補足ページです。


#  授業解説資料

[04/07講義分](./01.md)  
[04/14講義分](./02.md)  
[04/21講義分](./03.md)  
[04/28講義分](./04.md)  
[05/12講義分](./05.md)  
[05/19講義分](./06.md)  
[05/26講義分](./07.md)  
[06/02講義分](./08.md)  
[06/09講義分](./09.md)  
[06/16講義分](./10.md)  
[06/23講義分](./11.md)  

# 最終課題提出に関して
[最終課題提出に関して](./FinalProjectSubmitted.md)  


## 最終課題向けTips
### ユーザー登録・ログイン等を実装してみたい。
SpringSecurityを用いることで実装できます。  
以下はSpringSecurityを適用したサンプルのコミットです。  
[SpringSecurityの適用を実施 · kajiwara22/AppDevelopUseOfWeb@dac95fe](https://github.com/kajiwara22/AppDevelopUseOfWeb/commit/dac95fe268bdaeb87a69aef3fe40c26ac18ecf96)

### Androidへのプッシュ通知を実装してみたい。
Amazon SNSの機能を用いた形でAndroidアプリ・Webアプリともに実装しました。  
[[AWS] Amazon SNS の新機能「Mobile Push」を Android で使ってみた ｜ Developers.IO](http://dev.classmethod.jp/smartphone/android/amazon-sns-mobile-push/)

Android アプリ  
[AppDevelopUseOfWeb/MobilePushAndRest at AndroidMobilePushSample · kajiwara22/AppDevelopUseOfWeb](https://github.com/kajiwara22/AppDevelopUseOfWeb/tree/AndroidMobilePushSample/MobilePushAndRest)  
動かす際には、AppDevelopUseOfWeb/MobilePushAndRest/app/src/main/res/values/strings.xml 内の  
project_number・server_addressを書き換えてビルドする必要があります。

Webアプリ  
[AppDevelopUseOfWeb/RecordWriterApplyMobilePush at AndroidMobilePushSample · kajiwara22/AppDevelopUseOfWeb](https://github.com/kajiwara22/AppDevelopUseOfWeb/tree/AndroidMobilePushSample/RecordWriterApplyMobilePush)  
AWSの鍵を設定しておく必要があります。  
AWS コマンドラインインターフェイスを導入後、aws configureを実行して  
AWS Access Key ID / AWS Secret Access Key を設定しておいてください。



# Mac環境での開発環境構築
[Mac環境での開発環境構築](./MacSoftwareInstall.md)  


# DBの文字化け対応
04/28の講義の際にDBへの書き込みで文字化けが発生しておりました。  
文字化けが発生しない設定ファイルの修正版をコミットしたので、そちらを参照ください。  
[DBへの文字化け対応](https://github.com/kajiwara22/AppDevelopUseOfWeb/commit/da4dbb179df8cd2d179a2df3363984e84abc9847)

## Q&Aサイト URL

[https://boiling-plateau-6509.herokuapp.com/](https://boiling-plateau-6509.herokuapp.com/)
