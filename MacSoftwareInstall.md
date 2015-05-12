Homebrew 導入
・APP StoreよりXcodeを導入します。
・一度Xcodeを立ち上げ、規約に同意をします。
・ターミナルで以下のコマンドを入力します。
ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
・インストールが完了すれば以下のように入力した際に、バージョンが表示されます。
brew -v

JDK8のインストール。
brew install caskroom/cask/brew-cask
brew tap caskroom/versions
brew cask search java
brew cask install java
パスワードの入力が求められると思うので、Macに設定しているパスワードを入力
Terminalでjava -versionを入力実行。java version "1.8.0_11"のように表示されることを確認して下さい

Node.js
brew install node

MySQL
brew install mysql

MySQL Workbench 6.2.4
以下のサイトよりダウンロード＆インストール
http://dev.mysql.com/downloads/workbench/

SourceTree
以下のサイトよりダウンロード&インストール
https://www.atlassian.com/ja/software/sourcetree/overview

MacではEclipseは以下を使います。
SPRING TOOL SUITE ダウンロード・インストール(mac)
https://spring.io/tools/sts

Lombok
Githubに記載してある方法と同一です。
インストールしたパスのみ、上記のSPRING TOOL SUITEのパスで読みかえてください。
https://github.com/kajiwara22/AppDevelopUseOfWeb/blob/master/02.md


参考サイト：

MacでJava８対応のEclipseWEB開発環境を整えるまで - Qiita http://qiita.com/vicugna/items/99ed473751cfb808e860