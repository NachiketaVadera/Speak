# Speak

## Summary

The base of this project is Android Text to Speech. While reading, I come across some heavy words that are hard to pronounce. Android 6.0 Marshmallow introduced a new floating text selection toolbar, which brings the standard text selection actions, like cut, copy, and paste, closer to the text you’ve selected. Even better though is the new ACTION_PROCESS_TEXT which makes it possible for any app to add custom actions to that text selection toolbar.


![alt text](https://cdn-images-1.medium.com/max/1600/1*D4zZzPlBTk5cEN9Qn0-cBA.gif)


Taking advantage of this feature, this app passes the selected text to itself and speaks it out.

## Code

The majority of the code is written in Java and is simple. For enabling custom text selection:
(1.) AndroidManifest.xml
```xml
      <activity android:name=".MainActivity" android:windowSoftInputMode="stateAlwaysVisible">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>

            <intent-filter>
                <action android:name="android.intent.action.PROCESS_TEXT"/>

                <category android:name="android.intent.category.DEFAULT" />

                <data android:mimeType="text/*"/>
            </intent-filter>
        </activity>
```

(2.) MainActivity.java
```java
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.process_text_main);
          CharSequence text = getIntent().getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT);
          // process the text
      }
```

## Contributing

Any help, including feedback, is highly appriciated. I have just started out with Android and I’m relatively new to app development.

1. Fork it!
2. Create your feature branch: `git checkout -b new-branch`
3. Commit your changes: `git commit -am 'Make a valuable addition'`
4. Push to the branch: `git push origin new-feature`
5. Submit a pull request :D

## Next Step

Once staretd, an app can never be completely finished. 

1. Custom settings for the voice.
2. Move on from text selections to files.
3. Add new Speak features (read out jokes, facts, quotes etc).
4. Read notofications and messaged aloud. 
