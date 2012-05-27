
■プロジェクト開始前に、雛形をダウンロードした後実行すること

・プロジェクト名をリファクタリング
・rootパッケージの決定
　WEB-INF/web.xmlのパラメータ定義「slim3.rootPackage」を決定したパッケージに変更
　src、test配下のパッケージを変更
・共通例外を定義
　jp.coxs.twitter.favrt.exception配下のXXXXXAppException.javaをリファクタリング
・必要に応じてjp.coxs.twitter.favrt.filter配下のファイルを実装
　AuthFilter.java
　FootprintsFilter.java
・自分が取得したTwitterアプリケーションの固有値を定義
　jp.coxs.twitter.favrt.util.TwitterServiceProvider
　に
　consumer key
　consumer secret
　callback url
　を定義する
・FactoryPathを設定
プロジェクト上で右クリック → Properties → Java Compiler → 
    Annotation Processing → Factory Path
・Twitterに登録するコールバックURL
　http://[ドメイン]/[コンテキストパス]/auth
・GoogleAnalytics
　/slim3-template/war/_template/_analytics_forMob.jsp
　に取得したIDを記述する
・jp.coxs.twitter.favrt.util.TwitterServiceProviderに
　Twitterで取得したアプリ固有のIDを設定する
　#getConsumerKey()
　#getConsumerSecret()

