# ソフトウェア導入(Mac編)
Mac環境で開発環境を構築する手順をまとめておきます。

## Homebrew
### これはなに？
ChocolateyのMac版な位置づけのソフトウェアになります。  
これを用いて様々な必要なソフトウェアを導入します。

### 導入手順
1. APP StoreよりXcodeを導入します。
1. 一度Xcodeを立ち上げ、規約に同意をします。
1. ターミナルで以下のコマンドを入力します。

    ```
    ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
    ```
    
1. インストールが完了すれば以下のように入力した際に、バージョンが表示されます。  

    ```
    brew -v
    ```


## JDK8の導入
1. 以下のコマンドを実行

    ```
        brew install caskroom/cask/brew-cask  
    ```
    
    ```
        brew tap caskroom/versions  
    ```
    
    ```
        brew cask search java  
    ```
    
    ```
        brew cask install java  
    ```
    
1. パスワードの入力が求められると思うので、Macに設定しているパスワードを入力
1. Terminalでjava -versionを入力実行。java version "1.8.0_11"のように表示されることを確認して下さい

## Node.js
1. 以下のコマンドを実行

    ```
    brew install node
    ```
    
## MySQL
1. 以下のコマンドを実行

    ```
    brew install mysql
    ```

## MySQL Workbench
1. 以下のサイトよりダウンロード＆インストール  
[MySQL :: Download MySQL Workbench](http://dev.mysql.com/downloads/workbench/)

## SourceTree
1. 以下のサイトよりダウンロード＆インストール  
[Git、Mercurial 対応 無料 DVCS Mac、Windowsクライアント | Atlassian](https://www.atlassian.com/ja/software/sourcetree/overview)

## Eclipse
1. MacではEclipseは以下を使います。以下のサイトよりダウンロード＆インストール  
[Spring Tool Suite™ (STS)](https://spring.io/tools/sts)


## Lombok
Githubに記載してある方法と同一です。  
インストールしたパスのみ、上記のSPRING TOOL SUITEのパスで読みかえてください。


参考サイト：
[MacでJava８対応のEclipseWEB開発環境を整えるまで - Qiita](http://qiita.com/vicugna/items/99ed473751cfb808e860)
