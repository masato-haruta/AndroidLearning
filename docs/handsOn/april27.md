■第一回まとめ    

0. 下記からAndroidStudio2.3.1をDLしておく
https://developer.android.com/studio/index.html

1. AndroidStudioで新規プロジェクトを作成する(MinSDKはDecolog同様19、EmptyActivityを選択)

2. プロジェクト作成後gitの設定をする    
    git init で初期化    
    .gitignoreを置くhttps://github.com/328w/DecologAndroid/blob/develop/.gitignore    
    git-flow init で初期化    

3. Android用のコマンドのパスを通す    
    ~/.bash_profile に以下を追記(/build-tools/25.0.xは落としてきたバージョンによって変わります)    
    which aapt, which adb でパスが表示されればOK    
    export PATH=$PATH:$HOME/Library/Android/sdk/platform-tools:$HOME/Library/Android/sdk/build-tools/25.0.x    

4. アプリをビルドしてみる    
    AndroidStudioでビルドボタンタップ又は[ctrl + r]    
    エミュレータの生成と設定(対象端末はマシュマロ APILevel23 OS6)    
    エミュレータができあがったらHello worldが表示される    
    ブレークポイントをMainActivity.javaのsuper.onCreate(savedInstanceState)に貼ってデバッグビルド(ビルドボタンの2つ右のボタンタップ又は[ctrl + d])
    ステップ実行を確認すること    
    レイアウトファイルactivity_main.xmlのHello World!文言を変更してみる(ファイルを探す時は[Shift + cmd + o]でファイル名を入れるとインクリメンタルサーチがかかる)
    
5. sdkの管理について    
    ~/Library/Android/sdk/build-tools配下にDLしたSDKのバージョンが一覧できる    
    追加でSDKをDLする場合はAndroidStudioの Tools->Android->SDK Managerにて必要分をDL可能    
        
6. コマンドによるアプリのビルドとインストールについて    
    プロジェクトのトップ階層にて[./gradlew tasks]とすると、実行可能なタスク一覧が出る(※JDKが入っていないとエラーになる)    
    ./gradlew build とするとアプリがビルドできます    
    adb install -r app/build/outputs/apk/app-debug.apk とするとapkがデバイスにインストールされます    
    adb devicesとすると、現在マシンに接続されているデバイス一覧が表示されます

■今回登場した便利ショートカットキー
- アプリのビルド: Ctrl + r
- アプリのデバッグビルド: Ctrl + d
- ファイル検索: Shift + Cmd + o (Shift3回タップでも可能)
