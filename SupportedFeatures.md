## Version 1.6.2, 3rd of October 2010  bug fixes ##

  * [issue #75](https://code.google.com/p/g2android/issues/detail?id=#75) some cached pictures would not appear

## Version 1.6.1, 2nd of October 2010  bug fixes ##

  * [issue #65](https://code.google.com/p/g2android/issues/detail?id=#65) collision if several pictures have the same filename in different albums
  * [issue #58](https://code.google.com/p/g2android/issues/detail?id=#58) Can't enter an IP as Gallery URL
  * [issue #38](https://code.google.com/p/g2android/issues/detail?id=#38) Cannot connect to international domain names

## Version 1.6.0, 25th of August 2010  Major release ##

  * [issue #19](https://code.google.com/p/g2android/issues/detail?id=#19) zoom feature, using the standard Android gallery app
  * [issue #45](https://code.google.com/p/g2android/issues/detail?id=#45) Deleted image via browser, crashed g2android.
  * [issue #46](https://code.google.com/p/g2android/issues/detail?id=#46) Upload from inside g2android won't do multiple images
  * [issue #48](https://code.google.com/p/g2android/issues/detail?id=#48) Current album is not pre selected when adding a photo to it
  * [issue #49](https://code.google.com/p/g2android/issues/detail?id=#49) when adding a photo, list of albums should be sorted
  * [issue #57](https://code.google.com/p/g2android/issues/detail?id=#57) Uploading images are automatically given a g2android summary and description
And also UI improvement for the album view, begin of HTTPS support (#32 for non logged in users)

## Version 1.5.0, 19th of July 2010  Major release ##

  * [issue #33](https://code.google.com/p/g2android/issues/detail?id=#33) Enable uploaded photo title modification
  * [issue #41](https://code.google.com/p/g2android/issues/detail?id=#41) Malformed Gallery 2 URL leads to G2Android forced close
  * [issue #37](https://code.google.com/p/g2android/issues/detail?id=#37) Uploaded photo looses .jpg file extension
  * [issue #42](https://code.google.com/p/g2android/issues/detail?id=#42) Feature Suggestion: Provide automatic login when started
  * [issue #20](https://code.google.com/p/g2android/issues/detail?id=#20) Share via camera app?
  * [issue #15](https://code.google.com/p/g2android/issues/detail?id=#15) Enhancement: Add multiple photo uploading
New graphics from Dan (http://www.gdl3d.com/)
I18N for Chinese (zh\_CN and zh\_TW) provided by http://goapk.com


## Version 1.4.3, 2nd of March 2010  Bug Fixes ##

  * [issue #25](https://code.google.com/p/g2android/issues/detail?id=#25) embedded galleries are now available via g2android
  * [issue #27](https://code.google.com/p/g2android/issues/detail?id=#27) no more errors while quickly browsing the gallery
  * [issue #30](https://code.google.com/p/g2android/issues/detail?id=#30) thanks to the .nomedia file; temporary g2android files won't show up anymore in Android gallery app.


## Version 1.4.2, 23rd of December 2009  Bug Fixes ##

  * SQLLite is now used to save states, for example when you receive a phone call while browsing the gallery, you'll be able to return to the gallery without getting a force close exception


## Version 1.4.1, 29th of November 2009  Bug Fixes ##

  * [issue #17](https://code.google.com/p/g2android/issues/detail?id=#17) (rotating the phone makes navigation reset)
  * [issue #16](https://code.google.com/p/g2android/issues/detail?id=#16) ((really)full screen mode)

## Version 1.4.0, 26th of November 2009  Major release ##

  * cache feature extended to thumbnails
  * sharing and sending photos (via twitter or mail)
  * new "jump to" feature
  * massive refactoring of G2ConnectionUtils, only one API used now
  * [issue #14](https://code.google.com/p/g2android/issues/detail?id=#14) (toast message is late)

## Version 1.3.0, 22nd of October 2009  Major release ##

  * new cache feature
  * fullscreen navigation with gestures
  * download full res. picture to sdcard
  * [issue #7](https://code.google.com/p/g2android/issues/detail?id=#7) (some pictures only render in thumbnail) and
  * [issue #10](https://code.google.com/p/g2android/issues/detail?id=#10) (full screen feature)


## Version 1.2.1, 15th of October 2009  Bug Fixes ##

  * I18N (french language added, if you want to, please translate http://code.google.com/p/g2android/source/browse/trunk/g2android/res/values/strings.xml in your language (the values, not the keys, and I will add your language for next release)
  * [issue #8](https://code.google.com/p/g2android/issues/detail?id=#8) (port parametrizing) and
  * [issue #9](https://code.google.com/p/g2android/issues/detail?id=#9) (don't login at bootup)

## Version 1.2.0, 29th of August 2009  Major release ##

  * upload photo to gallery
  * create new subalbums
  * new progress dialogs (using multi threading AsyncTask)
  * [issue #4](https://code.google.com/p/g2android/issues/detail?id=#4) (navigation not consistent through albums) and
  * [issue #5](https://code.google.com/p/g2android/issues/detail?id=#5) (password in clear text)

## Version 1.1.1, 19th of August 2009  Bug fixes ##

  * [issue #2](https://code.google.com/p/g2android/issues/detail?id=#2) (large galleries with hundreds of albums) and
  * [issue #3](https://code.google.com/p/g2android/issues/detail?id=#3) (dynamic cookie naming)

## Version 1.1, 17th of August 2009 ##

  * New feature : login into the gallery using your username/password, solving [issue #1](https://code.google.com/p/g2android/issues/detail?id=#1)
  * New screen activity added : FirstTime, to explain the user what this project is about

## Version 1.0, 14th of August 2009 ##
  * connection to the remote gallery2 of your choice
  * browsing albums using a basic ListView
  * browsing pictures using Gallery and ImageSwitcher

## Prioritized Product Backlog ##
  * ~~logging into the gallery~~ _added in version 1.1_
  * ~~selection of HTTP port~~ _added in version 1.1_
  * ~~display progress bar (or circles) to make the user wait while retrieving the infos~~ _added in version 1.2.0_
  * ~~sending photos from the phone to the remote gallery~~ _added in version 1.2.0_
  * ~~creating new albums~~ _added in version 1.2.0_
  * ~~test the app with an android advanced device skin (larger display than 320pix., example : archos devices) : http://appslib.com~~ _tested in version 1.2.0_
  * ~~i18n at least french, spanish and chinese, ask the community to translate in other languages, make sure every string is present in http://code.google.com/p/g2android/source/browse/trunk/g2android/res/values/strings.xml~~
  * ~~downloading and saving pictures from the gallery to the phone~~
  * ~~share a photo link via twitter, gmail, mail, etc...~~
  * ~~sending photos from the camera or other graphical applications to the remote gallery~~
  * make the ui look better (custom views, not Android default views)
  * Show FAQ/Troubleshooting wiki page in the about screen


## Features that WON'T be released ##
  * HTTPS connection with a non valid SSL certificate
  * check for updates and then ask the user whether he wants to upgrade using the android market or not (because Android Market seems to do it now)
  * save galleries infos : instead of saving the gallery infos in the settings, save them into a SQLLite DB : users would be able to save multiple galleries and choose between them at the start screen